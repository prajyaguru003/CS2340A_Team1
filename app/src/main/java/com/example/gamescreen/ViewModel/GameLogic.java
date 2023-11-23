package com.example.gamescreen.ViewModel;

//import android.util.Log;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

public class GameLogic {
    private Grid grid;
    private Player player;
    private int[] goldStar;
    private ConfigurationLogic playerConfig;
    private static final String TAG = "GameLogic";
    public GameLogic(int screenWidth, int screenLength, ConfigurationLogic playerConfig) {
        if (grid == null) {
            grid = new Grid(screenWidth, screenLength, 25, 25);
        }
        this.playerConfig = playerConfig;
        goldStar = new int[2];
        goldStar[0] = 23;
        goldStar[1] = 13;
        grid.setCoordinate(goldStar[0], goldStar[1], 10);
//        Log.d(TAG, "GOLDSTAR: " + grid.getCoordinateValue(goldStar[0], goldStar[1]));
        player = new Player(9, 9);
    }

    public List<Integer> moveRight(){
        int success = grid.moveToSpot(player.getX()+1, player.getY(), player.getX(), player.getY());
        if (success == 1 || success == 3){
            player.setX(player.getX()+1);
            int newX = player.getX();
            int newY = player.getY();
            if(grid.getCoordinateValue(newX, newY) == 3){
                ConfigurationLogic playerConfig = this.getPlayerConfig();
                playerConfig.setHp(playerConfig.getHp() - playerConfig.getDamage());
//                Log.d(TAG, "POKEMON.com");
            }
            return grid.getPixels(player.getX(), player.getY());
        }
        return grid.getPixels(player.getX(), player.getY());
    }
    public List<Integer> moveLeft(){
        int success = grid.moveToSpot(player.getX()-1, player.getY(), player.getX(), player.getY());
        if (success == 1 || success == 3){
            player.setX(player.getX()-1);
            int newX = player.getX();
            int newY = player.getY();
            if(grid.getCoordinateValue(newX, newY) == 3){
                ConfigurationLogic playerConfig = this.getPlayerConfig();
                playerConfig.setHp(playerConfig.getHp() - playerConfig.getDamage());
//                Log.d(TAG, "POKEMON.com");
            }
    public List<Integer> moveUp(){
        int success = grid.moveToSpot(player.getX(), player.getY()-1, player.getX(), player.getY());
        if (success == 1 || success == 3){
            player.setY(player.getY()-1);
            int newX = player.getX();
            int newY = player.getY();
            if(grid.getCoordinateValue(newX, newY) == 3){
                ConfigurationLogic playerConfig = this.getPlayerConfig();
                playerConfig.setHp(playerConfig.getHp() - playerConfig.getDamage());
//                Log.d(TAG, "POKEMON.com");
            }
    public List<Integer> moveDown(){
        int success = grid.moveToSpot(player.getX(), player.getY()+1, player.getX(), player.getY());
        if (success == 1 || success == 3){
            player.setY(player.getY()+1);
            int newX = player.getX();
            int newY = player.getY();
            if(grid.getCoordinateValue(newX, newY) == 3){
                ConfigurationLogic playerConfig = this.getPlayerConfig();
                playerConfig.setHp(playerConfig.getHp() - playerConfig.getDamage());
//                Log.d(TAG, "POKEMON.com");
            }
            return grid.getPixels(player.getX(), player.getY());
        }
        return grid.getPixels(player.getX(), player.getY());
    }
    public List<Integer> getPlayerPixels() {
        return grid.getPixels(player.getX(), player.getY());
    }
    public List<Integer> getPlayerCoordinates() {
        List<Integer> temp = new ArrayList<>();
        temp.add(player.getX());
        temp.add(player.getY());
        return temp;
    }
    public int getPixelWidth() {
        return grid.getWidthFactor();
    }
    public int getPixelHeight() {
        return grid.getLengthFactor();
    }
    public int[][] getGridCopy() {
        return grid.getGridCopy();
    }
    public int[] getGoldStar() {
        return goldStar;
    }
    public boolean checkGoal(int x, int y) {
        int val = grid.getCoordinateValue(x, y);
        if(val == 10){
            return true;
        }
        return false;
    }
    public Grid getGrid() {
        return grid;
    }
    public ConfigurationLogic getPlayerConfig() {
        return playerConfig;
    }
}
