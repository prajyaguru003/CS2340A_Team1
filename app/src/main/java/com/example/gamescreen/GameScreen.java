package com.example.gamescreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
//import android.widget.ProgressBar;

public class GameScreen extends AppCompatActivity {

    //    private static Drawable character;
    //    private static int[] position;
    private int scoreInt = 500;
    TextView score;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);
        //ProgressBar health = (ProgressBar) findViewById(R.id.health_bar);
        Button interact = (Button) findViewById(R.id.interact);
        //Button up = (Button) findViewById(R.id.move_up);
        //Button down = (Button) findViewById(R.id.move_down);
        //Button left = (Button) findViewById(R.id.move_left);
        //Button right = (Button) findViewById(R.id.move_right);
        ImageView player = (ImageView) findViewById(R.id.character);
        player.setImageDrawable(ConfigScreen.getSprite());
        score = (TextView) findViewById(R.id.scoreBar);
        score.setText("Score: " + scoreInt);
        //position = new int[2];
        showSelected();
        startCountdown();
        interact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("lastScore", scoreInt);
                editor.apply();
//                Intent intent
            }
        });

    }

    private void showSelected() {
        TextView name = (TextView) findViewById(R.id.nameSelect);
        TextView hp = (TextView) findViewById(R.id.healthSelect);
        TextView diff = (TextView) findViewById(R.id.difficultySelect);
        String n = "Name: " + ConfigScreen.getPlayerName();
        String health = "HP: " + ConfigScreen.gethp();
        String diffic = "Difficulty: " + ConfigScreen.getDifficulty();
        name.setText(n);
        hp.setText(health);
        diff.setText(diffic);

        Button acknowledge = (Button) findViewById(R.id.interact);
        acknowledge.setOnClickListener(view -> {
            Intent intent = new Intent(GameScreen.this, EndScreen.class);
            startActivity(intent);
        });
    }
    private void startCountdown() {
        CountDownTimer countDownTimer = new CountDownTimer(500000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long secondsLeft = millisUntilFinished / 1000;
                score.setText(String.valueOf(secondsLeft));
            }
            @Override
            public void onFinish() {
                score.setText("0");
                Intent intent = new Intent(GameScreen.this, EndScreen.class);
            }
        };
        countDownTimer.start();
    }
    //    private void movement() {
    //
    //    }
    //
    //    private void lost() {
    //
    //    }
}
