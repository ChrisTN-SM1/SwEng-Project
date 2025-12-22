package it.ludina.bugboard26.bugboard26frontend;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.net.http.HttpRequest;
import java.util.ResourceBundle;

public class CreaNuovaUtenzaController implements Initializable {
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private ChoiceBox<String> tipologiaChoiceBox;
    private final String[] tipologie = {"Amministratore", "Normale"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tipologiaChoiceBox.getItems().addAll(tipologie);
    }


    public void annulla(ActionEvent event) {
        WindowManager.chiudiFinestra(event);
    }


    public void conferma(ActionEvent event) {
        String email = emailTextField.getText();
        String password = passwordTextField.getText();
        String tipologia = tipologiaChoiceBox.getValue();

        if(email.isEmpty() || password.isEmpty() || tipologia.isEmpty()) {
            WindowManager.apriFinestra("errori/campo-obbligatorio-vuoto.fxml");
        }
        else {
            HTTPRequestManager.creaNuovaUtenza(email, password, tipologia);
            WindowManager.chiudiFinestra(event);
        }
    }
}
