package it.ludina.bugboard26.bugboard26frontend;

import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class HomepageController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //chiama get all issues
    }


    public void mostraSegnalaIssue() {
        WindowManager.apriFinestra("segnala-issue/segnala-issue.fxml");
    }


    public void mostraCreaNuovaUtenza(){
        WindowManager.apriFinestra("crea-nuova-utenza.fxml");
    }


    public void reloadPage(){
        //initialize();
    }
}
