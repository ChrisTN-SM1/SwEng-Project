package it.ludina.bugboard26frontend.IssueDetails;

import it.ludina.bugboard26frontend.HTTPRequestManager;
import it.ludina.bugboard26frontend.HomepageController;
import it.ludina.bugboard26frontend.WindowManager;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxListCell;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Getter
@Setter
public class AssignIssueController{
    @FXML
    Button confermaButton;
    @FXML
    private ListView<String> emailListView;

    private List<String> selectedEmails = new ArrayList<>();
    private int idIssue;


    public void annullaButtonPressed(ActionEvent event) {
        WindowManager.closeWindow(event);
    }


    public void confermaButtonPressed(ActionEvent event) {
        HTTPRequestManager.assignIssue(idIssue, selectedEmails);
        WindowManager.closeWindow(event);
        HomepageController homepageController = HomepageController.getHomepageController();
        try {
            homepageController.reloadPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void getNotAssignedTo() {
        ObservableList<String> observableEmailList = FXCollections.observableArrayList(HTTPRequestManager.getNotAssignedTo(idIssue));
        emailListView.setCellFactory(CheckBoxListCell.forListView(item -> {
            BooleanProperty isSelected = new SimpleBooleanProperty();
            isSelected.addListener((observable, oldValue, newValue) -> {
                if(newValue) selectedEmails.add(item);
                else selectedEmails.remove(item);
            });
            return isSelected;
        }));
        emailListView.setItems(observableEmailList);
    }
}
