module ru.guu {
    // Требуется JavaFX 
    requires javafx.controls; 
    requires javafx.graphics;

    // Требуется Google Guice
    requires com.google.guice;

    // Открываем пакеты для Guice, чтобы он мог инъектировать зависимости 
    opens ru.guu to com.google.guice, javafx.graphics;
}
