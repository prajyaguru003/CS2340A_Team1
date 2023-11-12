package com.example.gamescreen.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cs2340_game.R;

import ViewModel.ConfigurationLogic;
import ViewModel.TileConfigurationLogic;

public class GameView extends AppCompatActivity {
    ConfigurationLogic playerConfig;
    TileConfigurationLogic tileConfig;
    private static final String TAG = "GameView";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.tile1);
        playerConfig = ConfigurationLogic.getConfig();
        tileConfig = TileConfigurationLogic.getConfig();
        showSelected();
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
        ImageView player = (ImageView) findViewById(R.id.main_character);
        Log.d(TAG, "SPRITE: " + playerConfig.getSprite());
        player.setImageDrawable(playerConfig.getSprite());
    }
}