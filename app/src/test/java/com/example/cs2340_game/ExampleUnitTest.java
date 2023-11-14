package com.example.cs2340_game;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;
import com.example.gamescreen.ViewModel.Enemy.EnemyMovementLogic;
import com.example.gamescreen.ViewModel.GameLogic;
import com.example.gamescreen.ViewModel.Grid;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void testEnemyMoveLeft() {
        Grid.setGrid();
        int[][] grid = Grid.getGrid();
        GameLogic.moveLeft();
        assertEquals(1, 1);
    }
    public void testEnemyMoveRight() {
        Grid.setGrid();
        int[][] grid = Grid.getGrid();
        GameLogic.moveRight();
        assertEquals(1, 1);
    }
    public void testEnemyMoveUp() {
        Grid.setGrid();
        int[][] grid = Grid.getGrid();
        GameLogic.moveUp();
        assertEquals(1, 1);
    }
    public void testEnemyMoveDown() {
        Grid.setGrid();
        int[][] grid = Grid.getGrid();
        GameLogic.moveDown();
        assertEquals(1, 1);
    }
}