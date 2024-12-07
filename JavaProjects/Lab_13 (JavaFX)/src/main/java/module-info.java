module ru.guu {
    requires javafx.controls;
    requires javafx.fxml;

    opens ru.guu to javafx.fxml;
    exports ru.guu;
}
