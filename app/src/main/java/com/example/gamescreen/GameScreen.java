package com.example.gamescreen;
//import java.util.Map;
//import java.util.HashMap;
//import java.util.PriorityQueue;
//import java.util.List;
//import java.util.ArrayList;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.pm.ActivityInfo;
import android.graphics.Color;

import java.util.HashSet;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Set;
//import android.widget.ProgressBar;

public class GameScreen extends AppCompatActivity {
    private static int x;
    private static int y;
    private static int startX = 2;
    private static int startY = 20;
    private int tile;
    private static final String TAG = "GameScreen";
    private CountDownTimer countDownTimer;
    private static TextView score;
    private int numObstacles = 2;
    private static int[][] grid;
    private static int gridWidth;
    private static int gridHeight;
    private static int scale_X;
    private static int scale_Y;
    private ImageView player;

    private static Set<ImageView> obstacles;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        tile = 1;
        setContentView(R.layout.tile1);
        grid = Coordinate_grid.getGrid();
        Log.d(TAG, Arrays.deepToString(grid));
        scale_X = Coordinate_grid.get_scale_X();
        scale_Y = Coordinate_grid.get_scale_Y();
        gridHeight = grid.length;
        gridWidth = grid[0].length;
        obstacles = new HashSet<>();
        startCountdown(500);
        tile();
    }

    private void tile() {
        score = (TextView) findViewById(R.id.score);
        score.setTextColor(Color.WHITE);
        score.setText("500");
        player = (ImageView) findViewById(R.id.main_character);
        generateObstacles();
        player.setImageDrawable(ConfigScreen.getSprite());
        grid[y][x] = 1;
        x = startX;
        y = startY;
        player.post(() -> {
            player.setX(x * scale_X);
            player.setY(y * scale_Y);
            player.setVisibility(View.VISIBLE);
        });
        Button up = (Button) findViewById(R.id.btnup);
        Button down = (Button) findViewById(R.id.btndown);
        Button left = (Button) findViewById(R.id.btnleft);
        Button right = (Button) findViewById(R.id.btnright);
        moveRight(right, player);
        moveLeft(left, player);
        moveUp(up, player);
        moveDown(down, player);
        showSelected();
    }

    private void nextTile(){
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
            if(x+1 < grid.length && grid[y][x+1] > -1){
                grid[y][x] = 0;
                x++;
                player.setX(x * scale_X);
                if(collided()){
                    x--;
                    player.setX(x*scale_X);
                }
                if(grid[y][x] == 5){
                    Log.d(TAG, "POSITION OF CHARACTER: " + x + "    " + player.getX());
                    nextTile();
                }
                grid[y][x] = 1;
                Log.d(TAG, "FOR DA CULTURE: " + x + " " + y);


            } else{
                Log.d(TAG, "OUT OF BOUNDS!!! " + x + "     " + grid[y][x]);
            }
        });
    }

    private void moveLeft(Button button, ImageView player) {
        button.setOnClickListener(view -> {
            if(x-1 >= 0 && grid[y][x-1] > -1){
                grid[y][x] = 0;
                x--;
                player.setX(x * scale_X);
                if(collided()){
                    x++;
                    player.setX(x*scale_X);
                }
                grid[y][x] = 1;
                Log.d(TAG, "FOR DA CULTURE: " + x + " " + y);
            } else{
                Log.d(TAG, "OUT OF BOUNDS!!!");
            }
        });
    }

    private void moveUp(Button button, ImageView player) {
        button.setOnClickListener(view -> {
            if(y-1 >= 0 && grid[y-1][x] > -1){
                grid[y][x] = 0;
                y--;
                player.setY(y * scale_Y);
                if(collided()){
                    y++;
                    player.setY(y*scale_Y);
                }
                grid[y][x] = 1;
                Log.d(TAG, "FOR DA CULTURE: " + x + " " + y);
            } else{
                Log.d(TAG, "OUT OF BOUNDS!!!");
            }
        });
    }

    private void moveDown(Button button, ImageView player) {
        button.setOnClickListener(view -> {
            if(y+1 < grid[0].length && grid[y+1][x] > -1){
                grid[y][x] = 0;
                y++;
                player.setY(y * scale_Y);
                if(collided()){
                    y--;
                    player.setY(y*scale_Y);
                }
                grid[y][x] = 1;
                Log.d(TAG, "FOR DA CULTURE: " + x + " " + y);
            } else{
                Log.d(TAG, "OUT OF BOUNDS!!! " + y + " " + gridHeight);
                Log.d(TAG, Arrays.toString(grid[grid.length-4]));
                Log.d(TAG, Arrays.toString(grid[grid.length-3]));
                Log.d(TAG, Arrays.toString(grid[grid.length-2]));
                Log.d(TAG, Arrays.toString(grid[grid.length-1]));
            }
        });
    }
    public static String getScore() {
        return score.getText().toString();
    }
    private void generateObstacles(){
//        ViewGroup parentLayout = findViewById(R.id.parent_gamescreen);
//        Random random = new Random();
//        for(int i = 0; i<numObstacles; i++){
//            ImageView wall = new ImageView(this);
//            wall.setImageResource(R.drawable.stone_wall);
//            parentLayout.addView(wall);
//            int xSize = 10;
//            int ySize = 1;
//            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(xSize * scale_X, ySize * scale_Y);
//            wall.setLayoutParams(layoutParams);
//            int xRand = random.nextInt(gridWidth);
//            int yRand = random.nextInt(gridHeight);
//            while(grid[yRand][xRand] != 0){
//                xRand = random.nextInt(gridWidth);
//                yRand = random.nextInt(gridHeight);
//            }
//            wall.setX(xRand * scale_X);
//            wall.setY(yRand * scale_Y);
//            obstacles.add(wall);
//        }

        ImageView wall1 = (ImageView) findViewById(R.id.wall1);
        ImageView wall2 = (ImageView) findViewById(R.id.wall2);

        obstacles.add(wall1);
        obstacles.add(wall2);
    }

    private boolean collided(){
        Rect box1 = new Rect();
        Rect box2 = new Rect();
        for(ImageView wall : obstacles){
            player.getHitRect(box1);
            wall.getHitRect(box2);

            if(box1.intersect(box2)){
                return true;
            }
        }
        return false;
    }
}
