package com.example.gamescreen.ViewModel.Enemy;

import android.widget.ImageView;

public abstract class Enemy {
    private int hp;
    private int movementSpeed;
    private int x = 15;
    private int y = 15;
    private String name;

    private ImageView character;

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getMovementSpeed() {
        return movementSpeed;
    }
}
