package it.ludina.bugboard26frontend;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage){
        WindowManager.openWindow("login.fxml");
    }


    public static void main(String [] args) {
        launch();
    }
}