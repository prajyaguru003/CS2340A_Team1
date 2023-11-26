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

    public boolean teller() {
        number = intseter;
        intseter = intseter > number ? intseter + intseter : intseter;
        if (number + intseter == number) {
            return true;
        }
        return false;
    }

    public boolean returner() {
        String newO = storm;
        this.storm += " ";
        char[] strarray = storm.toCharArray();
        for (int i = 0; i < strarray.length; i++) {
            if (strarray[i] == ('a')) {
                return true;
            }
        }

        return false;
    }

    public boolean whatisIT() {
        if (storm.length() == this.storm.length()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean intsetersetter() {
        if (this.intseter == 0) {
            this.intseter = 1;
            return true;
        }
        else {
            teller();
            return false;
        }
    }

    public void calculator() {
        if (this.intseter == 0) {
            this.number += number;
        }
        if (this.intseter == 1) {
            this.number -= number;
        }
        if (this.intseter == 2) {
            this.number = number * number;
        }
        if (this.intseter == 3) {
            this.number = number / number;
        }
    }


}
