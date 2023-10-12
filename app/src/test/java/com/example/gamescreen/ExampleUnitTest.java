package com.example.gamescreen;

import static org.junit.Assert.*;

import android.graphics.drawable.Drawable;
import android.widget.Button;
import android.widget.ImageButton;

import org.junit.Before;
import org.junit.Test;

public class ExampleUnitTest {

    @Test
    public void testConfigScreenSetHp() {
        ConfigScreen.setHp(75);
        assertEquals(75, ConfigScreen.gethp());
    }


    @Test
    public void testEasyDiff() {

        ConfigScreen.setDifficulty("Easy");
        assertEquals("100", ConfigScreen.getDifficulty());
    }
    @Test

    public void testMediumDiff() {

        ConfigScreen.setDifficulty("Medium");
        assertEquals("75", ConfigScreen.getDifficulty());
    }
    @Test

    public void testHardDiff() {

        ConfigScreen.setDifficulty("Hard");
        assertEquals("50", ConfigScreen.getDifficulty());
    }

    
}