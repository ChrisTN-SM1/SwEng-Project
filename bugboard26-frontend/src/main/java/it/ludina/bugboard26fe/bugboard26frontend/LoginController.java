package it.ludina.bugboard26fe.bugboard26frontend;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

public class LoginController {

    public void login(ActionEvent event) {
        // If tutto bene
        WindowManager.apriFinestra("homepage.fxml");
        WindowManager.chiudiFinestra(event);
    }
}