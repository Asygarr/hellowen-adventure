package game.mygame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HomeController {

    @FXML
    private Label LabelStart;

    @FXML
    private TextField namaInput;

    Switch pane = new Switch();
    DB db = new DB();
    Connection conn;
    Statement stmt;
    ResultSet rs;

    public void gameStart(ActionEvent event) throws Exception {

        String user = namaInput.getText();

        if (user.isBlank()) {
            LabelStart.setText("Nama tidak boleh kosong");
        } else {
            conn = db.getConnection();
            stmt = conn.createStatement();
            String query = "SELECT count(1) FROM user WHERE user_name = '" + user + "'";
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                if (rs.getInt(1) == 1) {
                    pane.switchPane("game.fxml", event);
                } else {
                    db.setNamaUser(user);
                    pane.switchPane("game.fxml", event);
                }
            }
        }
    }

    public void switchScenePeringkat (ActionEvent event) {
        try {
            pane.switchPane("peringkat.fxml", event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}