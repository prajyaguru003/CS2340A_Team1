package com.example.gamescreen;
import java.util.Observable;
public interface Subject {
    public void addObserver(Observable observer);
    public void removeObserver(Observable observer);
    public void notifyObservers();
}
