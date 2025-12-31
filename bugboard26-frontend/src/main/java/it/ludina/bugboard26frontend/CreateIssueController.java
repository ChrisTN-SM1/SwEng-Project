package it.ludina.bugboard26frontend;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
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
    private Button allegaFileButton;
    @FXML
    private Label imagePathLabel;
    File file;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        issueTypeChoiceBox.getItems().addAll(types);
        priorityChoiceBox.getItems().addAll(priorities);
    }


    public void addImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png"));
        file = fileChooser.showOpenDialog(null);
        if (file != null) {
            imagePathLabel.setText(file.getAbsolutePath());
        }
    }


    public void annullaButtonPressed(ActionEvent event) {
        WindowManager.closeWindow(event);
    }


    public void confermaButtonPressed(ActionEvent event){
        String title  = titleTextField.getText();
        String description = descriptionTextArea.getText();
        String issueType = issueTypeChoiceBox.getValue();
        String priority = priorityChoiceBox.getValue();


        if(priority == null) priority = "Non_specificata";

        if(title.isBlank() || description.isBlank() || issueType == null) {
            WindowManager.openWindow("errors/mandatory-field-empty.fxml");
        } else {
            HTTPRequestManager.createIssue(title, description, issueType, priority, file);
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
