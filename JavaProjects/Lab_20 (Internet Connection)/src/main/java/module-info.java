module ru.guu {
    requires javafx.controls;
    requires javafx.graphics;

    requires okhttp3;

    opens ru.guu to javafx.graphics;
}
