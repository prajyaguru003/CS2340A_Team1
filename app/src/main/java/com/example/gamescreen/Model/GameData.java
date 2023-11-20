package com.example.gamescreen.Model;
import java.uti.Scanner;
public class GameData {


    public GameData data1;

    public Integer intseter;
    public String storm = "Pribabu";
    public GameData data2;
    int number = -1;
    double dataStorage = 2;

    public int dealWithIt (int number1) {
        number = number1;
    }

    public int dontDealWithIt (int number2) {
        dataStorage = number2;
    }

    public void setStuff() {
        intseter = 2;
        storm = "no way";
    }

}
