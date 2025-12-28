package it.ludina.bugboard26.bugboard26frontend;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class HomepageController {

    @FXML
    Tab issueListTab;
    @FXML
    Tab archiveTab;
    @FXML
    Button createUserButton;

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


    public void init(String userType) {
        if (userType.equals("simple")) {
            createUserButton.setVisible(false);
        }
    }
}
