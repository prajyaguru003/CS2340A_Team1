package com.example.gamescreen;

import java.util.*;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.content.SharedPreferences;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EndScreen extends AppCompatActivity {
    TextView score;

    private static final String TAG = "EndScreen";
    int currScore;

    private static List<List<String>> tempLeaders;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.end_screen);
        if(tempLeaders == null){
            tempLeaders = new ArrayList<>();
        }
        List<String> temp = new ArrayList<>();
        temp.add(ConfigScreen.getPlayerName());
        temp.add(GameScreen.getScore());
        tempLeaders.add(temp);
        Collections.sort(tempLeaders, (a,b) -> Integer.parseInt(b.get(1)) - Integer.parseInt(a.get(1)));

        TextView lb = (TextView) findViewById(R.id.leaderboardText);
        String leaderString = "";
        for(int i = 0; i < tempLeaders.size(); i++){
            if(i%2 == 0){
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
