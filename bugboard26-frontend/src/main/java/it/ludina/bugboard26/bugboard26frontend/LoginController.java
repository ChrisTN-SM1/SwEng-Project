package it.ludina.bugboard26.bugboard26frontend;

import javafx.event.ActionEvent;

public class LoginController {

    public void login(ActionEvent event) {
        // If tutto bene
        WindowManager.openWindow("homepage.fxml");
        WindowManager.closeWindow(event);
    }
}