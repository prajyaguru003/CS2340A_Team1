package com.example.gamescreen.ViewModel.Items;

import com.example.gamescreen.ViewModel.GameLogic;
import com.example.gamescreen.ViewModel.Grid;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class GenerateItems {
    Grid grid;
    List<Integer> items = new ArrayList<>();
    List<Item> realItems = new ArrayList<>();

    public GenerateItems(GameLogic gameLogic){
        grid = gameLogic.getGrid();
        generateItems();
    }

    public void generateItems(){
        for(int i = 0; i<3; i++){
            Random random = new Random();
            int x = 1 + random.nextInt(20);
            int y = 1 + random.nextInt(20);
            Item item = null;
            if(i%3 == 0){
                item = new Potion(x,y);
            } else if(i%3 == 1){
                item = new SpeedBoost(x, y);
            } else{
                item = new SlowEnemies(x,y);
            }
            grid.setCoordinate(x, y, 15*10 + i);
            items.add(1);
            realItems.add(item);
        }
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }
    public List<Integer> getItems(){
        return items;
    }
    public void setItems(int index, int value){
        items.set(index, value);
    }

    public List<Item> getRealItems() {
        return realItems;
    }

    public void setRealItems(List<Item> realItems) {
        this.realItems = realItems;
    }
}
