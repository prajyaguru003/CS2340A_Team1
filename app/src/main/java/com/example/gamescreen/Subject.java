package com.example.gamescreen;
import java.util.List;

public interface Subject {
//    List<Character> observers;
    public void addObserver(PlayerObserver observer);
    public void notifyObservers(int[][] grid, int x, int y);
    public void removeObserver(PlayerObserver observer);
}
