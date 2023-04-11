module com.game {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    opens com.game to javafx.fxml;
    exports com.game;
}
