package com.example.gamescreen.ViewModel.Enemy;

import android.widget.ImageView;
import java.util.Random;

public abstract class Enemy {
    int hp;
    int movementSpeed;
    Random random = new Random();
    public int x = 1 + random.nextInt(20);

    // Generate a number between 1 and 20
    public int y = 1 + random.nextInt(20);
    String name;

    private ImageView character;
    private EnemyWeapon weapon;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageView getCharacter() {
        return character;
    }

    public void setCharacter(ImageView character) {
        this.character = character;
    }
}
