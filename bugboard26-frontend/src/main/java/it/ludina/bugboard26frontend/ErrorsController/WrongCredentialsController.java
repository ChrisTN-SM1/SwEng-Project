package it.ludina.bugboard26frontend.ErrorsController;

import it.ludina.bugboard26frontend.WindowManager;
import javafx.event.ActionEvent;

public class WrongCredentialsController {
    public void okButtonPressed(ActionEvent actionEvent) {
        WindowManager.closeWindow(actionEvent);
    }
}
