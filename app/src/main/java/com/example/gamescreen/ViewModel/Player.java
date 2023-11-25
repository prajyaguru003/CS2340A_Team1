package com.example.gamescreen.ViewModel;

import android.graphics.Bitmap;

public class Player {
    private int x;
    private int y;
    private int speed;
    private int damageMultiplier;

    public Player(int x, int y){
        this.x = x;
        this.y = y;
        this.speed = 1;
        this.damageMultiplier = 1;
    }

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

    public int getSpeed() { return speed; }

    public void setSpeed(int s) { this.speed = s; }

    public int getDamageMultiplier() { return damageMultiplier; }
    public void setDamageMultiplier(int d) { this.damageMultiplier = 2; }
}
