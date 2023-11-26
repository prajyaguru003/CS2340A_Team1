package com.example.gamescreen.Model;

import java.util.Arrays;
import java.util.List;

public class GameData {

  public ConfigurationData configData1;

    public GameData data1;

    public Integer intseter;
    public String storm = "Kruither";
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

    public int multiplyNums() {
        int n = number;
        if (number != 0) {
            n = n * n;
        }
        return n;
    }

    public boolean giveString(String storm) {
        if (!storm.isEmpty() || storm != null) {
            this.storm = storm;
            return true;
        }
        return false;

    }

    public String isGameDataTrue() {
        if (data1 == null) {
            return "GameData is True";
        }
        if (configData1 == null) {
            return "ConfigData is true but not GameData";
        }
        return "neither are true";
    }

    public boolean createConfigData() {
        if (this.configData1 == null) {
            configData1 = new ConfigurationData();
            return true;
        }
        return false;
    }

}
