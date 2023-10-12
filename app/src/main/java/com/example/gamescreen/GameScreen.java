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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.pm.ActivityInfo;
import android.graphics.Color;

import androidx.appcompat.app.AppCompatActivity;
//import android.widget.ProgressBar;

public class GameScreen extends AppCompatActivity {
    private static float x;
    private static float y;
    private int tile;
    private static final String TAG = "GameScreen";
    private CountDownTimer countDownTimer;
    private static TextView score;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "TILEEEEEE " + tile);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        tile = 1;
        setContentView(R.layout.tile1);
        score = (TextView) findViewById(R.id.score);
        score.setTextColor(Color.WHITE);
        startCountdown();
        tile();
    }

    private void tile() {
        ImageView player = (ImageView) findViewById(R.id.main_character);
        player.setImageDrawable(ConfigScreen.getSprite());
        x = player.getX();
        y = player.getY();
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

    private void startCountdown() {
        Log.d(TAG, "COUNTDOWN 1");
        countDownTimer = new CountDownTimer(500000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long secondsLeft = millisUntilFinished / 1000;
                score.setText(String.valueOf(secondsLeft));
            }

            @Override
            public void onFinish() {
                //score.setText("Score: " + "0");
                //Intent intent = new Intent(GameScreen.this, EndScreen.class);
            }
        };
        countDownTimer.start();
    }

    private void moveRight(Button button, ImageView player) {
        button.setOnClickListener(view -> {
            x++;
            player.setX(x);
        });
    }

    private void moveLeft(Button button, ImageView player) {
        button.setOnClickListener(view -> {
            x--;
            player.setX(x);
        });
    }

    private void moveUp(Button button, ImageView player) {
        button.setOnClickListener(view -> {
            y++;
            player.setY(y);
        });
    }

    private void moveDown(Button button, ImageView player) {
        button.setOnClickListener(view -> {
            y--;
            player.setY(y);
        });
    }
    public static String getScore() {
        return score.getText().toString();
    }
}
