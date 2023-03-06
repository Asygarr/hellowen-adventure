module game.mygame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens game.mygame to javafx.fxml;
    exports game.mygame;
}