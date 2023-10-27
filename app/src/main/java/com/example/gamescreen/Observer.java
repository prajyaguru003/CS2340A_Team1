package com.example.gamescreen;

public interface Observer {
    int x = 0;
    int y = 0;
    public void updatePosition(int[][] grid, int x, int y);
}
