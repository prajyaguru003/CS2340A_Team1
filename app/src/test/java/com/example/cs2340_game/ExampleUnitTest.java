package com.example.cs2340_game;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.gamescreen.ViewModel.ConfigurationLogic;
import com.example.gamescreen.ViewModel.GameLogic;
import com.example.gamescreen.ViewModel.Grid;

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
        int width = gameLogic.getPixelWidth();
        assertEquals(40, width);
    }
    @Test
    public void testPixelHeight() {
        ConfigurationLogic playerConfig = new ConfigurationLogic();
        GameLogic gameLogic = new GameLogic(1000, 1000, playerConfig);
        int height = gameLogic.getPixelHeight();
        assertEquals(40, height);
    }
}