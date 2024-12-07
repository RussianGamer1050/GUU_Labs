module ru.guu {
    requires javafx.controls;
    requires javafx.graphics;
    requires java.sql;

    opens ru.guu to javafx.controls, javafx.graphics, java.sql;
    exports ru.guu to javafx.graphics;
}
