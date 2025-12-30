package it.ludina.bugboard26frontend.IssueDetails;

import it.ludina.bugboard26frontend.HTTPRequestManager;
import it.ludina.bugboard26frontend.HomepageController;
import it.ludina.bugboard26frontend.WindowManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Getter
@Setter
public class AssignIssueController implements Initializable {
    @FXML
    Button confermaButton = getConfermaButton();
    @FXML
    private ListView<String> emailListView;
    private int idIssue;


    public void annullaButtonPressed(ActionEvent event) {
        WindowManager.closeWindow(event);
    }


    public void confermaButtonPressed(ActionEvent event) {
        //fai cose
        WindowManager.closeWindow(event);
        HomepageController homepageController = HomepageController.getHomepageController();
        try {
            homepageController.reloadPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> emailList = FXCollections.observableArrayList(HTTPRequestManager.getNotAssignedTo(idIssue));
        emailListView.setItems(emailList);
    }
}
