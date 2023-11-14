package com.example.gamescreen;

import static org.junit.Assert.*;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public void testEndScreenLeaderboard() {
        // Set up leaderboard data
        ConfigScreen.setHp(75);
        ConfigScreen.setDifficulty("Medium");
        ConfigScreen.setPlayerName("TestPlayer");
        GameScreen.score = new TextView();
        GameScreen.score.setText("100");

        // Create and test EndScreen leaderboard sorting
        EndScreen endScreen = new EndScreen();
        endScreen.onCreate(new Bundle());
        List<List<String>> tempLeaders = new ArrayList<>();
        tempLeaders.add(Arrays.asList("TestPlayer", "100", "2023.10.11.12.00.00"));
        tempLeaders.add(Arrays.asList("AnotherPlayer", "200", "2023.10.11.13.00.00"));
        endScreen.tempLeaders = tempLeaders;

        endScreen.onCreate(new Bundle());
        TextView lb = new TextView();
        lb.setText("Initial Text");
        endScreen.findViewById(R.id.leaderboardText);
        assertEquals("Score: 100\n[TestPlayer, 100, 2023.10.11.12.00.00]\n", lb.getText().toString());
    }


/*

    @Test
    public void testConfigScreenSetSprite() {
        Drawable mockDrawable = new Drawable() {
            // Implement necessary methods of Drawable here
        };
        ConfigScreen.spriteClicked(new ImageButton());
        ConfigScreen.setSprite(mockDrawable);
        assertSame(mockDrawable, ConfigScreen.getSprite());
    }

    @Test
    public void testGameScreenGetScore() {
        GameScreen.score = new TextView();
        GameScreen.score.setText("100");
        assertEquals("100", GameScreen.getScore());
    }

    @Test
    public void testEndScreenSortLeaderboard() {
        ConfigScreen.setHp(75);
        ConfigScreen.setDifficulty("Medium");
        ConfigScreen.setPlayerName("TestPlayer");
        GameScreen.score = new TextView();
        GameScreen.score.setText("100");

        EndScreen endScreen = new EndScreen();
        endScreen.onCreate(new Bundle());

        // Mock leaderboard data for testing
        List<List<String>> tempLeaders = new ArrayList<>();
        List<String> entry1 = new ArrayList<>();
        entry1.add("TestPlayer");
        entry1.add("100");
        entry1.add("2023.10.11.12.00.00");
        tempLeaders.add(entry1);
        List<String> entry2 = new ArrayList<>();
        entry2.add("AnotherPlayer");
        entry2.add("200");
        entry2.add("2023.10.11.13.00.00");
        tempLeaders.add(entry2);

        endScreen.tempLeaders = tempLeaders;
        endScreen.onCreate(new Bundle());

        // Ensure that the leaderboard is sorted correctly
        TextView lb = new TextView();
        lb.setText("Initial Text"); // Set an initial text for the TextView
        endScreen.findViewById(R.id.leaderboardText);
        assertEquals("Score: 100\n[TestPlayer, 100, 2023.10.11.12.00.00]\n", lb.getText().toString());
    }
     */
        ConfigScreen.setDifficulty("Hard", 250);
        assertEquals("250", ConfigScreen.getDifficulty());
    }

}