module ru.guu {
    requires javafx.controls;
    requires javafx.graphics;
    requires java.sql;

    opens ru.guu to javafx.graphics, javafx.controls;
}
