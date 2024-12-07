package ru.guu;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

/*
 * JavaFX App
 */

public class App extends Application {

    @Override
    public void start(Stage stage) {
        // Элементы интерфейса
        // Первое число
        Label firstNumLabel = new Label("Введите первое число:");
        TextField firstNumTextField = new TextField();
        firstNumTextField.setLayoutY(20);
        
        Group firstNumGroup = new Group(firstNumLabel, firstNumTextField);

        // Второе число
        Label secondNumLabel = new Label("Введите второе число:");
        TextField secondNumTextField = new TextField();
        secondNumTextField.setLayoutY(20);
        
        Group secondNumGroup = new Group(secondNumLabel, secondNumTextField);

        // Сумма 1,503
        Button countSumButton = new Button(" Посчитать сумму ");
        Label sumLabel = new Label("Сумма: ");
        sumLabel.setLayoutY(20);

        Group sumGroup = new Group(countSumButton, sumLabel);

        // Подсчёт суммы
        countSumButton.setOnAction(event -> {
            sumLabel.setText("Сумма: " + (Integer.valueOf(firstNumTextField.getText()) + Integer.valueOf(secondNumTextField.getText())));
        });

        // Объединение всех групп
        FlowPane root = new FlowPane(Orientation.VERTICAL, firstNumGroup, secondNumGroup, sumGroup);

        // Основная сцена
        Scene scene = new Scene(root);

        // Окно программы
        stage.setTitle("Calculator");
        stage.setWidth(400);
        stage.setHeight(400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}