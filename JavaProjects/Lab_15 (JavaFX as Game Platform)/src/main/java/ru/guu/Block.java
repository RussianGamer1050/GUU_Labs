package ru.guu;

import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Block {
    private Rectangle block;

    private int block_width;
    private int block_height;
    // private int blockX;
    // private int blockY;

    private boolean isBlockHorizontal;
    
    public Block(int BLOCK_SIZE, int MAX_BLOCK_LENGTH, int WIDTH, int HEIGHT) {
        Random rand = new Random();

        // Определение ориентации преграды
        if (rand.nextInt(2) == 0) {
            isBlockHorizontal = false;
        } else {
            isBlockHorizontal = true;
        }

        // Создание преграды, основываясь на его ориентации
        if (isBlockHorizontal) {
            block_width = rand.nextInt(MAX_BLOCK_LENGTH + 1) + 30;
            while (block_width % 5 != 0) {
                block_width--;
            }
            block_height = 30;
        } 
        else {
            block_height = rand.nextInt(MAX_BLOCK_LENGTH + 1) + 30;
            while (block_height % 5 != 0) {
                block_height--;
            }
            block_width = 30;
        }

        // Создание преграды
        this.block = new Rectangle(block_width, block_height, Color.RED);

        // Задание положения преград
        int x = rand.nextInt(WIDTH);

        while ((x > WIDTH / 2 - 60) && (x < WIDTH / 2 + 90) || (x % 5 != 0)) {
            x = rand.nextInt(WIDTH);
        }
        block.setX(x);

        int y = rand.nextInt(HEIGHT);
        while ((y > HEIGHT / 2 - 60) && (y < WIDTH / 2 + 90) || (y % 5 != 0)) {
            y = rand.nextInt(HEIGHT);
        }
        block.setY(y);
    }

    public Rectangle getBlock() {
        return block;
    }

    public void setX(double x) {
        block.setX(x);
    }

    public void setY(double y) {
        block.setY(y);
    }
}
