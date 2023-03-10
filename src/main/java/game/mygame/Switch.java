package game.mygame;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Switch {

    private Stage stage;
    private Scene scene;
    private AnchorPane pan;

    public void switchPane(String pane, ActionEvent event) throws IOException {
        pan = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(pane)));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(pan);
        stage.setResizable(false);
        stage.setTitle("Hellowen Adventure");
        stage.setScene(scene);
        stage.show();
    }

}
