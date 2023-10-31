package com.example.gamescreen;

public class PlayerObserver {
    int x = 0;
    int y = 0;
    public void updatePosition(int[][] grid, int x, int y){
        grid[x][y] = 0;
        this.x = x-1;
        this.y = y-1;
        grid[this.x][this.y] = 1;
    }
}
