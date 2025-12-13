package it.ludina.bugboard26fe.bugboard26frontend;

import javafx.event.ActionEvent;

public class LoginController {

    public void login(ActionEvent event) {
        // If tutto bene
        WindowManager.apriFinestra("homepage.fxml");
        WindowManager.chiudiFinestra(event);
    }
}