package it.ludina.bugboard26frontend;

import it.ludina.bugboard26frontend.components.ViewDetailCell;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class IssueListController implements Initializable {
    @FXML
    private TableView<Issue> issueTableView;
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
    private TableColumn<Issue, Boolean> viewColumn;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Issue> list = FXCollections.observableArrayList(HTTPRequestManager.getIssueList());

        idColumn.setCellValueFactory(new PropertyValueFactory<>("idIssue"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("issueType"));
        priorityColumn.setCellValueFactory(new PropertyValueFactory<>("priority"));
        stateColumn.setCellValueFactory(new PropertyValueFactory<>("state"));

        viewColumn.setCellValueFactory(features -> new SimpleBooleanProperty(features.getValue() != null));

        viewColumn.setCellFactory(issueBooleanTableColumn -> new ViewDetailCell(issueTableView));

        issueTableView.setItems(list);
    }
}
