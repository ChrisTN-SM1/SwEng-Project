package it.ludina.bugboard26.bugboard26frontend.DettaglioIssue;

import it.ludina.bugboard26.bugboard26frontend.WindowManager;

public class DettaglioIssueController {

    public void mostraArchiviaBug(){
        WindowManager.apriFinestra("archivia-bug.fxml");
    }


    public void mostraAssegnaIssue(){
        WindowManager.apriFinestra("assegna-issue.fxml");
    }


    public void mostraImpostaStatoCompletato(){
        WindowManager.apriFinestra("imposta-stato-completato.fxml");
    }


    public void mostraVisualizzaImmagine(){
        WindowManager.apriFinestra("visualizza-immagine.fxml");
    }
}
