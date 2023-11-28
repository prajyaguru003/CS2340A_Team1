package com.example.gamescreen.ViewModel.Enemy;
import android.util.Log;

import com.example.gamescreen.ViewModel.ConfigurationLogic;
import com.example.gamescreen.ViewModel.GameLogic;
import com.example.gamescreen.ViewModel.Grid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
public class EnemyMovementLogic {
    private Enemy1 enemy1;
    private Enemy2 enemy2;
    private Enemy3 enemy3;
    private Enemy4 enemy4;
    private static Grid grid;
    private List<Enemy> enemies;
    GameLogic gameLogic;
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

    public int moveEnemies(){
        int e1 = moveEnemy(enemy1, grid);
        int e2 = moveEnemy(enemy2, grid);
        int e3 = moveEnemy(enemy3, grid);
        int e4 = moveEnemy(enemy4, grid);
        if(e1 == -1){
            return 1;
        } else if(e2 == -1){
            return 2;
        }
        else if(e3 == -1){
            return 3;
        } else if(e4 == -1){
            return 4;
        }
        return 0;
    }

    public int moveEnemy(Enemy enemy, Grid grid){
        int movementSpeed = enemy.movementSpeed;
        List<int[]> directions = new ArrayList<>();
        directions.add(new int[]{0,1});
        directions.add(new int[]{0,-1});
        directions.add(new int[]{1,0});
        directions.add(new int[]{-1,0});
        Random random = new Random();
        int index = random.nextInt(directions.size());
//        int[] direction = directions.get(index);
        List<Integer> enemyCoords = new ArrayList<>();
        enemyCoords.add(enemy.x);
        enemyCoords.add(enemy.y);
        int[] direction = AStar(enemyCoords, gameLogic.getPlayerCoordinates());
        int x = direction[0];
        int y = direction[1];
        int newX = enemy.x + x;
        int newY = enemy.y + y;
        boolean passed = newX >= 0 && newX < grid.gridWidth && newY >= 0 && newY < grid.gridLength&& grid.getCoordinateValue(newX, newY) != 5 && grid.getCoordinateValue(newX, newY) != -1;
        if(!passed){
            index = random.nextInt(directions.size());
            direction = directions.get(index);
            enemyCoords = new ArrayList<>();
            enemyCoords.add(enemy.x);
            enemyCoords.add(enemy.y);
//            direction = AStar(enemyCoords, gameLogic.getPlayerCoordinates());
            x = direction[0];
            y = direction[1];
            newX = enemy.x + x;
            newY = enemy.y + y;
            passed = newX >= 0 && newX < grid.gridWidth && newY >= 0 && newY < grid.gridLength&& grid.getCoordinateValue(newX, newY) != 5 && grid.getCoordinateValue(newX, newY) != -1;
        }
        if(passed){
            grid.setCoordinate(enemy.x, enemy.y, 0);
            enemy.x = newX;
            enemy.y = newY;
            if(grid.getCoordinateValue(newX, newY) != 1 && grid.getCoordinateValue(newX, newY) != 8){
                grid.setCoordinate(newX, newY, 3);
            }
            if(grid.getCoordinateValue(newX, newY) == 1){
                ConfigurationLogic playerConfig = gameLogic.getPlayerConfig();
                playerConfig.setHp(playerConfig.getHp() - playerConfig.getDamage());
                Log.d(TAG, "POKEMON.com");
            }
            if(grid.getCoordinateValue(newX, newY) == 8){
                return -1;
            }
        } else{

        }
        return 1;
    }

    private int[] AStar(List<Integer> enemy, List<Integer> player){
        int enemyX = enemy.get(0);
        int enemyY = enemy.get(1);
        int playerX = player.get(0);
        int playerY = player.get(1);
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        double heuristic = 1000;
        int[] ans = new int[2];
        for(int[] curr : dirs){
            int newX = curr[0] + enemyX;
            int newY = curr[1] + enemyY;
            double temp = Math.sqrt(Math.pow(newX - playerX, 2) + Math.pow(newY-playerY, 2));
            if(temp < heuristic){
                heuristic = temp;
                ans[0] = curr[0];
                ans[1] = curr[1];
            }

        }
        return ans;
    }


    public List<Enemy> getEnemies() {
        return enemies;
    }
}
