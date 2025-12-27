package it.ludina.bugboard26.bugboard26frontend;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML

    public void loginButtonPressed(ActionEvent event) {
        String email = emailField.getText();
        String password = passwordField.getText();

        switch(HTTPRequestManager.login(email, password)) {
            case 1:
                WindowManager.openWindow("errors/inexistent-user.fxml");
                break;

            case 2:
                WindowManager.openWindow("errors/wrong-password.fxml");
                break;

            case 3:
                WindowManager.openWindow("homepage.fxml");
                WindowManager.closeWindow(event);
                break;
        }
    }
}