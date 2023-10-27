package com.example.gamescreen;

import android.widget.Button;
import android.widget.ImageView;

public interface MovementStrategy {
    void moveRight(Button button, ImageView player);
    void moveLeft(Button button, ImageView player);
    void moveDown(Button button, ImageView player);
    void moveUp(Button button, ImageView player);
}
