package it.ludina.bugboard26.bugboard26frontend;

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


    public static void impostaStatoCompletato(int idIssue){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URI + "issue/complete"))
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
                .uri(URI.create(BASE_URI + "issue/archive"))
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

    public static List<Issue> getArchivio(){
        ArrayList<Issue> lista = new ArrayList<>();
        lista.add(new Issue(30, "ciao", "ciao23", "de", "da", "da", "ds"));
        return lista;
    }
    public static List<Issue> getListaIssue(){
        return null;
    }

}
