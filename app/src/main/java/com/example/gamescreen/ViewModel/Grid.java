package com.example.gamescreen.ViewModel;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Grid {
    private static final String TAG = "Grid";
    private int[][] grid;
    private int screenWidth;
    private int screenLength;
    private int widthFactor;
    private int lengthFactor;

    public Grid(int screenWidth, int screenLength){
        setGrid();
        this.screenWidth = screenWidth;
        this.screenLength = screenLength;
        this.widthFactor = screenWidth / 50;
        this.lengthFactor = screenLength / 50;
    }
    private void setGrid(){
        grid = new int[50][50];
        for(int i = 0; i<grid.length; i++){
            grid[i][0] = 1;
        }
        for(int i = 0; i<grid.length; i++){
            grid[i][grid[0].length-12] = 1;
        }
        for(int j = 0; j<grid[0].length; j++){
            grid[0][j] = 1;
        }
        for(int j = 0; j<grid[0].length; j++){
            grid[grid.length-3][j] = 1;
        }
        Log.d(TAG, "GRID: " + Arrays.asList(grid[grid.length-4]));
    }
    public void scramble(){
        setGrid();
    }
    public boolean moveToSpot(int x, int y, int oldX, int oldY){
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
