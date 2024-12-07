package ru.guu;

import java.util.HashSet;
import java.util.Random;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Game {
    // Константы для размеров окна, прямоугольника, скорости движения и препятствий
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    
    private static final int RECT_SIZE = 30;
    private static final int MOVE_SPEED = 5; // Скорость движения

    private static final int BLOCK_SIZE = 30;
    private static final int MAX_BLOCK_LENGTH = 90; // Максимальная длина препятствия
    private static final int MAX_BLOCK_AMOUNT = 10;

// !!!----------------- Перенести в отдельный класс всё, что связано с игроком -------------------!!!

    // Переменные для координат прямоугольника, самого прямоугольника и счета
    private double rectX = WIDTH / 2 - RECT_SIZE / 2;
    private double rectY = HEIGHT / 2 - RECT_SIZE / 2;
    private Rectangle player; 
    private int score;

    // Переменные для координат препятствий
    private Block block;
    private HashSet<Block> block_set = new HashSet<>();

    // Конструктор класса Game
    public Game() {
        // Инициализация препятствий, игрока и начального состояния игры
        Random rand = new Random();
        
        for (int i = rand.nextInt(MAX_BLOCK_AMOUNT); i >= 0; i--) {
            block = new Block(BLOCK_SIZE, MAX_BLOCK_LENGTH, WIDTH, HEIGHT);
            block_set.add(block);
        }

        player = new Rectangle(RECT_SIZE, RECT_SIZE, Color.BLUE);
        
        player.setX(rectX);
        player.setY(rectY);

        score = 0;
    }

    // Метод для получения игрока (объекта Rectangle)
    public Rectangle getPlayer() {
        return player;
    }

    // Метод для обработки нажатия клавиш и движения игрока
    public void handleKeyPress(KeyCode keyCode) {
        // Обработка нажатий клавиш для перемещения
        if (keyCode == KeyCode.UP) {
            if (rectY != 0) {
                score++;
            }
            rectY = Math.max(0, rectY - MOVE_SPEED);
        } else if (keyCode == KeyCode.DOWN) {
            if (rectY != HEIGHT - RECT_SIZE) {
                score++;
            }
            rectY = Math.min(HEIGHT - RECT_SIZE, rectY + MOVE_SPEED);
        } else if (keyCode == KeyCode.LEFT) {
            if (rectX != 0) {
                score++;
            }
            rectX = Math.max(0, rectX - MOVE_SPEED);
        } else if (keyCode == KeyCode.RIGHT) {
            if (rectX != WIDTH - RECT_SIZE) {
                score++;
            }
            rectX = Math.min(WIDTH - RECT_SIZE, rectX + MOVE_SPEED);
        }

        // Обновляем позицию игрока
        player.setX(rectX);
        player.setY(rectY);

        // Проверка столкновений
        for (Block block : block_set) {
            if (block.getBlock().getBoundsInParent().intersects(player.getBoundsInParent())) System.exit(0);
        }
    }

    // Метод для получения текущего счета
    public int getScore() {
        return score;
    }

    public HashSet<Block> getBlock_set() {
        return block_set;
    }

    // Метод для сброса игры (например, при столкновении)
    public void reset() {
        rectX = WIDTH / 2 - RECT_SIZE / 2;
        rectY = HEIGHT / 2 - RECT_SIZE / 2;
        player.setX(rectX);
        player.setY(rectY);
        score = 0;
    }
}