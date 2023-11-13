package com.example.gamescreen.ViewModel;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameLogic {
    private Grid grid;
    private Player player;
    private int[] goldStar;
    private static final String TAG = "GameLogic";
    public GameLogic(int screenWidth, int screenLength) {
        if(grid == null){
            grid = new Grid(screenWidth, screenLength, 25, 25);
        }
        goldStar = new int[2];
        goldStar[0] = 23;
        goldStar[1] = 13;
        grid.setCoordinate(goldStar[0], goldStar[1], 10);
        player = new Player(9, 9);
    }

    public List<Integer> moveRight(){
        boolean success = grid.moveToSpot(player.getX()+1, player.getY(), player.getX(), player.getY());
        if (success){
            player.setX(player.getX()+1);
            return grid.getPixels(player.getX(), player.getY());
        }
        return grid.getPixels(player.getX(), player.getY());
    }
    public List<Integer> moveLeft(){
        boolean success = grid.moveToSpot(player.getX()-1, player.getY(), player.getX(), player.getY());
        if (success){
            player.setX(player.getX()-1);
            return grid.getPixels(player.getX(), player.getY());
        }
        return grid.getPixels(player.getX(), player.getY());
    }
    public List<Integer> moveUp(){
        boolean success = grid.moveToSpot(player.getX(), player.getY()-1, player.getX(), player.getY());
        if (success){
            player.setY(player.getY()-1);
            return grid.getPixels(player.getX(), player.getY());
        }
        return grid.getPixels(player.getX(), player.getY());
    }
    public List<Integer> moveDown(){
        boolean success = grid.moveToSpot(player.getX(), player.getY()+1, player.getX(), player.getY());
        if (success){
            player.setY(player.getY()+1);
            return grid.getPixels(player.getX(), player.getY());
        }
        return grid.getPixels(player.getX(), player.getY());
    }
    public List<Integer> getPlayerPixels(){
        return grid.getPixels(player.getX(), player.getY());
    }
    public List<Integer> getPlayerCoordinates(){
        List<Integer> temp = new ArrayList<>();
        temp.add(player.getX());
        temp.add(player.getY());
        return temp;
    }
    public int getPixelWidth(){
        return grid.getWidthFactor();
    }
    public int getPixelHeight(){
        return grid.getLengthFactor();
    }
    public int[][] getGridCopy(){
        return grid.getGridCopy();
    }
    public int[] getGoldStar(){
        return goldStar;
    }
    public boolean checkGoal(int x, int y){
        int val = grid.getCoordinateValue(x, y);
        Log.d(TAG, "VALUE " + val);
        if(val == 10){
            return true;
        }
        return false;
    }
    public Grid getGrid(){
        return grid;
    }
}
