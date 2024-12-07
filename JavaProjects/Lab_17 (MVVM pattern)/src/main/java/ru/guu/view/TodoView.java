package ru.guu.view;

import ru.guu.model.Task;
import ru.guu.vm.TaskViewModel;

import java.sql.SQLException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TodoView {
    private final TaskViewModel viewModel;

    public TodoView(TaskViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public Scene createScene() {
        // Список задач
        ListView<Task> taskListView = new ListView<>(viewModel.getTasks());
        taskListView.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Task task, boolean empty) {
                super.updateItem(task, empty);
                if (empty || task == null) {
                    setText(null);
                } else {
                    setText(task.getName());
                    setStyle("-fx-strikethrough: " + (task.isCompleted() ? "true" : "false"));
                }
            }
        });

        // Изменение цвета при нажатии
        taskListView.setCellFactory(param -> new ListCell<>() {
            private int clickCount = 0;
        
            @Override
            protected void updateItem(Task task, boolean empty) {
                super.updateItem(task, empty);
                if (empty || task == null) {
                    setText(null);
                    setOnMouseClicked(null);
                    setStyle("");
                } else {
                    setText(task.getName());
                    setStyle("-fx-strikethrough: " + (task.isCompleted() ? "true" : "false"));
        
                    setOnMouseClicked(event -> {
                        clickCount = (clickCount + 1) % 3;
                        switch (clickCount) {
                            case 1:
                                setStyle("-fx-background-color: green;");
                                break;
                            case 2:
                                setStyle("-fx-background-color: red;");
                                break;
                            default:
                                setStyle("-fx-background-color: transparent;");
                                break;
                        }
                    });
                }
            }
        });

        // Кнопка добавления задачи
        TextField newTaskField = new TextField();
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> {
            try {
                viewModel.addTask(newTaskField.getText());
                newTaskField.clear();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        // Кнопка удаления задачи
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> {
            Task selectedTask = taskListView.getSelectionModel().getSelectedItem();
            if (selectedTask != null) {
                try {
                    viewModel.deleteTask(selectedTask);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Панель ввода
        HBox inputPanel = new HBox(10, newTaskField, addButton, deleteButton);
        inputPanel.setAlignment(Pos.CENTER);

        // Основная панель
        VBox root = new VBox(10, taskListView, inputPanel);
        root.setPadding(new Insets(10));

        // Сцена
        return new Scene(root, 400, 300);
    }
}