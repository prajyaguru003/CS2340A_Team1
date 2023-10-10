package com.example.gamescreen;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EndScreen extends AppCompatActivity {
    TextView score;
    int currScore;
    int best1, best2, best3, best4, best5, best6, best7, best8, best9, best10;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        setContentView(R.layout.end_screen);
    }
}
