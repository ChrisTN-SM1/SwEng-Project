package it.ludina.bugboard26frontend.errors;

import it.ludina.bugboard26frontend.WindowManager;
import javafx.event.ActionEvent;

public class InvalidEmailController {
    public void okButtonPressed(ActionEvent actionEvent) {
        WindowManager.closeWindow(actionEvent);
    }
}
