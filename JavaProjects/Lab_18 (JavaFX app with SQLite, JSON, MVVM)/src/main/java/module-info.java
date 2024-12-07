module ru.guu {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.google.gson;
    requires javafx.graphics;
    requires javafx.base;
    
    opens ru.guu.view to javafx.fxml;
    opens ru.guu.model to com.google.gson;
    exports ru.guu;
}