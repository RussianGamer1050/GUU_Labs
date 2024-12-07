package ru.guu;

import javafx.application. Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene. layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private Game game;
    private Text scoreText;

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        
        // Создание игры
        game = new Game();
        
        // Получение объекта игрока (прямоугольника)
        root.getChildren().add(game.getPlayer());
        for (Block block : game.getBlock_set()) {
            root.getChildren().add(block.getBlock());
        }
        
        // Текст для отображения счета
        scoreText = new Text(10, 30, "Score: 0");
        scoreText.setFill(Color. BLACK);
        root.getChildren().add(scoreText);
        
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        
        // Обработка ввода
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP || event.getCode() == KeyCode.DOWN || event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.RIGHT) {
                game.handleKeyPress(event.getCode());
                scoreText.setText("Score: " + game.getScore());
            }
        });

        primaryStage.setTitle("Simple JavaFX Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}