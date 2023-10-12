package com.example.gamescreen;

import java.util.*;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
//import android.util.Log;
import android.widget.Button;
//import android.content.SharedPreferences;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import androidx.appcompat.app.AppCompatActivity;
import java.sql.Timestamp;
public class EndScreen extends AppCompatActivity {
    private TextView score;

    private static final String TAG = "EndScreen";

    private Leaderboard leaderboard = Leaderboard.getInstance();
    private int currScore;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.end_screen);
        Long dateTime = System.currentTimeMillis();
        Timestamp ts = new Timestamp(dateTime);
        List<String> temp = leaderboard.addWinner(ConfigScreen.getPlayerName(), GameScreen.getScore(), ts);

        TextView lb = (TextView) findViewById(R.id.leaderboardText);
        String leaderString = "";
        List<List<String>> tempLeaders = leaderboard.getSortedWinners();
        for (int i = 0; i < tempLeaders.size(); i++) {
            if (i % 2 == 0) {
                List<String> c = tempLeaders.get(i);
                leaderString = leaderString + "\n" + c;
            }
        }
        lb.setText("Score: " + temp.get(1) + "\n" + leaderString);
        TextView end = (TextView) findViewById(R.id.end);
        TextView leaderBoard = (TextView) findViewById(R.id.leaderBoard);
        Button restart = (Button) findViewById(R.id.restart);

        restart.setOnClickListener(view -> {
            Intent intent = new Intent(EndScreen.this, Welcome.class);
            startActivity(intent);
        });
    }
}
