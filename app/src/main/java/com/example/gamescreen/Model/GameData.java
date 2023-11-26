package com.example.gamescreen.Model;

import java.util.Arrays;
import java.util.List;

public class GameData {

  public ConfigurationData configData1;

    public GameData data1;

    public Integer intseter;
    public String storm = "Pribabu";
    int number = -1;

    String newOne = null;

    public int dealWithIt (int number1) {
        number = number1;
        return number;
    }
    public boolean addNums() {
        int s = number + 2;
        if (s < 0) {
            return true;
        }
        return false;
    }
    private boolean newGD() {
        GameData newOne = new GameData();
        data1 = newOne;
        newOne.intseter = 2;
        newOne.number = 3;
        return true;
    }

    public boolean newGameData() {
        if (data1 == null) {
            return newGD();
        }
        return false;
    }

    public GameData getGameData() {
        return this.data1;
    }
}
