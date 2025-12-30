package it.ludina.bugboard26frontend.IssueDetails;

import it.ludina.bugboard26frontend.HTTPRequestManager;
import it.ludina.bugboard26frontend.HomepageController;
import it.ludina.bugboard26frontend.WindowManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@Setter
@Getter
public class ArchiveBugController {
    @FXML
    Button procediButton = getProcediButton();
    private int idIssue;


    public void annullaButtonPressed(ActionEvent event) {
        WindowManager.closeWindow(event);
    }


    public void procediButtonPressed(ActionEvent event) {
        HTTPRequestManager.setStateArchived(idIssue);
        WindowManager.closeWindow(event);
        HomepageController homepageController = HomepageController.getHomepageController();
        try {
            homepageController.reloadPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
