package it.ludina.bugboard26fe.bugboard26frontend;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

public class SegnalaIssueController implements Initializable {

    @FXML
    private ChoiceBox<String> tipologiaChoiceBox;
    private final String[] tipologie = {"Question", "Bug", "Documentation", "Feature"};

    @FXML
    private ChoiceBox<String> priorityChoiceBox;
    private final String[] priorities = {"Vitale", "Alta", "Media", "Bassa"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tipologiaChoiceBox.getItems().addAll(tipologie);
        priorityChoiceBox.getItems().addAll(priorities);
    }

    public void annulla(ActionEvent event) {
        WindowManager.chiudiFinestra(event);
    }

    public void conferma(ActionEvent event) {
        //Fai roba
        WindowManager.chiudiFinestra(event);
    }

}
