package it.ludina.bugboard26frontend.details;

import it.ludina.bugboard26frontend.HTTPRequestManager;
import it.ludina.bugboard26frontend.HomepageController;
import it.ludina.bugboard26frontend.WindowManager;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AssignIssueController{
    @FXML
    private Button confermaButton;
    @FXML
    private ListView<String> emailListView;

    private List<String> selectedEmails = new ArrayList<>();
    private int idIssue;


    public void annullaButtonPressed(ActionEvent event) {
        WindowManager.closeWindow(event);
    }


    public void confermaButtonPressed(ActionEvent event) {
        try {
            HTTPRequestManager.assignIssue(idIssue, selectedEmails);
            WindowManager.closeWindow(event);
            HomepageController homepageController = HomepageController.getHomepageController();
            homepageController.reloadPage();
        } catch (IOException e) {
            WindowManager.openWindow("errors/generic-error.fxml");
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
