package game.mygame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HomeController {

    @FXML
    private Label LabelStart;

    @FXML
    private TextField namaInput;

    DB db = new DB();
    Connection conn;
    Statement stmt;
    ResultSet rs;

    private Stage stage;
    private Scene scene;
    private AnchorPane pan;

    public void gameStart(ActionEvent event) throws Exception {

        String user = namaInput.getText();

        if (user.isBlank() == true) {
            LabelStart.setText("Nama tidak boleh kosong");
        } else {
            conn = db.getConnection();
            stmt = conn.createStatement();
            String query = "SELECT * FROM user WHERE user_name = '" + user + "'";
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                if (rs.getInt(1) == 1) {
                    pan = FXMLLoader.load(getClass().getResource("game.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(pan);
                    stage.setTitle("Game Hellowen Adventure");
                    stage.setScene(scene);
                    stage.show();
                }
            }

            db.setNamaUser(user);
            pan = FXMLLoader.load(getClass().getResource("game.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(pan);
            stage.setTitle("Game Hellowen Adventure");
            stage.setScene(scene);
            stage.show();
        }
    }

    public void switchScenePeringkat (ActionEvent event) {
        try {
            pan = FXMLLoader.load(getClass().getResource("peringkat.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(pan);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}