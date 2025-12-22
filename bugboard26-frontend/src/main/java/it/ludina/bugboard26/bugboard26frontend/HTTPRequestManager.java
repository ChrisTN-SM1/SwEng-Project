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


    public static void impostaStatoCompletato(int idIssue){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URI + "issues/setcompleted"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .PUT(HttpRequest.BodyPublishers.ofString("{\"id\":\"" + idIssue + "\"}"))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void archivia(int idIssue){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URI + "issues/setarchived"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .PUT(HttpRequest.BodyPublishers.ofString("{\"id\":\"" + idIssue + "\"}"))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void segnalaIssue(String titolo, String descrizione, String tipologia, String priorita, String urlImmagine){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URI + "issues/" + tipologia.toLowerCase() +"/"))
                .header("Content-Type", "application/json")
                //.header("Authorization", "Bearer " + token)
                .POST(HttpRequest.BodyPublishers.ofString
                        ("{\"titolo\":\"" + titolo + "\"," +
                                "\"descrizione\":\"" + descrizione + "\"," +
                                "\"priorita\":\"" + priorita.toUpperCase() + "\", " +
                                "\"urlImmagine\":\"" + urlImmagine + "\"}"))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void creaNuovaUtenza(String email, String password, String tipologia){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URI + "user/newuser" +"/"))
                .header("Content-Type", "application/json")
                //.header("Authorization", "Bearer " + token)
                .POST(HttpRequest.BodyPublishers.ofString
                        ("{\"email\":\"" + email + "\"," +
                                "\"password\":\"" + password + "\"," +
                                "\"tipologia\":\"" + tipologia + "\"}"))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static List<Issue> getArchivio(){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URI + "issues/archive/"))
                .header("Content-Type", "application/json")
                //.header("Authorization", "Bearer " + token)
                .GET()
                .build();
        return getList(request);
    }


    public static List<Issue> getListaIssue(){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URI + "issues/list/"))
                .header("Content-Type", "application/json")
                //.header("Authorization", "Bearer " + token)
                .GET()
                .build();
        return getList(request);
    }


    private static List<Issue> getList(HttpRequest request) {
        Issue[] lista;
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            lista = objectMapper.readValue(response.body(), Issue[].class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>(List.of(lista));
    }
}
