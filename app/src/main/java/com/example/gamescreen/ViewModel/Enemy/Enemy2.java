package com.example.gamescreen.ViewModel.Enemy;

import android.widget.ImageView;
public class Enemy2 extends Enemy{
    int hp;
    int movementSpeed;
    String name;
    public int x = 15;
    public int y = 20;
    ImageView character;

    public Enemy2() {
        this.hp = 15;
        this.movementSpeed = 3;
        this.name = "Enemy 2"; // to be changed based on group decision of enemy names!
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public ImageView getCharacter() {
        return character;
    }

    public void setCharacter(ImageView character) {
        this.character = character;
    }
}
