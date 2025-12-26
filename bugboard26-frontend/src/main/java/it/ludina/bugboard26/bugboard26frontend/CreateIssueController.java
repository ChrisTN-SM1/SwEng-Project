package it.ludina.bugboard26.bugboard26frontend;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateIssueController implements Initializable {

    @FXML
    private TextField titleTextField;
    @FXML
    private TextArea descriptionTextArea;
    @FXML
    private ChoiceBox<String> issueTypeChoiceBox;
    private final String[] types = {"Question", "Bug", "Documentation", "Feature"};
    @FXML
    private ChoiceBox<String> priorityChoiceBox;
    private final String[] priorities = {"Vitale", "Alta", "Media", "Bassa"};
    @FXML
    public Button allegaFileButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        issueTypeChoiceBox.getItems().addAll(types);
        priorityChoiceBox.getItems().addAll(priorities);
    }


    public void annullaButton(ActionEvent event) {
        WindowManager.closeWindow(event);
    }


    public void confermaButton(ActionEvent event) {
        String title  = titleTextField.getText();
        String description = descriptionTextArea.getText();
        String issueType = issueTypeChoiceBox.getValue();
        String priority = priorityChoiceBox.getValue();
        String image = ""; //deve esser file immagine

        if(priority == null) priority = "Non_specificata";

        if(title.isBlank() || description.isBlank() || issueType == null) {
            WindowManager.openWindow("errors/mandatory-field-empty.fxml");
        } else {
            HTTPRequestManager.createIssue(title, description, issueType, priority, image);
            //homepage.reload
            WindowManager.closeWindow(event);
        }
    }
}
