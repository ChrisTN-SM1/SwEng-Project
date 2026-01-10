package it.ludina.bugboard26frontend;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

import javax.security.auth.login.LoginException;

public class HTTPRequestManager {
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final String BASE_URI = "http://localhost:8080/";
    static Gson gson = new Gson();

    private HTTPRequestManager(){}

    public static void login(String email, String password) throws LoginException{
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URI + "authentication/"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString
                        ("{\"email\":\"" + email + "\"," +
                                "\"password\":\"" + password + "\"}"))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 404) throw new LoginException();
            Type mapType = new TypeToken<HashMap<String, String>>() {}.getType();
            HashMap<String, String > map = gson.fromJson(response.body(), mapType);
            Session currentSession = Session.getInstance();
            currentSession.setToken(map.get("token"));
            currentSession.setUserType(map.get("userType"));
            currentSession.setUserEmail(email);

        } catch (IOException | InterruptedException e) {
            throw new LoginException();
        }
    }


    public static void setStateCompleted(int issueId){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URI + "issues/setcompleted/"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + Session.getInstance().getToken())
                .PUT(HttpRequest.BodyPublishers.ofString("{\"idIssue\":" + issueId + "}"))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void setStateArchived(int issueId){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URI + "issues/setarchived/"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + Session.getInstance().getToken())
                .PUT(HttpRequest.BodyPublishers.ofString("{\"idIssue\":" + issueId + "}"))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void createIssue(String title, String description, String issueType, String priority, File image){

        String encodedFile;

        if(image == null)
            encodedFile = "";
        else {
            byte[] imageBytes;
            try {
                imageBytes = FileUtils.readFileToByteArray(image);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            encodedFile = Base64.getEncoder().encodeToString(imageBytes);
        }
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URI + "issues/" + issueType.toLowerCase() +"/"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + Session.getInstance().getToken())
                .POST(HttpRequest.BodyPublishers.ofString
                        ("{\"title\":\"" + title + "\"," +
                                "\"description\":\"" + description + "\"," +
                                "\"priority\":\"" + priority.toUpperCase() + "\", " +
                                "\"image\":\"" + encodedFile + "\"}"))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void createUser(String email, String password, String userType){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URI + "user/" + userType.toLowerCase() +"/"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + Session.getInstance().getToken())
                .POST(HttpRequest.BodyPublishers.ofString
                        ("{\"email\":\"" + email + "\"," +
                                "\"password\":\"" + password + "\"}"))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static List<Issue> getIssueList(){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URI + "issues/list/"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + Session.getInstance().getToken())
                .GET()
                .build();
        return getIssueTypeList(request);
    }


    public static List<Issue> getArchive(){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URI + "issues/archive/"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + Session.getInstance().getToken())
                .GET()
                .build();
        return getIssueTypeList(request);
    }


    private static List<Issue> getIssueTypeList(HttpRequest request) {
        Issue[] list;
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            list = gson.fromJson(response.body(), Issue[].class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>(List.of(list));
    }


    public static List<String> getAssignedTo(int issueId){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URI + "assignment/assignedto/" + issueId + "/"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + Session.getInstance().getToken())
                .GET()
                .build();

        return getStringTypeList(request);
    }


    public static List<String> getNotAssignedTo(int issueId){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URI + "assignment/notassignedto/" + issueId + "/"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + Session.getInstance().getToken())
                .GET()
                .build();

        return getStringTypeList(request);
    }


    private static List<String> getStringTypeList(HttpRequest request) {
        List<String> list;
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Type mapType = new TypeToken<ArrayList<String>>() {}.getType();
            list = gson.fromJson(response.body(), mapType);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return list;
    }


    public static void assignIssue(int idIssue, List<String> selectedEmails) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URI + "assignment/"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + Session.getInstance().getToken())
                .POST(HttpRequest.BodyPublishers.ofString(
                        "{\"idIssue\":" + idIssue + "," +
                              "\"emails\":" + gson.toJson(selectedEmails.toArray()) + "}"
                ))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static String getIssueImage(int issueId){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URI + "issues/" + issueId + "/getImage/"))
                .header("Content-Type", "text/plain")
                .header("Authorization", "Bearer " + Session.getInstance().getToken())
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
