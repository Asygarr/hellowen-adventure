package game.mygame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class World extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        AnchorPane pan = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene scene = new Scene(pan);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Hellowen Adventure");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}