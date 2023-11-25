package com.example.gamescreen.ViewModel.Enemy;

import android.widget.ImageView;
public class Enemy4 extends Enemy {
    private int hp;
    private int movementSpeed;
    private String name;
    private int x = 15;
    private int y = 15;
    private ImageView character;

    public Enemy4() {
        this.hp = 25;
        this.movementSpeed = 1;
        this.name = "Enemy 4"; // to be changed based on group decision of enemy names!
    }
}
