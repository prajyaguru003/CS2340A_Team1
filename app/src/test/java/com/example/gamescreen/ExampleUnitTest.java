package com.example.gamescreen;

import static org.junit.Assert.*;

import android.graphics.drawable.Drawable;
import android.widget.Button;
import android.widget.ImageButton;

import org.junit.Before;
import org.junit.Test;

public class ExampleUnitTest {

    @Test
    public void testConfigScreenSetHp75() {
        ConfigScreen.setHp(75);
        assertEquals(75, ConfigScreen.gethp());
    }
    @Test
    public void testConfigScreenSetHp100() {
        ConfigScreen.setHp(100);
        assertEquals(100, ConfigScreen.gethp());
    }
    @Test
    public void testConfigScreenSetHpNegative() {
        ConfigScreen.setHp(-10);
        assertEquals(0, ConfigScreen.gethp());
    }
    @Test
    public void testConfigScreenSetHp150() {
        ConfigScreen.setHp(150);
        assertEquals(150, ConfigScreen.gethp());
    }
    @Test
    public void testEasyDiff100() {

        ConfigScreen.setDifficulty("Easy", 100);
        assertEquals("100", ConfigScreen.getDifficulty());
    }
    @Test

    public void testMediumDiff75() {

        ConfigScreen.setDifficulty("Medium", 75);
        assertEquals("75", ConfigScreen.getDifficulty());
    }
    @Test

    public void testHardDiff50() {

        ConfigScreen.setDifficulty("Hard", 50);
        assertEquals("50", ConfigScreen.getDifficulty());
    }
    @Test
    public void testEasyDiff200() {

        ConfigScreen.setDifficulty("Easy", 200);
        assertEquals("200", ConfigScreen.getDifficulty());
    }
    @Test

    public void testMediumDiff150() {

        ConfigScreen.setDifficulty("Medium", 150);
        assertEquals("150", ConfigScreen.getDifficulty());
    }
    @Test

    public void testHardDiff125() {

        ConfigScreen.setDifficulty("Hard", 125);
        assertEquals("125", ConfigScreen.getDifficulty());
    }
    @Test
    public void testEasyDiff300() {

        ConfigScreen.setDifficulty("Easy", 300);
        assertEquals("300", ConfigScreen.getDifficulty());
    }
    @Test

    public void testMediumDiff275() {

        ConfigScreen.setDifficulty("Medium", 275);
        assertEquals("275", ConfigScreen.getDifficulty());
    }
    @Test

    public void testHardDiff250() {

        ConfigScreen.setDifficulty("Hard", 250);
        assertEquals("250", ConfigScreen.getDifficulty());
    }
}