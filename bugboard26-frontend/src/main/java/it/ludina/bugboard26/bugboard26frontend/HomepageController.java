package it.ludina.bugboard26.bugboard26frontend;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;

import javax.xml.transform.Source;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomepageController implements Initializable {

    @FXML
    Tab listaIssueTab;
    @FXML
    Tab archivioTab;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            listaIssueTab.setContent(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("lista-issue.fxml"))));
            archivioTab.setContent(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("archivio.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void mostraSegnalaIssue() {
        WindowManager.apriFinestra("segnala-issue/segnala-issue.fxml");
    }


    public void mostraCreaNuovaUtenza(){
        WindowManager.apriFinestra("crea-nuova-utenza.fxml");
    }


    public void reloadPage(){
        initialize(null,null);
    }
}
