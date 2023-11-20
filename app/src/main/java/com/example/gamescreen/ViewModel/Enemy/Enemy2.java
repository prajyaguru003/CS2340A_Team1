package com.example.gamescreen.ViewModel.Enemy;

import android.widget.ImageView;
public class Enemy2 extends Enemy{
    int hp;
    int movementSpeed;
    String name;
    public int x = 15;
    public int y = 15;
    ImageView character;

    public Enemy2() {
        this.hp = 15;
        this.movementSpeed = 3;
        this.name = "Enemy 2"; // to be changed based on group decision of enemy names!
    }
}
