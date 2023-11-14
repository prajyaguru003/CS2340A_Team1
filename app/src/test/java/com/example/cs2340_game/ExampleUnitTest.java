package com.example.cs2340_game;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

import com.example.gamescreen.ViewModel.ConfigurationLogic;
import com.example.gamescreen.ViewModel.Enemy.EnemyMovementLogic;
import com.example.gamescreen.ViewModel.GameLogic;
import com.example.gamescreen.ViewModel.Grid;

import java.util.ArrayList;
import java.util.List;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void testPixelWidth() {
        ConfigurationLogic playerConfig = new ConfigurationLogic();
        GameLogic gameLogic = new GameLogic(1000, 1000, playerConfig);
        int pixelWidth = gameLogic.getPixelWidth();
        assertEquals(40, pixelWidth);
    }
    @Test
    public void testPixelLength() {
        ConfigurationLogic playerConfig = new ConfigurationLogic();
        GameLogic gameLogic = new GameLogic(1000, 1000, playerConfig);
        int pixelLength = gameLogic.getPixelHeight();
        assertEquals(40, pixelLength);
    }
    @Test
    public void testPlayerStartingX() {
        ConfigurationLogic playerConfig = new ConfigurationLogic();
        GameLogic gameLogic = new GameLogic(1000, 1000, playerConfig);
        List<Integer> playerCoordinates = gameLogic.getPlayerCoordinates();
        int x = playerCoordinates.get(0);
        assertEquals(9, x);
    }
    @Test
    public void testPlayerStartingY() {
        ConfigurationLogic playerConfig = new ConfigurationLogic();
        GameLogic gameLogic = new GameLogic(1000, 1000, playerConfig);
        List<Integer> playerCoordinates = gameLogic.getPlayerCoordinates();
        int y = playerCoordinates.get(1);
        assertEquals(9, y);
    }
    @Test
    public void testPlayerPixelX() {
        ConfigurationLogic playerConfig = new ConfigurationLogic();
        GameLogic gameLogic = new GameLogic(1000, 1000, playerConfig);
        List<Integer> playerPixels = gameLogic.getPlayerPixels();
        int pixelX = playerPixels.get(0);
        assertEquals(40 * 9, pixelX);
    }
    @Test
    public void testPlayerPixelY() {
        ConfigurationLogic playerConfig = new ConfigurationLogic();
        GameLogic gameLogic = new GameLogic(1000, 1000, playerConfig);
        List<Integer> playerPixels = gameLogic.getPlayerPixels();
        int pixelY = playerPixels.get(1);
        assertEquals(40 * 9, pixelY);
    }
    @Test
    public void testMoveRightX() {
        ConfigurationLogic playerConfig = new ConfigurationLogic();
        GameLogic gameLogic = new GameLogic(1000, 1000, playerConfig);
        List<Integer> playerPixels = gameLogic.moveRight();
        int pixelX = playerPixels.get(0);
        assertEquals(40 * 10, pixelX);
    }
    @Test
    public void testMoveRightY() {
        ConfigurationLogic playerConfig = new ConfigurationLogic();
        GameLogic gameLogic = new GameLogic(1000, 1000, playerConfig);
        List<Integer> playerPixels = gameLogic.moveRight();
        int pixelY = playerPixels.get(1);
        assertEquals(40 * 9, pixelY);
    }
    @Test
    public void testMoveUpX() {
        ConfigurationLogic playerConfig = new ConfigurationLogic();
        GameLogic gameLogic = new GameLogic(1000, 1000, playerConfig);
        List<Integer> playerPixels = gameLogic.moveUp();
        int pixelX = playerPixels.get(0);
        assertEquals(40 * 9, pixelX);
    }
    @Test
    public void testMoveUpY() {
        ConfigurationLogic playerConfig = new ConfigurationLogic();
        GameLogic gameLogic = new GameLogic(1000, 1000, playerConfig);
        List<Integer> playerPixels = gameLogic.moveUp();
        int pixelY = playerPixels.get(1);
        assertEquals(40 * 9, pixelY);
    }
    @Test
    public void testCheckGoal() {
        ConfigurationLogic playerConfig = new ConfigurationLogic();
        GameLogic gameLogic = new GameLogic(1000, 1000, playerConfig);
        boolean check = gameLogic.checkGoal(23, 13);
        assertEquals(true, check);
    }
    @Test
    public void checkConfigSame() {
        ConfigurationLogic playerConfig = new ConfigurationLogic();
        GameLogic gameLogic = new GameLogic(1000, 1000, playerConfig);
        ConfigurationLogic test = GameLogic.getPlayerConfig();
        assertEquals(playerConfig, test);
    }

}