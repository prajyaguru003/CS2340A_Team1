package com.example.gamescreen;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class WallSubject implements Subject {
    private static final String TAG = "WallObservableSubject";
    List<PlayerObserver> observers;
    WallSubject subject;
    private WallSubject(){
        subject = new WallSubject();
        observers = new ArrayList<>();
    }
    public void addObserver(PlayerObserver observer) {
        observers.add(observer);
    }
    public void notifyObservers(int[][] grid, int i, int j){
        for(PlayerObserver c : observers){
            int x = c.x;
            int y = c.y;
            if(grid[x][y] != 0) {
                c.updatePosition(grid, i, j);
                Log.d(TAG, "OBJECT IS HERE!!!!");
            }
        }
    }
    public void removeObserver(PlayerObserver observer){
        observers.remove(observer);
    }

}
