package com.example.gamescreen;
//import java.util.Map;
//import java.util.HashMap;
//import java.util.PriorityQueue;
//import java.util.List;
//import java.util.ArrayList;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
//import android.widget.ProgressBar;

public class Coordinate_grid extends AppCompatActivity {

    private static int[][] grid;
    private static int grid_height = 50;
    private static int grid_width = 50;
    private static int scale_X;
    private static int scale_Y;
    private static int layout_width;
    private static int layout_height;
    private static final String TAG = "Coordinate_grid";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        layout_height = displayMetrics.widthPixels;
        layout_width = displayMetrics.heightPixels;
        scale_X = layout_width/grid_width;
        scale_Y = layout_height/grid_height;
        grid = new int[grid_height][grid_width];
        setGrid();
//        Log.d(TAG, "HEYYYYYY!!!!!!!! " + layout_width + " " + layout_height);
        Intent intent = new Intent(Coordinate_grid.this, Welcome.class);
        startActivity(intent);
    }
    public static int[][] getGrid(){
        return grid;
    }
    public static int get_scale_X(){
        return scale_X;
    }
    public static int get_scale_Y(){
        return scale_Y;
    }

    private void setGrid(){
        for(int i = 0; i<grid.length; i++){
            grid[i][0] = -1;
        }
        for(int i = 0; i<grid.length; i++){
            grid[i][grid[0].length-1] = -1;
        }
        for(int j = 0; j<grid[0].length; j++){
            grid[0][j] = -1;
        }
        for(int j = 0; j<grid[0].length; j++){
            grid[grid.length-1][j] = -1;
        }
    }
}
