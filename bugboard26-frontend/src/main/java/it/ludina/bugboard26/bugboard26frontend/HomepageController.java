package it.ludina.bugboard26.bugboard26frontend;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomepageController implements Initializable {

    @FXML
    Tab issueListTab;
    @FXML
    Tab archiveTab;
    @FXML
    Button createUserButton;

    public void initialize(URL location, ResourceBundle resources) {
        if (Session.getInstance().getUserType().equals("normale"))
            createUserButton.setVisible(false);
    }


    public void showCreateIssue() {
        WindowManager.openWindow("create-issue.fxml");
    }


    public void showCreateUser(){
        WindowManager.openWindow("create-user.fxml");
    }


    public void reloadPage() throws IOException {
        AnchorPane issueList = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("issue-list.fxml")));
        AnchorPane archive = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("archive.fxml")));
        issueListTab.setContent(issueList);
        archiveTab.setContent(archive);
    }
}
