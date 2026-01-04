package it.ludina.bugboard26frontend.errors;

import it.ludina.bugboard26frontend.WindowManager;
import javafx.event.ActionEvent;

public class GenericErrorController {
    public void okButtonPressed(ActionEvent event){
        WindowManager.closeWindow(event);
    }
}
