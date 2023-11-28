package com.example.gamescreen.ViewModel.Items;

public class SlowEnemies extends Item {
    int duration = 2;
    public SlowEnemies(int x, int y){
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
