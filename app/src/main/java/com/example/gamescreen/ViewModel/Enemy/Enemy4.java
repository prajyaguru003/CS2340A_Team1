package com.example.gamescreen.ViewModel.Enemy;

import android.widget.ImageView;
public class Enemy4 extends Enemy{
    int hp;
    int movementSpeed;
    String name;
    public int x = 15;
    public int y = 15;
    ImageView character;

    public Enemy4() {
        this.hp = 25;
        this.movementSpeed = 1;
        this.name = "Enemy 4"; // to be changed based on group decision of enemy names!
    }
}
