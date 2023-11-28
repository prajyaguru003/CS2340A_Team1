package com.example.gamescreen.ViewModel.Items;

public class SpeedBoost extends Item {
    int boost = 10;
    public SpeedBoost(int x, int y){
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
