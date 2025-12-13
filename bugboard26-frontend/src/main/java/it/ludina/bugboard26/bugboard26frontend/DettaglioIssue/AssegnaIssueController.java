package it.ludina.bugboard26.bugboard26frontend.DettaglioIssue;

import it.ludina.bugboard26.bugboard26frontend.WindowManager;
import javafx.event.ActionEvent;

public class AssegnaIssueController {

    public void annulla(ActionEvent event) {
        WindowManager.chiudiFinestra(event);
    }

    public void conferma(ActionEvent event) {
        //fai cose
        WindowManager.chiudiFinestra(event);
    }
}
