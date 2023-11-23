package com.example.gamescreen.Model;

import java.util.Scanner;

import java.util.Arrays;
import java.util.List;

public class GameData {

  public ConfigurationData configData1;

    public GameData data1;

    public Integer intseter;
    public String storm = "Pribabu";
    public GameData data2;
    int number = -1;

    String newOne = null;
    double dataStorage = 2;

    public int dealWithIt (int number1) {
        number = number1;
        return number;
    }

    public int dontDealWithIt (int number2) {
        dataStorage = number2;
        return 2;
    }

    public void setStuff() {
        intseter = 2;
        storm = "no way";
    }

    public void gameData() {
        List<String> difficulties = Arrays.asList("snail", "Mege", "ULTRA");
    }

    public void TileHelperWithPlayer() {
        number = 1;
        dataStorage = 5.32;
    }


    public void TrechorusEnemies() {
        number = 5;
        dataStorage = 8.0009;
    }

    public GameData creator() {
        if (data1 == null) {
            data1 = new GameData();
        } else {
            return data1;
        }
        return data1;
    }

    public String editString(String coolio) {
        if (newOne == null) {
            newOne = coolio;
        } else {
            return newOne;
        }
        return newOne;
    }
}
