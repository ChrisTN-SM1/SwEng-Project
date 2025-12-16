package it.ludina.bugboard26.bugboard26frontend;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage){
        WindowManager.apriFinestra("login.fxml");
    }


    public static void main() {
        launch();
    }
}