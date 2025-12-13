package it.ludina.bugboard26fe.bugboard26frontend;

public class HomepageController {

    public void initialize(){

    }

    public void mostraSegnalaIssue() {
        WindowManager.apriFinestra("segnala-issue.fxml");
    }

    public void mostraCreaNuovaUtenza(){
        WindowManager.apriFinestra("crea-nuova-utenza.fxml");
    }

    public void getAllIssues(){
        //fa cose
    }

}
