package it.ludina.bugboard26fe.bugboard26frontend;

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
