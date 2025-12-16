package it.ludina.bugboard26.bugboard26frontend;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ArchivioController implements Initializable {
    @FXML
    private TableView<Issue> archivioTable;
    @FXML
    private TableColumn<Issue, Integer> idColumn;
    @FXML
    private TableColumn<Issue, String> titoloColumn;
    @FXML
    private TableColumn<Issue, String> tipologiaColumn;
    @FXML
    private TableColumn<Issue, String> prioritaColumn;
    @FXML
    private TableColumn<Issue, String> statoColumn;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Issue> lista = FXCollections.observableArrayList(HTTPRequestManager.getArchivio());

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        titoloColumn.setCellValueFactory(new PropertyValueFactory<>("titolo"));
        tipologiaColumn.setCellValueFactory(new PropertyValueFactory<>("tipologia"));
        prioritaColumn.setCellValueFactory(new PropertyValueFactory<>("titolo"));
        statoColumn.setCellValueFactory(new PropertyValueFactory<>("stato"));

        archivioTable.setItems(lista);
    }
}
