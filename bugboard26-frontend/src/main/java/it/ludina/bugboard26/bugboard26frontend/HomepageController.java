package it.ludina.bugboard26.bugboard26frontend;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HomepageController {

    public void initialize(){

    }

    public void mostraSegnalaIssue() {
        WindowManager.apriFinestra("segnala-issue/segnala-issue.fxml");
    }

    public void mostraCreaNuovaUtenza(){
        WindowManager.apriFinestra("crea-nuova-utenza.fxml");
    }

    public void getAllIssues(){
        //fa cose
    }
}
