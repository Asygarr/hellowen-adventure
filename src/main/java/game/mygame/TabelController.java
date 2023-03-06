package game.mygame;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TabelController {

    private Stage stage;
    private Scene scene;
    private AnchorPane pan;
    public void kembaliOnAction (ActionEvent event) throws IOException {

        pan = FXMLLoader.load(getClass().getResource("home.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(pan);
        stage.setScene(scene);
        stage.show();

    }
}
