package com.example.gamescreen.ViewModel.Enemy;

import android.widget.ImageView;
public class Enemy3 extends Enemy {
    private int hp;
    private int movementSpeed;
    private String name;
    private int x = 15;
    private int y = 15;
    private ImageView character;

    public Enemy3() {
        this.hp = 20;
        this.movementSpeed = 2;
        this.name = "Enemy 3"; // to be changed based on group decision of enemy names!
    }
}
