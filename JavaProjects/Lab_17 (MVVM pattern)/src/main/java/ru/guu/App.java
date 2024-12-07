package ru.guu;

import java.sql.SQLException;

import ru.guu.view.TodoView;
import ru.guu.vm.TaskViewModel;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws SQLException {
        // Создание модели
        TaskViewModel viewModel = new TaskViewModel();

        // Создание представления (View)
        TodoView todoView = new TodoView(viewModel);

        // Настройка сцены и запуск приложения
        primaryStage.setTitle("Todo List");
        primaryStage.setScene(todoView.createScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}