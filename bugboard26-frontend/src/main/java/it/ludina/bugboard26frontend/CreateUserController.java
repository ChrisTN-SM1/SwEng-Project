package it.ludina.bugboard26frontend;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

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

        Pattern regex = Pattern.compile("(?:[a-z0-9!#$%&'*+\\x2f=?^_`\\x7b-\\x7d~\\x2d]+" +
                "(?:\\.[a-z0-9!#$%&'*+\\x2f=?^_`\\x7b-\\x7d~\\x2d]+)*" +
                "|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")" +
                "@(?:(?:[a-z0-9](?:[a-z0-9\\x2d]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9\\x2d]" +
                "*[a-z0-9])?|\\[(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])\\.)" +
                "{3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9\\x2d]*[a-z0-9]:" +
                "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])");

        if(email.isEmpty() || password.isEmpty() || userType == null) {
            WindowManager.openWindow("errors/mandatory-field-empty.fxml");
        } else if(!(regex.matcher(email).matches())) {
            WindowManager.openWindow("errors/invalid-email.fxml");
        } else {
            HTTPRequestManager.createUser(email, password, userType);
            WindowManager.closeWindow(event);
        }
    }
}
