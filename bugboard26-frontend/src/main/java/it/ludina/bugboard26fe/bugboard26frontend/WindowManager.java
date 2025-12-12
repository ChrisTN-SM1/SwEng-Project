package it.ludina.bugboard26fe.bugboard26frontend;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WindowManager {

    static void apriFinestra(String nomeLayout){
        FXMLLoader fxmlLoader = new FXMLLoader(WindowManager.class.getResource(nomeLayout));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Bugboard26");
        stage.setScene(scene);
        stage.show();
    }

    static void chiudiFinestra(ActionEvent event){
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }
}
