package it.ludina.bugboard26.bugboard26frontend.IssueDetails;

import it.ludina.bugboard26.bugboard26frontend.WindowManager;
import javafx.event.ActionEvent;

public class AssignIssueController {

    public void annullaButton(ActionEvent event) {
        WindowManager.closeWindow(event);
    }


    public void confermaButton(ActionEvent event) {
        //fai cose
        WindowManager.closeWindow(event);
    }
}
