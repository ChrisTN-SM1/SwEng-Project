package it.ludina.bugboard26fe.bugboard26frontend.DettaglioIssue;

import it.ludina.bugboard26fe.bugboard26frontend.WindowManager;
import javafx.event.ActionEvent;

public class ImpostaStatoCompletatoController {

    public void annulla(ActionEvent event) {
        WindowManager.chiudiFinestra(event);
    }

    public void procedi(ActionEvent event) {
        //HTTPRequestManager.impostaStatoCompletato(idIssue);
        WindowManager.chiudiFinestra(event);
    }
}
