package com.example.gamescreen;
//import java.util.Map;
//import java.util.HashMap;
//import java.util.PriorityQueue;
//import java.util.List;
//import java.util.ArrayList;

import android.content.Intent;
//import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.DisplayMetrics;
//import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
//import android.widget.ProgressBar;

public class CoordinateGrid extends AppCompatActivity {

    private static int[][] grid;
    private static int gridHeight = 50;
    private static int gridWidth = 50;
    private static int scaleX;
    private static int scaleY;
    private static int layoutWidth;
    private static int layoutHeight;
    private static final String TAG = "CoordinateGrid";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        layoutHeight = displayMetrics.widthPixels;
        layoutWidth = displayMetrics.heightPixels;
        scaleX = layoutWidth / gridWidth;
        scaleY = layoutHeight / gridHeight;
        grid = new int[gridHeight][gridWidth];
        setGrid();
        //        Log.d(TAG, "HEYYYYYY!!!!!!!! " + layoutWidth + " " + layoutHeight);
        Intent intent = new Intent(CoordinateGrid.this, Welcome.class);
        startActivity(intent);
    }
    public static int[][] getGrid() {
        return grid;
    }
    public static int getScaleX() {
        return scaleX;
    }
    public static int getScaleY() {
        return scaleY;
    }
    private void setGrid() {
        setColumn(0, -1);
        setColumn(gridWidth - 1, -1);
        setColumn(gridWidth - 2, 5);
        setRow(0, -1);
        setRow(gridHeight - 10, -1);
        setRow(gridHeight - 9, -1);
        setRow(gridHeight - 8, -1);
        setRow(gridHeight - 7, -1);
        setRow(gridHeight - 6, -1);
        setRow(gridHeight - 5, -1);
        setRow(gridHeight - 4, -1);
        setRow(gridHeight - 3, -1);
        setRow(gridHeight - 2, -1);
        setRow(gridHeight - 1, -1);
    }
    public static void setColumn(int j, int value) {
        for (int i = 0; i < gridHeight; i++) {
            grid[i][j] = value;
        }
    }
    public static void setRow(int i, int value) {
        for (int j = 0; j < gridWidth; j++) {
            grid[i][j] = value;
        }
    }
}
