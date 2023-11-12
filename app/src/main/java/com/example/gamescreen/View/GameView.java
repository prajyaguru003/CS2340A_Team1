package com.example.gamescreen.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cs2340_game.R;

import com.example.gamescreen.ViewModel.ConfigurationLogic;
import com.example.gamescreen.ViewModel.GameLogic;
import com.example.gamescreen.ViewModel.Player;
import com.example.gamescreen.ViewModel.TileConfigurationLogic;

import java.util.ArrayList;
import java.util.List;

public class GameView extends AppCompatActivity {
    ConfigurationLogic playerConfig;
    TileConfigurationLogic tileConfig;
    GameLogic gameLogic;
    ImageView player;
    private static final String TAG = "GameView";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.tile1);
        playerConfig = ConfigurationLogic.getConfig();
        tileConfig = TileConfigurationLogic.getConfig();
        DisplayMetrics display = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(display);
        int screenWidth = display.heightPixels;
        int screenLength = display.widthPixels;
        gameLogic = new GameLogic(screenLength, screenWidth);
        player = (ImageView) findViewById(R.id.main_character);
        List<Integer> pixelCoordinates = gameLogic.getPlayerPixels();
        player.setX(pixelCoordinates.get(0));
        player.setY(pixelCoordinates.get(1));
        showSelected();
        gameOn();
    }
    private void gameOn(){
        Button up = (Button) findViewById(R.id.btnup);
        Button down = (Button) findViewById(R.id.btndown);
        Button left = (Button) findViewById(R.id.btnleft);
        Button right = (Button) findViewById(R.id.btnright);
        buttonClicked(up, "up");
        buttonClicked(down, "down");
        buttonClicked(left, "left");
        buttonClicked(right, "right");
    }
    private void buttonClicked(Button button, String btnID){
        Log.d(TAG, "POSSSSIIITIOOONN" + " " + player.getX() + " " + player.getY());
        button.setOnClickListener(view -> {
            List<Integer> playerPos = new ArrayList<>();
            if(btnID == "up"){
                playerPos = gameLogic.moveUp();
            }
            if(btnID == "down"){
                playerPos = gameLogic.moveDown();
            }
            if(btnID == "left"){
                playerPos = gameLogic.moveLeft();
            }
            if(btnID == "right"){
                playerPos = gameLogic.moveRight();
            }
            playerConfig.setPixelX(playerPos.get(0));
            playerConfig.setPixelY(playerPos.get(1));
            player.setX(playerConfig.getPixelX());
            player.setY(playerConfig.getPixelY());
            Log.d(TAG, "POSSSSIIITIOOONN" + " " + player.getX() + " " + player.getY());
            Log.d(TAG, "POSSSSIIITIOOONN" + " " + gameLogic.getPlayerCoordinates().toString());
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
        String n = "Name: " + playerConfig.getName();
        String health = "HP: " + playerConfig.getHp();
        String diffic = "Difficulty: " + playerConfig.getDifficulty();
        String setTile = "Tile: " + tileConfig.getTileNum();
        name.setText(n);
        hp.setText(health);
        diff.setText(diffic);
        tileNum.setText(setTile);
        Log.d(TAG, "SPRITE: " + playerConfig.getSprite());
        player.setImageDrawable(playerConfig.getSprite());
    }
}