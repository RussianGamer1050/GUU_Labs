package ru.guu;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application {

    /*
     * По идее код написан верно, но при нажатии на кнопку
     * круг отправляется в правый нижний угол и ничего далее
     * не происходит :/
     */

    private void animateCircle(Circle circle) {
        double centerX = 200;
        double centerY = 200;
        double maxRadius = 150;
        double angularVelocity = 0.05;
    
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.millis(10), event -> {
            double time = timeline.getCurrentTime().toMillis();
            double radius = Math.min(time * 0.1, maxRadius);
            double angle = angularVelocity * time;
    
            double x = centerX + radius * Math.cos(angle);
            double y = centerY + radius * Math.sin(angle);
    
            circle.setTranslateX(x - circle.getCenterX());
            circle.setTranslateY(y - circle.getCenterY());
        });
    
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    
    private void resetCircle(Circle circle) {
        circle.setLayoutX(200);
        circle.setLayoutY(200);
        circle.setTranslateX(0);
        circle.setTranslateY(0);
    }
    
    @Override
    public void start(Stage stage) {
        Button button = new Button("Начать движение по спирали!");
        button.setLayoutX(10);
        button.setLayoutY(360);
        button.getStyleClass().add("button");
    
        Circle circle = new Circle(5, Color.CORAL);
        circle.setLayoutX(200);
        circle.setLayoutY(200);
        circle.getStyleClass().add("circle");
    
        button.setOnAction(event -> {
            resetCircle(circle);
            animateCircle(circle);
        });
    
        Group root = new Group(button, circle);
    
        Scene scene = new Scene(root, 400, 400);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
    
        stage.setTitle("Стилизация и анимация в JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}