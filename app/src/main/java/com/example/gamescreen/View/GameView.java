package com.example.gamescreen.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cs2340_game.R;

import com.example.gamescreen.ViewModel.ConfigurationLogic;
import com.example.gamescreen.ViewModel.GameLogic;
import com.example.gamescreen.ViewModel.Grid;
import com.example.gamescreen.ViewModel.MainActivity;
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
        player = new ImageView(this);
        player.setImageDrawable(playerConfig.getSprite());
        List<Integer> pixelCoordinates = gameLogic.getPlayerPixels();
        ConstraintLayout.LayoutParams playerParams = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
        );
        playerParams.width = gameLogic.getPixelWidth();
        playerParams.height = gameLogic.getPixelHeight();
        player.setLayoutParams(playerParams);
        ConstraintLayout layout = findViewById(R.id.parent_gamescreen);
        layout.addView(player);
        player.setX(pixelCoordinates.get(0));
        player.setY(pixelCoordinates.get(1));
        showSelected();
        generateWalls();
        setStar();
        gameOn();
    }
    private void generateWalls(){
        int[][] grid = gameLogic.getGrid();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 5){
                    Log.d(TAG, "THERE IS A 5 HERE");
                    ImageView wall = new ImageView(this);
                    wall.setImageResource(R.drawable.stonewall);
                    ConstraintLayout.LayoutParams wallParams = new ConstraintLayout.LayoutParams(
                            ConstraintLayout.LayoutParams.WRAP_CONTENT,
                            ConstraintLayout.LayoutParams.WRAP_CONTENT
                    );
                    wallParams.width = gameLogic.getPixelWidth();
                    wallParams.height = gameLogic.getPixelHeight();
                    wall.setLayoutParams(wallParams);
                    ConstraintLayout layout = findViewById(R.id.parent_gamescreen);
                    layout.addView(wall);
                    wall.setX(i * gameLogic.getPixelWidth());
                    wall.setY(j * gameLogic.getPixelHeight());
                }
            }
        }
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
            List<Integer> playerCoordinates = gameLogic.getPlayerCoordinates();
            if(gameLogic.checkGoal(playerCoordinates.get(0), playerCoordinates.get(1))) {
                Log.d(TAG, "FOUND THE STAR!!!!!!");
                Intent intent = new Intent(GameView.this, GameView.class);
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
        String n = "Name: " + playerConfig.getName();
        String health = "HP: " + playerConfig.getHp();
        String diffic = "Difficulty: " + playerConfig.getDifficulty();
        String setTile = "Tile: " + tileConfig.getTileNum();
        name.setText(n);
        hp.setText(health);
        diff.setText(diffic);
        tileNum.setText(setTile);
        Log.d(TAG, "SPRITE: " + playerConfig.getSprite());
    }
    private void setStar(){
        ImageView star = new ImageView(this);
        star.setImageResource(R.drawable.goldstar);
        ConstraintLayout.LayoutParams wallParams = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
        );
        wallParams.width = gameLogic.getPixelWidth();
        wallParams.height = gameLogic.getPixelHeight();
        star.setLayoutParams(wallParams);
        ConstraintLayout layout = findViewById(R.id.parent_gamescreen);
        layout.addView(star);
        int[] goldStarCoordinates = gameLogic.getGoldStar();
        star.setX(gameLogic.getPixelWidth() * goldStarCoordinates[0]);
        star.setY(gameLogic.getPixelHeight()* goldStarCoordinates[1]);
    }
}