package ru.guu;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Spaceship extends Rectangle {

    public Spaceship() {
        super(50, 10, Color.BLUE);
        setX(375);
        setY(500);
    }

    
    public void moveLeft(double dt) {
        setX(getX() - 100 * dt);
    }

    public void moveRight(double dt) {
        setX(getX() + 100 * dt);
    }
}