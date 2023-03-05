module game.mygame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens game.mygame to javafx.fxml;
    exports game.mygame;
}