package it.ludina.bugboard26fe.bugboard26frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        WindowManager.apriFinestra("login.fxml");
    }

    public static void main(String[] args) {
        launch();
    }
}