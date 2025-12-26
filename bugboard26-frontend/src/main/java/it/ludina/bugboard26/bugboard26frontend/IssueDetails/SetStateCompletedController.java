package it.ludina.bugboard26.bugboard26frontend.IssueDetails;

import it.ludina.bugboard26.bugboard26frontend.WindowManager;
import javafx.event.ActionEvent;

public class SetStateCompletedController {

    public void annullaButton(ActionEvent event) {
        WindowManager.closeWindow(event);
    }


    public void procediButton(ActionEvent event) {
        //HTTPRequestManager.impostaStatoCompletato(idIssue);
        WindowManager.closeWindow(event);
    }
}
