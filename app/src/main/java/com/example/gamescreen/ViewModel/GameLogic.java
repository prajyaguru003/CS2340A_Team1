package com.example.gamescreen.ViewModel;

import java.util.List;

public class GameLogic {
    private Grid grid;
    private Player player;
    public GameLogic(int screenWidth, int screenLength) {
        if(grid == null){
            grid = new Grid(screenWidth, screenLength);
        }
        player = new Player(20, 25);
    }

    public List<Integer> moveRight(){
        boolean success = grid.moveToSpot(player.getX()+1, player.getY());
        if (success){
            player.setX(player.getX()+1);
            return grid.getPixels(player.getX(), player.getY());
        }
        return grid.getPixels(player.getX(), player.getY());
    }
    public List<Integer> moveLeft(){
        boolean success = grid.moveToSpot(player.getX()-1, player.getY());
        if (success){
            player.setX(player.getX()-1);
            return grid.getPixels(player.getX(), player.getY());
        }
        return grid.getPixels(player.getX(), player.getY());
    }
    public List<Integer> moveUp(){
        boolean success = grid.moveToSpot(player.getX(), player.getY()-1);
        if (success){
            player.setY(player.getY()-1);
            return grid.getPixels(player.getX(), player.getY());
        }
        return grid.getPixels(player.getX(), player.getY());
    }
    public List<Integer> moveDown(){
        boolean success = grid.moveToSpot(player.getX(), player.getY()+1);
        if (success){
            player.setY(player.getY()+1);
            return grid.getPixels(player.getX(), player.getY());
        }
        return grid.getPixels(player.getX(), player.getY());
    }
}
