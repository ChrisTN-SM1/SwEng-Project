package it.ludina.bugboard26.bugboard26frontend.IssueDetails;

import it.ludina.bugboard26.bugboard26frontend.WindowManager;

public class DetailIssueController {

    public void showArchiveBug(){
        WindowManager.openWindow("archive-bug.fxml");
    }


    public void showAssignIssue(){
        WindowManager.openWindow("assign-issue.fxml");
    }


    public void showSetStateCompleted(){
        WindowManager.openWindow("set-state-completed.fxml");
    }


    public void showViewImage(){
        WindowManager.openWindow("view-image.fxml");
    }
}
