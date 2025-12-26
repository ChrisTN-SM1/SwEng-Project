package it.ludina.bugboard26.bugboard26frontend.IssueDetails;

import it.ludina.bugboard26.bugboard26frontend.WindowManager;
import javafx.event.ActionEvent;

public class ArchiveBugController {
    public void annullaButton(ActionEvent event) {
        WindowManager.closeWindow(event);
    }


    public void procediButton(ActionEvent event) {
        //HTTPRequestManager.archive(idIssue);
        WindowManager.closeWindow(event);
    }
}
