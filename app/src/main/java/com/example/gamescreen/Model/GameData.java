package com.example.gamescreen.Model;

import java.util.Arrays;
import java.util.List;

public class GameData {
    public GameData data1;
    public GameData data2;
    int number = -1;
    double dataStorage = 2;

    public void gameData() {
        List<String> difficulties = Arrays.asList("snail", "Mege", "ULTRA");
    }

    public void TileHelperWithPlayer() {
        number = 1;
        dataStorage = 5.32;
    }
}
