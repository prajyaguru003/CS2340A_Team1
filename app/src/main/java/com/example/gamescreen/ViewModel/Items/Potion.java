package com.example.gamescreen.ViewModel.Items;

public class Potion extends Item {
    int heal = 10;

    public Potion(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getX(){
        return this.x;
    }
}
