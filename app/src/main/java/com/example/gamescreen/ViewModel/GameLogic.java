package com.example.gamescreen.ViewModel;

//import android.util.Log;

import android.util.Log;

import com.example.gamescreen.ViewModel.Items.GenerateItems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameLogic {
    private Grid grid;
    private Player player;
    private int[] goldStar;
    private int scaleMovement = 1;
    private List<Integer> items;
    ConfigurationLogic playerConfig;
    private static final String TAG = "GameLogic";
    public GameLogic(int screenWidth, int screenLength, ConfigurationLogic playerConfig) {
        if(grid == null){
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
        int success = grid.moveToSpot(player.getX()+1*scaleMovement, player.getY(), player.getX(), player.getY());
        if (success == 1 || success == 3 || success == 15){
            player.setX(player.getX()+1*scaleMovement);
            int newX = player.getX();
            int newY = player.getY();
            if(grid.getCoordinateValue(newX, newY) == 3){
                ConfigurationLogic playerConfig = this.getPlayerConfig();
                playerConfig.setHp(playerConfig.getHp() - playerConfig.getDamage());
//                Log.d(TAG, "POKEMON.com");
            }
            Log.d(TAG, "HEALTH BOOST! " + grid.getCoordinateValue(newX, newY));
            if(success == 15){
                Log.d(TAG, "HEALTH BOOST!");
                int listIndex = grid.getCoordinateValue(newX, newY) % 150;
                items.set(listIndex, 0);
                if(listIndex%3 == 0){
                    playerConfig.setHp(playerConfig.getHp() + 20);
                } else if(listIndex % 3 == 1){
                    scaleMovement += 1;
                } else{
                    scaleMovement += 1;
                }
            }
            return grid.getPixels(player.getX(), player.getY());
        }
        return grid.getPixels(player.getX(), player.getY());
    }
    public List<Integer> moveLeft(){
        int success = grid.moveToSpot(player.getX()-1*scaleMovement, player.getY(), player.getX(), player.getY());
        if (success == 1 || success == 3 || success == 15){
            player.setX(player.getX()-1*scaleMovement);
            int newX = player.getX();
            int newY = player.getY();
            if(grid.getCoordinateValue(newX, newY) == 3){
                ConfigurationLogic playerConfig = this.getPlayerConfig();
                playerConfig.setHp(playerConfig.getHp() - playerConfig.getDamage());
//                Log.d(TAG, "POKEMON.com");
            }
            Log.d(TAG, "HEALTH BOOST! " + grid.getCoordinateValue(newX, newY));
            if(success == 15){
                Log.d(TAG, "HEALTH BOOST!");
                int listIndex = grid.getCoordinateValue(newX, newY) % 150;
                items.set(listIndex, 0);
                if(listIndex%3 == 0){
                    playerConfig.setHp(playerConfig.getHp() + 20);
                } else if(listIndex % 3 == 1){
                    scaleMovement += 1;
                } else{
                    scaleMovement += 1;
                }
            }
            return grid.getPixels(player.getX(), player.getY());
        }
        return grid.getPixels(player.getX(), player.getY());
    }
    public List<Integer> moveUp(){
        int success = grid.moveToSpot(player.getX(), player.getY()-1*scaleMovement, player.getX(), player.getY());
        if (success == 1 || success == 3 || success == 15){
            player.setY(player.getY()-1*scaleMovement);
            int newX = player.getX();
            int newY = player.getY();
            if(grid.getCoordinateValue(newX, newY) == 3){
                ConfigurationLogic playerConfig = this.getPlayerConfig();
                playerConfig.setHp(playerConfig.getHp() - playerConfig.getDamage());
//                Log.d(TAG, "POKEMON.com");
            }
            Log.d(TAG, "HEALTH BOOST! " + grid.getCoordinateValue(newX, newY));
            if(success == 15){
                Log.d(TAG, "HEALTH BOOST!");
                int listIndex = grid.getCoordinateValue(newX, newY) % 150;
                items.set(listIndex, 0);
                if(listIndex%3 == 0){
                    playerConfig.setHp(playerConfig.getHp() + 20);
                } else if(listIndex % 3 == 1){
                    scaleMovement += 1;
                } else{
                    scaleMovement += 1;
                }
            }
            return grid.getPixels(player.getX(), player.getY());
        }
        return grid.getPixels(player.getX(), player.getY());
    }
    public List<Integer> moveDown(){
        int success = grid.moveToSpot(player.getX(), player.getY()+1*scaleMovement, player.getX(), player.getY());
        if (success == 1 || success == 3 || success == 15){
            player.setY(player.getY()+1*scaleMovement);
            int newX = player.getX();
            int newY = player.getY();
            if(grid.getCoordinateValue(newX, newY) == 3){
                ConfigurationLogic playerConfig = this.getPlayerConfig();
                playerConfig.setHp(playerConfig.getHp() - playerConfig.getDamage());
//                Log.d(TAG, "POKEMON.com");
            }
            Log.d(TAG, "HEALTH BOOST! " + grid.getCoordinateValue(newX, newY));
            if(success == 15){
                Log.d(TAG, "HEALTH BOOST!");
                int listIndex = grid.getCoordinateValue(newX, newY) % 150;
                items.set(listIndex, 0);
                if(listIndex%3 == 0){
                    playerConfig.setHp(playerConfig.getHp() + 20);
                } else if(listIndex % 3 == 1){
                    scaleMovement += 1;
                } else{
                    scaleMovement += 1;
                }
            }
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
//        Log.d(TAG, "VALUE " + val);
        if(val == 10){
            return true;
        }
        return false;
    }
    public Grid getGrid(){
        return grid;
    }
    public ConfigurationLogic getPlayerConfig(){
        return playerConfig;
    }
    public void setItems(List<Integer> items){
        this.items = items;
    }
}
