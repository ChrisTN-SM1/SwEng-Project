package it.ludina.bugboard26frontend;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Getter
@Setter
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


    public void annullaButtonPressed(ActionEvent event) {
        WindowManager.closeWindow(event);
    }


    public void confermaButtonPressed(ActionEvent event){
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
            WindowManager.closeWindow(event);
            HomepageController homepageController = HomepageController.getHomepageController();
            try {
                homepageController.reloadPage();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
