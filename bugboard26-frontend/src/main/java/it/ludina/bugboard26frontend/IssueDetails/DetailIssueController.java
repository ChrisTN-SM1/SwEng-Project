package it.ludina.bugboard26frontend.IssueDetails;

import it.ludina.bugboard26frontend.HTTPRequestManager;
import it.ludina.bugboard26frontend.Issue;
import it.ludina.bugboard26frontend.Session;
import it.ludina.bugboard26frontend.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.List;

public class DetailIssueController {
    @FXML
    private Label idLabel;
    @FXML
    private Label titleLabel;
    @FXML
    private Label descriptionLabel;
    @FXML
    private Label issueTypeLabel;
    @FXML
    private Label priorityLabel;
    @FXML
    private Label stateLabel;
    @FXML
    private Label assignedToLabel;
    @FXML
    private Button setStateCompletedButton;
    @FXML
    private Button archiveButton;
    @FXML
    private Button assignIssueButton;

    private int idIssue;


    public void getIssueDetails(Issue issue){

        idIssue = issue.getIdIssue();

        this.idLabel.setText(String.valueOf(issue.getIdIssue()));
        this.titleLabel.setText(issue.getTitle());
        this.descriptionLabel.setText(issue.getDescription());
        this.issueTypeLabel.setText(issue.getIssueType());
        this.priorityLabel.setText(issue.getPriority());
        this.stateLabel.setText(issue.getState());

        List<String> assignedTo = HTTPRequestManager.getAssignedTo(issue.getIdIssue());

        this.assignedToLabel.setText(assignedTo.toString());

        if(!issue.getIssueType().equals("bug") || issue.getState().equals("ARCHIVIATO") || Session.getInstance().getUserType().equals("normale")){
            archiveButton.setVisible(false);
        }
        if(Session.getInstance().getUserType().equals("normale")){
            assignIssueButton.setVisible(false);
        }
        if(!(assignedTo.contains(Session.getInstance().getUserEmail()))) {
            setStateCompletedButton.setVisible(false);
        }
    }


    public void showArchiveBug(ActionEvent event){
        FXMLLoader fxmlloader = WindowManager.openWindow("issue-details/archive-bug.fxml");
        ArchiveBugController controller = fxmlloader.getController();
        controller.setIdIssue(idIssue);
        controller.procediButton.setOnAction(childEvent -> {
            WindowManager.closeWindow(event);
            controller.procediButtonPressed(childEvent);
        });
    }


    public void showAssignIssue(ActionEvent event){
        FXMLLoader fxmlloader = WindowManager.openWindow("issue-details/assign-issue.fxml");
        AssignIssueController controller = fxmlloader.getController();
        controller.setIdIssue(idIssue);
        controller.confermaButton.setOnAction(childEvent -> {
           WindowManager.closeWindow(event);
           controller.confermaButtonPressed(childEvent);
        });
    }


    public void showSetStateCompleted(ActionEvent event){
        FXMLLoader fxmlloader = WindowManager.openWindow("issue-details/set-state-completed.fxml");
        SetStateCompletedController controller = fxmlloader.getController();
        controller.setIdIssue(idIssue);
        controller.procediButton.setOnAction(childEvent -> {
            WindowManager.closeWindow(event);
            controller.procediButtonPressed(childEvent);
        });
    }


    public void showViewImage(){
        WindowManager.openWindow("issue-details/view-image.fxml");
    }
}
