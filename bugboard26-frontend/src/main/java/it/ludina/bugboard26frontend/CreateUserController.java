package it.ludina.bugboard26frontend;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateUserController implements Initializable {
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private ChoiceBox<String> userTypeChoiceBox;
    private final String[] userTypes = {"Admin", "Normal"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userTypeChoiceBox.getItems().addAll(userTypes);
    }


    public void annullaButtonPressed(ActionEvent event) {
        WindowManager.closeWindow(event);
    }


    public void confermaButtonPressed(ActionEvent event) {
        String email = emailTextField.getText();
        String password = passwordTextField.getText();
        String userType = userTypeChoiceBox.getValue();

        if(email.isEmpty() || password.isEmpty() || userType == null) {
            WindowManager.openWindow("errors/mandatory-field-empty.fxml");
        }
        else {
            HTTPRequestManager.createUser(email, password, userType);
            WindowManager.closeWindow(event);
        }
    }
}
