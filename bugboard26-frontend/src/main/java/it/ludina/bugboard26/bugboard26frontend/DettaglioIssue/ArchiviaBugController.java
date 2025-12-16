package it.ludina.bugboard26.bugboard26frontend.DettaglioIssue;

import it.ludina.bugboard26.bugboard26frontend.WindowManager;
import javafx.event.ActionEvent;

public class ArchiviaBugController {
    public void annulla(ActionEvent event) {
        WindowManager.chiudiFinestra(event);
    }


    public void procedi(ActionEvent event) {
        //HTTPRequestManager.archivia(idIssue);
        WindowManager.chiudiFinestra(event);
    }
}
