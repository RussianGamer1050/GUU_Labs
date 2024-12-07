package ru.guu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SpaceInvaders extends Application {

    private Pane root = new Pane();
    private Scene scene = new Scene(root, 800, 600, Color.BLACK);

    private class GameLoop extends AnimationTimer {
        // Игровые объекты
        private Spaceship player = new Spaceship();
        private List<Alien> aliens = new ArrayList<>();
        private List<Bullet> bullets = new ArrayList<>();

        private int score = 0;
        private int lives = 3;
        Text scoreText = new Text(10, 10, "Score: " + score + "\nLives: " + lives);
        private boolean isGameOver = false;

        long shoot_cooldown = 0; // Кулдаун выстрелов игрока
        
        private void update() {
            double dt = 0.016; // Организация плавности (~ 60 FPS)
        
            // Передвижение игрока
            if (Keyboard.isKeyPressed(KeyCode.LEFT)) player.moveLeft(dt);
            if (Keyboard.isKeyPressed(KeyCode.RIGHT)) player.moveRight(dt);

            // Задержка перед выстрелами игрока
            if (shoot_cooldown != 0) {
                if (shoot_cooldown < System.currentTimeMillis()) shoot_cooldown = 0;
            }
            // Стрельба, если нажата клавиша вверх
            if (Keyboard.isKeyPressed(KeyCode.UP) && shoot_cooldown == 0) {
                shoot_cooldown += System.currentTimeMillis() + 1000;
                Bullet bullet = new Bullet(player.getX() + 22, player.getY(), false);
                bullets.add(bullet);
            }

            // Движение врагов вправо-лево
            for (Alien alien : aliens) {
                alien.moveDown(dt);

                if (alien.getX() > alien.getStartPosX() + 30 && alien.isMoveRight()) {
                    alien.setMoveRight(false);
                }
                if (alien.getX() < alien.getStartPosX() - 30 && !alien.isMoveRight()) {
                    alien.setMoveRight(true);
                }

                if (alien.isMoveRight()) {
                    alien.moveRight(dt);
                } else {
                    alien.moveLeft(dt);
                }
            }

            // Стрельба врагов
            for (Alien alien : aliens) {
                if (Math.random() < 0.0001) {
                    Bullet enemy_bullet = new Bullet(alien.getX() + 20, alien.getY() + 25, true);
                    bullets.add(enemy_bullet);
                }
            }

            // Обновление пуль и проверка коллизии
            for (Bullet bullet : bullets) bullet.move(dt);

            Iterator<Bullet> bul = bullets.iterator();
            while (bul.hasNext()) {
                Bullet bullet = bul.next();
                
                if (!bullet.isEnemyBullet()) {
                    Iterator<Alien> it = aliens.iterator();
                    while (it.hasNext()) {
                        Alien alien = it.next();
                        if (bullet.getBoundsInParent().intersects(alien.getBoundsInParent())) {
                            score++;
                            it.remove();
                            bul.remove();
                        }
                    }
                } else {
                    if (bullet.getBoundsInParent().intersects(player.getBoundsInParent())) {
                        looseLife();
                    }
                }
                
            }

            // Создание волны врагов
            if (aliens.isEmpty() && !isGameOver) {
                scoreText.setFill(Color.WHITE);
                initialSpawnAliens();
            }

            scoreText.setText("Score: " + score + "\nLives: " + lives);

            // Проверка конца игры
            if (lives == 0) {
                aliens.clear();
                bullets.clear();
                endGame();
            }
            
            // Проверка достижения врагом конца поля
            for (Alien alien : aliens) {
                if (alien.getY() + 25 > 500) {
                    looseLife();
                    break;
                }
            }
        }

        // Обновление элементов на экране
        private void render(Scene scene) {
            root.getChildren().clear();

            root.getChildren().add(scoreText);

            root.getChildren().add(player);
            for (Bullet bullet : bullets) {
                root.getChildren().add(bullet);
            }

            for (Alien alien : aliens) {
                root.getChildren().add(alien);
            }
        }
        
        // Спавн начальной пачки
        private void initialSpawnAliens() {
            for (int j = 0; j < 5; j++) {
                for (int i = 0; i < 11; i++) {
                    aliens.add(new Alien(30 + i * 70, 50 + j * 55, j % 2 == 0));
                }
            }
        }
        
        private void saveScore(int score) {
            try (FileWriter writer = new FileWriter("scores.txt", true)) {
                writer.write(new SimpleDateFormat("dd.MM.yyyy HH:mm").format(new Date()) + " Score: " + score + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void looseLife() {
            aliens.clear();
            bullets.clear();
            player.setX(375);
            lives--;
        }
        
        private void endGame() {
            scoreText.setText("Game Over! Score: " + score + "\nДля выхода нажмите пробел");
            scoreText.setX(150);
            scoreText.setY(280);
            scoreText.setFont(Font.font(40));
            isGameOver = true;
            saveScore(score);
            String file = "space_invaders/src/main/resources/ru/guu/game_over.mp3";
            Media sound = new Media(new File(file).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
        }

        @Override
        public void handle(long now) {
            if (!isGameOver) {
                update(); // Обновление игровой логики
                render(scene); // Обновление экрана
            }
            if (isGameOver && Keyboard.isKeyPressed(KeyCode.SPACE)) {
                System.exit(0);
            }
        }
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Space Invaders");
        stage.setScene(scene);
        stage.show();

        // Initialize game elements and start the game loop
        Keyboard.initialize(scene);
        GameLoop game = new GameLoop();
        game.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}