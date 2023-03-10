package game.mygame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TabelController implements Initializable {

    Switch pane = new Switch();

    @FXML
    private ListView listPeringkat;

    DB db = new DB();
    Connection conn;
    Statement stmt;
    ResultSet rs;

    public void kembaliOnAction (ActionEvent event) throws IOException {

        pane.switchPane("home.fxml",event);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        conn = db.getConnection();

        String query = "SELECT user_name, poin FROM user order by poin desc";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {

                String user_name = rs.getString("user_name");
                int poin = rs.getInt("poin");
                String outputList = user_name + "\t\t\t\t\t\t | \t\t\t\t\t\t" + poin;

                listPeringkat.getItems().addAll(outputList);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
