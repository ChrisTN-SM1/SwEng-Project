package it.ludina.bugboard26.bugboard26frontend;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class HTTPRequestManager {
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final String BASE_URI = "http://localhost:8080/";
    private static String token;
    static ObjectMapper objectMapper = new ObjectMapper();


    public static void setStateCompleted(int issueId){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URI + "issues/setcompleted"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .PUT(HttpRequest.BodyPublishers.ofString("{\"id\":\"" + issueId + "\"}"))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void setStateArchived(int issueId){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URI + "issues/setarchived"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .PUT(HttpRequest.BodyPublishers.ofString("{\"id\":\"" + issueId + "\"}"))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void createIssue(String title, String description, String issueType, String priority, String imageURL){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URI + "issues/" + issueType.toLowerCase() +"/"))
                .header("Content-Type", "application/json")
                //.header("Authorization", "Bearer " + token)
                .POST(HttpRequest.BodyPublishers.ofString
                        ("{\"titolo\":\"" + title + "\"," +
                                "\"descrizione\":\"" + description + "\"," +
                                "\"priorita\":\"" + priority.toUpperCase() + "\", " +
                                "\"urlImmagine\":\"" + imageURL + "\"}"))
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
                //.header("Authorization", "Bearer " + token)
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


    public static List<Issue> getArchive(){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URI + "issues/archive/"))
                .header("Content-Type", "application/json")
                //.header("Authorization", "Bearer " + token)
                .GET()
                .build();
        return getList(request);
    }


    public static List<Issue> getIssueList(){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URI + "issues/list/"))
                .header("Content-Type", "application/json")
                //.header("Authorization", "Bearer " + token)
                .GET()
                .build();
        return getList(request);
    }


    private static List<Issue> getList(HttpRequest request) {
        Issue[] list;
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            list = objectMapper.readValue(response.body(), Issue[].class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>(List.of(list));
    }
}
