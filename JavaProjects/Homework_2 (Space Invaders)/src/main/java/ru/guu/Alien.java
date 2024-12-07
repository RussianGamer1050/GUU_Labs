package ru.guu;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Alien extends Rectangle {

    private double startPosX;

    private boolean moveRight;


    public Alien(double x, double y, boolean moveRight) {
        super(40, 25, Color.RED);
        setX(x); startPosX = x;
        setY(y);
        this.moveRight = moveRight;
    }

    public double getStartPosX() {
        return startPosX;
    }

    public boolean isMoveRight() {
        return moveRight;
    }

    public void setMoveRight(boolean moveRight) {
        this.moveRight = moveRight;
    }


    public void moveDown(double dt) {
        setY(getY() + 5 * dt);
    }

    public void moveRight(double dt) {
        setX(getX() + 20 * dt);
    }

    public void moveLeft (double dt) {
        setX(getX() - 20 * dt);
    }
}