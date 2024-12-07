module ru.guu {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens ru.guu to javafx.fxml;
    exports ru.guu;
}
