package com.example.gamescreen;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.pm.ActivityInfo;
import android.graphics.Color;

import androidx.appcompat.app.AppCompatActivity;
//import android.widget.ProgressBar;

public class GameScreen extends AppCompatActivity {

    //    private static Drawable character;
//        private static int[] position;
    private static final String TAG = "GameScreen";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.tile1);
        ImageView player = (ImageView) findViewById(R.id.main_character);
        player.setImageDrawable(ConfigScreen.getSprite());
        showSelected();

    }

    private void showSelected() {
        TextView name = (TextView) findViewById(R.id.name);
        name.setTextColor(Color.WHITE);
        TextView hp = (TextView) findViewById(R.id.health);
        hp.setTextColor(Color.WHITE);
        TextView diff = (TextView) findViewById(R.id.difficulty);
        diff.setTextColor(Color.WHITE);
        String n = "Name: " + ConfigScreen.getPlayerName();
        String health = "HP: " + ConfigScreen.gethp();
        String diffic = "Difficulty: " + ConfigScreen.getDifficulty();
        name.setText(n);
        hp.setText(health);
        diff.setText(diffic);
    }
}
