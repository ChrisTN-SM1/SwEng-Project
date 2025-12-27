package it.ludina.bugboard26.bugboard26frontend.ErrorsController;

import it.ludina.bugboard26.bugboard26frontend.WindowManager;
import javafx.event.ActionEvent;

public class InexistentUserController {
    public void okButtonPressed(ActionEvent actionEvent) {
        WindowManager.closeWindow(actionEvent);
    }
}
