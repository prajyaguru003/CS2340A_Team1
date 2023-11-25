package com.example.gamescreen.ViewModel.Enemy;


import android.widget.ImageView;
public class Enemy1 extends Enemy {
    private int hp;
    private int movementSpeed;
    private String name;
    private int x = 15;
    private int y = 15;
    private ImageView character;

    public Enemy1() {
        this.hp = 10;
        this.movementSpeed = 4;
        this.name = "Enemy 1"; // to be changed based on group decision of enemy names!
    }
}
