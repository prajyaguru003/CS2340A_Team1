package com.example.gamescreen;
//import java.util.Map;
//import java.util.HashMap;
//import java.util.PriorityQueue;
//import java.util.List;
//import java.util.ArrayList;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.pm.ActivityInfo;
import android.graphics.Color;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
//import android.widget.ProgressBar;

public class GameScreen extends AppCompatActivity {
    private static int x = 10;
    private static int y = 10;
    private int tile;
    private static final String TAG = "GameScreen";
    private CountDownTimer countDownTimer;
    private static TextView score;

    private static int[][] grid;
    private static int scale_X;
    private static int scale_Y;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        tile = 1;
        setContentView(R.layout.tile1);
        grid = Coordinate_grid.getGrid();
        Log.d(TAG, Arrays.deepToString(grid));
        scale_X = Coordinate_grid.get_scale_X();
        scale_Y = Coordinate_grid.get_scale_Y();
        tile();
    }

    private void tile() {
        score = (TextView) findViewById(R.id.score);
        score.setTextColor(Color.WHITE);
        score.setText("500");
        startCountdown(Integer.parseInt(score.getText().toString()));
        ImageView player = (ImageView) findViewById(R.id.main_character);
        player.setImageDrawable(ConfigScreen.getSprite());
        player.setX(x * scale_X);
        player.setY(y * scale_Y);
        grid[x][y] = 1;
        player.setVisibility(View.VISIBLE);
        Log.d(TAG, "XPOS: " + x + "     " + x * scale_X);
        Log.d(TAG, "YPOS: " + y + "     " + y * scale_Y);
        Log.d(TAG, "PLAYER XPOS: " + player.getX());
        Log.d(TAG, "PLAYER YPOS: " + player.getY());
        Button up = (Button) findViewById(R.id.btnup);
        Button down = (Button) findViewById(R.id.btndown);
        Button left = (Button) findViewById(R.id.btnleft);
        Button right = (Button) findViewById(R.id.btnright);
        moveRight(right, player);
        moveLeft(left, player);
        moveUp(up, player);
        moveDown(down, player);
        showSelected();
        Button next = (Button) findViewById(R.id.btnNextTile);
        next.setOnClickListener(view -> {
            if (tile == 1) {
                tile++;
                setContentView(R.layout.tile2);
                tile();
            } else if (tile == 2) {
                tile++;
                setContentView(R.layout.tile3);
                tile();
            } else if (tile == 3) {
                tile++;
                Intent intent = new Intent(GameScreen.this, EndScreen.class);
                startActivity(intent);
            }
        });

    }
    private void showSelected() {
        TextView name = (TextView) findViewById(R.id.name);
        name.setTextColor(Color.WHITE);
        TextView hp = (TextView) findViewById(R.id.health);
        hp.setTextColor(Color.WHITE);
        TextView diff = (TextView) findViewById(R.id.difficulty);
        diff.setTextColor(Color.WHITE);
        TextView tileNum = (TextView) findViewById(R.id.tileNum);
        tileNum.setTextColor(Color.WHITE);
        String n = "Name: " + ConfigScreen.getPlayerName();
        String health = "HP: " + ConfigScreen.gethp();
        String diffic = "Difficulty: " + ConfigScreen.getDifficulty();
        String setTile = "Tile: " + tile;
        name.setText(n);
        hp.setText(health);
        diff.setText(diffic);
        tileNum.setText(setTile);
    }

    private void startCountdown(int num) {
        Log.d(TAG, "COUNTDOWN 1");
        countDownTimer = new CountDownTimer(num*1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long secondsLeft = millisUntilFinished / 1000;
                score.setText(String.valueOf(secondsLeft));
            }

            @Override
            public void onFinish() {
                score.setText("Score: " + "0");
                Intent intent = new Intent(GameScreen.this, EndScreen.class);
            }
        };
        countDownTimer.start();
    }

    private void moveRight(Button button, ImageView player) {
        button.setOnClickListener(view -> {
            if(x+1 < grid.length && grid[x+1][y] != -1){
                grid[x][y] = 0;
                x++;
                player.setX(x * scale_X);
                grid[x][y] = 1;
            } else{
                Log.d(TAG, "OUT OF BOUNDS!!!");
            }
        });
    }

    private void moveLeft(Button button, ImageView player) {
        button.setOnClickListener(view -> {
            if(x-1 >= 0 && grid[x-1][y] != -1){
                grid[x][y] = 0;
                x--;
                player.setX(x * scale_X);
                grid[x][y] = 1;
            } else{
                Log.d(TAG, "OUT OF BOUNDS!!!");
            }
        });
    }

    private void moveUp(Button button, ImageView player) {
        button.setOnClickListener(view -> {
            if(y-1 >= 0 && grid[x][y-1] != -1){
                grid[x][y] = 0;
                y--;
                player.setY(y * scale_Y);
                grid[x][y] = 1;
            } else{
                Log.d(TAG, "OUT OF BOUNDS!!!");
            }
        });
    }

    private void moveDown(Button button, ImageView player) {
        button.setOnClickListener(view -> {
            if(y+1 < grid.length && grid[x][y+1] != -1){
                grid[x][y] = 0;
                y++;
                player.setY(y * scale_Y);
                grid[x][y] = 1;
            } else{
                Log.d(TAG, "OUT OF BOUNDS!!!");
            }
        });
    }
    public static String getScore() {
        return score.getText().toString();
    }
}
