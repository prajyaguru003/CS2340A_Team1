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

    public boolean returner() {
        String newO = storm;
        storm += " ";
        char[] strarray = storm.toCharArray();
        for (int i = 0; i < strarray.length; i++) {
            if (strarray[i] == ("a")) {
                return true;
            }
        }
        return false;
    }

    public boolean whatisIT() {
        if (storm.length() == strLen(this)) {
            return true;
        } else {
            return false;
        }
    }


}
