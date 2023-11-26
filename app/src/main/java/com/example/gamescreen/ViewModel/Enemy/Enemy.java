package com.example.gamescreen.ViewModel.Enemy;

import android.widget.ImageView;

public abstract class Enemy {
    private int hp;
    private int movementSpeed;
    private int x = 15;
    private int y = 15;
    private String name;

    private ImageView character;
    private EnemyWeapon weapon;

    public Enemy(int hp, int movementSpeed, int x, int y, String name,
                 ImageView character, EnemyWeapon weapon) {
        this.hp = hp;
        this.movementSpeed = movementSpeed;
        this.x = x;
        this.y = y;
        this.name = name;
        this.character = character;
        this.weapon = weapon;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
}
