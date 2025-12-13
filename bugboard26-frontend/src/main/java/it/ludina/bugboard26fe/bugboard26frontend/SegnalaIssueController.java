package it.ludina.bugboard26fe.bugboard26frontend;

import javafx.event.ActionEvent;

public class SegnalaIssueController {
    public void annulla(ActionEvent event) {
        WindowManager.chiudiFinestra(event);
    }

    public void conferma(ActionEvent event) {
        //Fai roba
        WindowManager.chiudiFinestra(event);
    }
}
