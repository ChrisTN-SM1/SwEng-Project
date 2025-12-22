package it.ludina.bugboard26.bugboard26frontend;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SegnalaIssueController implements Initializable {

    @FXML
    private TextField titoloTextField;
    @FXML
    private TextArea descrizioneTextArea;
    @FXML
    private ChoiceBox<String> tipologiaChoiceBox;
    private final String[] tipologie = {"Question", "Bug", "Documentation", "Feature"};
    @FXML
    private ChoiceBox<String> prioritaChoiceBox;
    private final String[] priorities = {"Vitale", "Alta", "Media", "Bassa"};
    @FXML
    public Button allegaFileButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tipologiaChoiceBox.getItems().addAll(tipologie);
        prioritaChoiceBox.getItems().addAll(priorities);
    }


    public void annulla(ActionEvent event) {
        WindowManager.chiudiFinestra(event);
    }


    public void conferma(ActionEvent event) {
        String titolo  = titoloTextField.getText();
        String descrizione = descrizioneTextArea.getText();
        String tipologia = tipologiaChoiceBox.getValue();
        String priorita = prioritaChoiceBox.getValue();
        String immagine = ""; //deve esser file immagine

        if(priorita == null) priorita = "Non_specificata";

        if(titolo.isBlank() || descrizione.isBlank() || tipologia == null) {
            WindowManager.apriFinestra("segnala-issue/campo-obbligatorio-vuoto.fxml");
        } else {
            HTTPRequestManager.segnalaIssue(titolo, descrizione, tipologia, priorita, immagine);
            //homepage.reload
            WindowManager.chiudiFinestra(event);
        }
    }
}
