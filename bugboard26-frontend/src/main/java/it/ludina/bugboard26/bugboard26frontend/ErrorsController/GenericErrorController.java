package it.ludina.bugboard26.bugboard26frontend.ErrorsController;

import it.ludina.bugboard26.bugboard26frontend.WindowManager;
import javafx.event.ActionEvent;

public class GenericErrorController {
    public void okButtonPressed(ActionEvent event){
        WindowManager.closeWindow(event);
    }
}
