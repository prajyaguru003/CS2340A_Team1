package com.example.gamescreen.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    private Grid grid;
    private Player player;
    public GameLogic(int screenWidth, int screenLength) {
        if(grid == null){
            grid = new Grid(screenWidth, screenLength);
        }
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
}
