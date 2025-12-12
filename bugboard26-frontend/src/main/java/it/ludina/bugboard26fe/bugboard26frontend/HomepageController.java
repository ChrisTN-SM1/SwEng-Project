package it.ludina.bugboard26fe.bugboard26frontend;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomepageController {

    public void mostraSchermataSegnalaIssue(ActionEvent event) {
        WindowManager.apriFinestra("segnala-issue.fxml");
    }

    public void mostraSchermataCreaNuovaUtenza(){
        WindowManager.apriFinestra("crea-nuova-utenza.fxml");
    }

}
