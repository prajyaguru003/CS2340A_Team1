package com.example.gamescreen.ViewModel.Enemy;
import android.util.Log;

import com.example.gamescreen.ViewModel.ConfigurationLogic;
import com.example.gamescreen.ViewModel.GameLogic;
import com.example.gamescreen.ViewModel.Grid;

import java.util.ArrayList;
//import java.util.HashSet;
import java.util.List;
import java.util.Random;
//import java.util.Set;
public class EnemyMovementLogic {
    private Enemy1 enemy1;
    private Enemy2 enemy2;
    private Enemy3 enemy3;
    private Enemy4 enemy4;
    private static Grid grid;
    private List<Enemy> enemies;
    private GameLogic gameLogic;
    private static final String TAG = "EnemyMovement";
    public EnemyMovementLogic(GameLogic gameLogic) {
        enemies = new ArrayList<>();
        enemy1 = new Enemy1();
        enemy2 = new Enemy2();
        enemy3 = new Enemy3();
        enemy4 = new Enemy4();
        enemies.add(enemy1);
        enemies.add(enemy2);
        enemies.add(enemy3);
        enemies.add(enemy4);
        this.grid = gameLogic.getGrid();
        this.gameLogic = gameLogic;
    }

    public void moveEnemies() {
        moveEnemy(enemy1, grid);
        moveEnemy(enemy2, grid);
        moveEnemy(enemy3, grid);
        moveEnemy(enemy4, grid);
    }

    public void moveEnemy(Enemy enemy, Grid grid) {
        int movementSpeed = enemy.getMovementSpeed();
        List<int[]> directions = new ArrayList<>();
        directions.add(new int[]{0, 1});
        directions.add(new int[]{0, -1});
        directions.add(new int[]{1, 0});
        directions.add(new int[]{-1, 0});
        Random random = new Random();
        int index = random.nextInt(directions.size());
        int[] direction = directions.get(index);
        int x = direction[0];
        int y = direction[1];
        int newX = enemy.getX() + x;
        int newY = enemy.getY() + y;
        if (newX >= 0 && newX < grid.getGridWidth() && newY >= 0 && newY < grid.getGridLength()
                && grid.getCoordinateValue(newX, newY) != 5
                && grid.getCoordinateValue(newX, newY) != -1) {
            grid.setCoordinate(enemy.getX(), enemy.getY(), 0);
            enemy.setX(newX);
            enemy.setX(newY);
            if (grid.getCoordinateValue(newX, newY) != 1) {
                grid.setCoordinate(newX, newY, 3);
            }
            if (grid.getCoordinateValue(newX, newY) == 1) {
                ConfigurationLogic playerConfig = gameLogic.getPlayerConfig();
                playerConfig.setHp(playerConfig.getHp() - playerConfig.getDamage());
                Log.d(TAG, "POKEMON.com");
            }
        }
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }
}
