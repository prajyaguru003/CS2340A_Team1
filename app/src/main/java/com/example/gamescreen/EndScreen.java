package com.example.gamescreen;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;
import android.content.SharedPreferences;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EndScreen extends AppCompatActivity {
    TextView score;
    int currScore;
    int best1, best2, best3, best4, best5, best6, best7, best8, best9, best10;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.end_screen);
        TextView lb = (TextView) findViewById(R.id.leaderboardText);
        SharedPreferences prefs = getSharedPreferences("PREFS", 0);
        currScore = prefs.getInt("currScore", 0);
        best1 = prefs.getInt("best1", 0);
        best2 = prefs.getInt("best2", 0);
        best3 = prefs.getInt("best3", 0);
        best4 = prefs.getInt("best4", 0);
        best5 = prefs.getInt("best5", 0);
        lb.setText("Score: " + currScore + "\n" +
                "1. " + best1 + "\n" +
                "2. " + best2 + "\n" +
                "3. " + best3 + "\n" +
                "4. " + best4 + "\n" +
                "5. " + best5);
        TextView end = (TextView) findViewById(R.id.end);
        TextView leaderBoard = (TextView) findViewById(R.id.leaderBoard);
        Button restart = (Button) findViewById(R.id.restart);

        restart.setOnClickListener(view -> {
            Intent intent = new Intent(EndScreen.this, Welcome.class);
            startActivity(intent);
        });
    }
}
