module ru.guu {
    requires javafx.controls;
    requires javafx.graphics;
    requires java.desktop;
    requires javafx.media;

    opens ru.guu to javafx.graphics;
}