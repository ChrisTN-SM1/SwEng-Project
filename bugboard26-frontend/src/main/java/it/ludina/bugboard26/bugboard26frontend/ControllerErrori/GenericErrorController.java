package it.ludina.bugboard26.bugboard26frontend.ControllerErrori;

import it.ludina.bugboard26.bugboard26frontend.WindowManager;
import javafx.event.ActionEvent;

public class GenericErrorController {
    public void ok(ActionEvent event){
        WindowManager.chiudiFinestra(event);
    }
}
