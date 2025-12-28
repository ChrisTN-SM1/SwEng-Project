package it.ludina.bugboard26.bugboard26frontend;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;

public class IssueListController implements Initializable {
    @FXML
    private TableView<Issue> IssueListTable;
    @FXML
    private TableColumn<Issue, Integer> idColumn;
    @FXML
    private TableColumn<Issue, String> titleColumn;
    @FXML
    private TableColumn<Issue, String> typeColumn;
    @FXML
    private TableColumn<Issue, String> priorityColumn;
    @FXML
    private TableColumn<Issue, String> stateColumn;
    @FXML
    private TableColumn<Issue, Button> viewColumn;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Issue> list = FXCollections.observableArrayList(HTTPRequestManager.getIssueList());

        idColumn.setCellValueFactory(new PropertyValueFactory<>("idIssue"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("issueType"));
        priorityColumn.setCellValueFactory(new PropertyValueFactory<>("priority"));
        stateColumn.setCellValueFactory(new PropertyValueFactory<>("state"));

        //aggiungi codice visualizza

        IssueListTable.setItems(list);
    }


}
