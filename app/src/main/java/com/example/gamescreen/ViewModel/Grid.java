package com.example.gamescreen.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private int[][] grid;
    private int screenWidth;
    private int screenLength;
    private int widthFactor;
    private int lengthFactor;

    public Grid(int screenWidth, int screenLength){
        grid = new int[50][50];
        this.screenWidth = screenWidth;
        this.screenLength = screenLength;
        this.widthFactor = screenWidth / 50;
        this.lengthFactor = screenLength / 50;
    }
    public void scramble(){
        grid = new int[50][50];
    }
    public boolean moveToSpot(int oldX, int oldY, int x, int y){
        if(grid[x][y] == 0){
            grid[oldX][oldY] = 0;
            grid[x][y] = 1;
            return true;
        }
        return false;
    }
    public List<Integer> getPixels(int x, int y){
        List<Integer> list = new ArrayList<>();
        list.add(x * widthFactor);
        list.add(y * lengthFactor);
        return list;
    }
}
