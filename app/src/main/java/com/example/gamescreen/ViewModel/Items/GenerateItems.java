package com.example.gamescreen.ViewModel.Items;

import com.example.gamescreen.ViewModel.GameLogic;
import com.example.gamescreen.ViewModel.Grid;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class GenerateItems {
    Grid grid;
    List<Potion> potions = new ArrayList<>();
    List<SpeedBoost> boosts = new ArrayList<>();
    List<SlowEnemies> slowEnemies = new ArrayList<>();

    public GenerateItems(GameLogic gameLogic){
        grid = gameLogic.getGrid();
        generatePotion();
        generateBoost();
        generateSlowEnemies();
    }

    public void generatePotion(){
        for(int i = 0; i<3; i++){
            Random random = new Random();
            int x = 1 + random.nextInt(20);
            int y = 1 + random.nextInt(20);
            Potion potion = new Potion(x, y);
            grid.setCoordinate(x, y, 15);
            potions.add(potion);
        }
    }
    public void generateBoost(){
        for(int i = 0; i<3; i++){
            Random random = new Random();
            int x = 1 + random.nextInt(20);
            int y = 1 + random.nextInt(20);
            SpeedBoost boost = new SpeedBoost(x, y);
            grid.setCoordinate(x, y, 16);
            boosts.add(boost);
        }
    }
    public void generateSlowEnemies(){
        for(int i = 0; i<3; i++){
            Random random = new Random();
            int x = 1 + random.nextInt(20);
            int y = 1 + random.nextInt(20);
            SlowEnemies slow = new SlowEnemies(x, y);
            grid.setCoordinate(x, y, 17);
            slowEnemies.add(slow);
        }
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public List<Potion> getPotions() {
        return potions;
    }

    public void setPotions(List<Potion> potions) {
        this.potions = potions;
    }

    public List<SpeedBoost> getBoosts() {
        return boosts;
    }

    public void setBoosts(List<SpeedBoost> boosts) {
        this.boosts = boosts;
    }

    public List<SlowEnemies> getSlowEnemies() {
        return slowEnemies;
    }

    public void setSlowEnemies(List<SlowEnemies> slowEnemies) {
        this.slowEnemies = slowEnemies;
    }
}
