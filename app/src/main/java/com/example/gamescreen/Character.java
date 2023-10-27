package com.example.gamescreen;

import android.widget.ImageView;

public class Character {
    int x;
    int y;
    public ImageView character;
    public Character(ImageView character, int x, int y) {
        this.character = character;
        this.x = x;
        this.y = y;
    }
    public int[] getPos(){
        return new int[]{x,y};
    }
}
