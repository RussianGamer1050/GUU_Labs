package ru.guu;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Bullet extends Rectangle {

    private boolean isEnemyBullet;

    public Bullet(double x, double y, boolean isEnemyBullet) {
        super(5, 10, Color.YELLOW);
        this.isEnemyBullet = isEnemyBullet;
        setX(x);
        setY(y);
    }

    public boolean isEnemyBullet() {
        return isEnemyBullet;
    }

    
    public void move(double dt) {
        if (isEnemyBullet) setY(getY() + 100 * dt);
        else setY(getY() - 200 * dt);
    }
}