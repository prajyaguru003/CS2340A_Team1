package com.example.gamescreen.ViewModel.Enemy;


import android.widget.ImageView;
public class Enemy1 extends Enemy{
    int hp;
    int movementSpeed;
    String name;
    public int x = 15;
    public int y = 15;
    ImageView character;

    public Enemy1() {
        this.hp = 10;
        this.movementSpeed = 4;
        this.name = "Enemy 1"; // to be changed based on group decision of enemy names!
    }
}
