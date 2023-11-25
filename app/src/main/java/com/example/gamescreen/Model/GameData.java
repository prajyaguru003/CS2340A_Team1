package com.example.gamescreen.Model;

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

    public int redo() {
        intseter = 2;
        return intseter + number;
    }

    public double calculation() {
        int fui = 2;
        fui = number < 2 ? number + number : fui;
        return fui;
    }
    


    public int strLen(GameData gameData) {
        int len = storm. length();
        len = len + len;
        len = len*2;
        len = len*3;
        return len;
    }

    public boolean whatisIT() {
        if (storm.length() == strLen(this)) {
            return true;
        } else {
            return false;
        }
    }


}
