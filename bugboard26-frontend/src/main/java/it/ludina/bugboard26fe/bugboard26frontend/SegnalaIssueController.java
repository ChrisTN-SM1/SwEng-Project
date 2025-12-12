package it.ludina.bugboard26fe.bugboard26frontend;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class SegnalaIssueController {
    public void annulla(ActionEvent event) {
        WindowManager.chiudiFinestra(event);
    }

    public void conferma(ActionEvent event) {
        //Fai roba
        WindowManager.chiudiFinestra(event);
    }
}
