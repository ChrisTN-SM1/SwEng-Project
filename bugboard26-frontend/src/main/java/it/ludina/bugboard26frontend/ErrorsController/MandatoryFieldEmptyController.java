package it.ludina.bugboard26frontend.ErrorsController;

import it.ludina.bugboard26frontend.WindowManager;
import javafx.event.ActionEvent;

public class MandatoryFieldEmptyController {

    public void okButtonPressed(ActionEvent event) {
        WindowManager.closeWindow(event);
    }
}
