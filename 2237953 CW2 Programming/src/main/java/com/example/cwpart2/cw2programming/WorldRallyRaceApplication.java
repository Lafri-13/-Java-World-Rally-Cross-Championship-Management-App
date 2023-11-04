package com.example.cwpart2.cw2programming;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WorldRallyRaceApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WorldRallyRaceApplication.class.getResource("Menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 582);
        stage.setTitle("World Rally Race");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}