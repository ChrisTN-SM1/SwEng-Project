package it.ludina.bugboard26frontend;

import javax.security.auth.login.LoginException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;


    public void loginButtonPressed(ActionEvent event) {
        String email = emailField.getText();
        String password = passwordField.getText();

        try {
            HTTPRequestManager.login(email, password);
            WindowManager.openWindow("homepage.fxml");
            WindowManager.closeWindow(event);
        } catch(LoginException e) {
            WindowManager.openWindow("errors/wrong-credentials.fxml");
        }
    }
}