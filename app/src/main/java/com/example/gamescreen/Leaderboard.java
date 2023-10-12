package com.example.gamescreen;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

public class Leaderboard {
    private static Leaderboard leaderboard;
    private static final SimpleDateFormat S = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    private List<List<String>> winners;
    private Leaderboard(){
        winners = new ArrayList<>();
    }
    public static Leaderboard getInstance(){
        if(leaderboard == null){
            leaderboard = new Leaderboard();
        }
        return leaderboard;
    }
    public List<List<String>> getSortedWinners(){
        Collections.sort(winners, (a, b) ->
                Integer.parseInt(b.get(1)) - Integer.parseInt(a.get(1)));
        return winners;
    }
    public List<String> addWinner(String name, String score, Timestamp ts){
        List<String> temp = new ArrayList<>();
        temp.add(name);
        temp.add(score);
        temp.add(S.format(ts));
        winners.add(temp);
        return temp;
    }
}
