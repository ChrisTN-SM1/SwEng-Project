package it.ludina.bugboard26frontend.components;

import it.ludina.bugboard26frontend.Issue;
import it.ludina.bugboard26frontend.IssueDetails.DetailIssueController;
import it.ludina.bugboard26frontend.WindowManager;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;


public class ViewDetailCell extends TableCell<Issue, Boolean> {
    final Button viewButton = new Button("View");
    final StackPane stackPane = new StackPane();
    final DoubleProperty buttonY = new SimpleDoubleProperty();

    public ViewDetailCell(TableView<Issue> table) {
        stackPane.setPadding(new Insets(3));
        stackPane.getChildren().add(viewButton);
        viewButton.setStyle("-fx-background-color: lightskyblue");
        viewButton.setOnMousePressed(mouseEvent -> buttonY.set(mouseEvent.getScreenY()));
        viewButton.setOnAction(actionEvent -> {
            Issue issue = table.getItems().get(getIndex());
            showDetailIssue(issue);
        });
    }

    @Override protected void updateItem(Boolean item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty) {
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            setGraphic(stackPane);
        } else {
            setGraphic(null);
        }
    }


    public void showDetailIssue(Issue issue){
        FXMLLoader fxmlLoader = WindowManager.openWindow("issue-details/detail-issue.fxml");
        DetailIssueController detailIssueController = fxmlLoader.getController();
        detailIssueController.getIssueDetails(issue);
    }
}