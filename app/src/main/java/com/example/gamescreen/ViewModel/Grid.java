package com.example.gamescreen.ViewModel;

//import android.util.Log;

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
    public int gridWidth;
    public int gridLength;

    public Grid(int screenWidth, int screenLength, int gridWidth, int gridLength){
        this.screenWidth = screenWidth;
        this.screenLength = screenLength;
        this.widthFactor = screenWidth / gridWidth;
        this.lengthFactor = screenLength / gridLength;
        this.gridWidth = gridWidth;
        this.gridLength = gridLength;
        setGrid();
        setGun();
        generateWalls(gridLength, 1, gridWidth-5);
    }
    private void setGrid(){
        grid = new int[this.gridWidth][this.gridLength];
        for(int i = 0; i<grid.length; i++){
            grid[i][0] = -1;
        }
        for(int i = 0; i<grid.length; i++){
            grid[i][grid[0].length-1] = -1;
        }
        for(int j = 0; j<grid[0].length; j++){
            grid[0][j] = -1;
        }
        for(int j = 0; j<grid[0].length; j++){
            grid[grid.length-1][j] = -1;
        }
//        Log.d(TAG, "GRID: " + Arrays.asList(grid[grid.length-4]));
    }
    private void generateWalls(int colMax, int min, int max){
//        int col = (int) ((Math.random() * (colMax)) + 1);
//        int lowerRow = (int) ((Math.random() * (max - min)) + min);
//        int upperRow = lowerRow + 5;
//        for(int i = lowerRow; i<upperRow; i++){
//            grid[i][col] = 5;
//        }
        for(int j = 10; j<15; j++){
            grid[10][j] = 5;
        }
        for(int j = 3; j<8; j++){
            grid[15][j] = 5;
        }
    }
    private void setGun(){
        grid[5][5] = 8;
    }
    public void scramble(){
        setGrid();
    }
    public int moveToSpot(int x, int y, int oldX, int oldY){
        if(grid[x][y] == 0 || grid[x][y] == 10 || grid[x][y] == 3){
            grid[oldX][oldY] = 0;
            if(grid[x][y] != 10) {
                grid[x][y] = 1;
            }
            if(grid[x][y] == 3){
                return 3;
            }
            return 1;
        }
        return 0;
    }
    public List<Integer> getPixels(int x, int y){
        List<Integer> list = new ArrayList<>();
        list.add(x * widthFactor);
        list.add(y * lengthFactor);
        return list;
    }

    public int getWidthFactor() {
        return widthFactor;
    }

    public int getLengthFactor() {
        return lengthFactor;
    }
    public int[][] getGridCopy(){
//        int[][] copy = new int[gridWidth][gridLength];
//        for(int i = 0; i<copy.length; i++){
//            for(int j = 0; j<copy[0].length; j++){
//                copy[i][j] = grid[i][j];
//            }
//        }
//        return copy;
        return grid;
    }
    public void setCoordinate(int x, int y, int value){
        grid[x][y] = value;
    }
    public int getCoordinateValue(int x, int y){
        return grid[x][y];
    }
}
