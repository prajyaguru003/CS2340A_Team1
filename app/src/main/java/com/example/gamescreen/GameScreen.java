package com.example.gamescreen;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.pm.ActivityInfo;
import android.graphics.Color;

import androidx.appcompat.app.AppCompatActivity;
//import android.widget.ProgressBar;

public class GameScreen extends AppCompatActivity {

    private static float X;
    private static float Y;
    private static int tile;
    private static final String TAG = "GameScreen";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        tile = 1;
        setContentView(R.layout.tile1);
        tile();
    }
    private void tile(){
        Log.d(TAG, "TILE NUMBER " + tile);
        ImageView player = (ImageView) findViewById(R.id.main_character);
        player.setImageDrawable(ConfigScreen.getSprite());
        X = player.getX();
        Y = player.getY();
        Log.d(TAG, "X COORDINATE" + " " + X);
        Log.d(TAG, "Y COORDINATE" + " " + Y);
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
            if(tile == 1) {
                tile++;
                setContentView(R.layout.tile2);
                tile();
            } else if(tile == 2) {
                tile++;
                setContentView(R.layout.tile3);
                tile();
            } else if(tile == 3) {
                Intent intent = new Intent(GameScreen.this, EndScreen.class);
                startActivity(intent);
            }
        });
    }
    private void moveRight(Button button, ImageView player){
        button.setOnClickListener(view -> {
            X++;
            player.setX(X);
        });
    }
    private void moveLeft(Button button, ImageView player){
        button.setOnClickListener(view -> {
            X--;
            player.setX(X);
        });
    }
    private void moveUp(Button button, ImageView player){
        button.setOnClickListener(view -> {
            Y++;
            player.setY(Y);
        });
    }
    private void moveDown(Button button, ImageView player){
        button.setOnClickListener(view -> {
            Y--;
            player.setY(Y);
        });
    }
    private void showSelected() {
        Log.d(TAG, "SHOWING SELECTED");
        TextView name = (TextView) findViewById(R.id.name);
        name.setTextColor(Color.WHITE);
        Log.d(TAG, "SHOWING SELECTED 1 AND TILE " + tile);
        TextView hp = (TextView) findViewById(R.id.health);
        Log.d(TAG, "SHOWING SELECTED 2 AND TILE " + tile);
        hp.setTextColor(Color.WHITE);
        Log.d(TAG, "SHOWING SELECTED 3 AND TILE " + tile);
        TextView diff = (TextView) findViewById(R.id.difficulty);
        diff.setTextColor(Color.WHITE);
        Log.d(TAG, "SHOWING SELECTED 4 AND TILE " + tile);
        TextView tileNum = (TextView) findViewById(R.id.tileNum);
        if(tileNum == null){
            Log.d(TAG, "YOOOOOOOOOOOOO");
        }
        tileNum.setTextColor(Color.WHITE);
        Log.d(TAG, "SHOWING SELECTED 5 AND TILE " + tile);
        String n = "Name: " + ConfigScreen.getPlayerName();
        String health = "HP: " + ConfigScreen.gethp();
        String diffic = "Difficulty: " + ConfigScreen.getDifficulty();
        String setTile = "Tile: " + tile;
        Log.d(TAG, "SHOWING SELECTED 2 AND TILE " + tile);
        name.setText(n);
        hp.setText(health);
        diff.setText(diffic);
        tileNum.setText(setTile);
    }
}
