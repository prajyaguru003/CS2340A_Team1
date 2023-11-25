package com.example.gamescreen;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.*;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.TextView;

public class EndScreen extends AppCompatActivity {

    private static String end = "The End";

    TextView score;
    int currScore;
    int best1, best2, best3, best4, best5, best6, best7, best8, best9, best10;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_screen);
        TextView done = (TextView) findViewById(R.id.textView);
        done.setText(end);
        Button restart = (Button) findViewById(R.id.restart);
        restart.setText("Restart?");
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EndScreen.this, Welcome.class);
                startActivity(intent);
            }
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
>>>>>>> main
=======
//import java.text.SimpleDateFormat;
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
        setContentView(R.layout.win_screen);
        Button leaderboardBtn = (Button) findViewById(R.id.see_leaderboard);
        leaderboardBtn.setOnClickListener(view -> {
            setContentView(R.layout.end_screen);
            Long dateTime = System.currentTimeMillis();
            Timestamp ts = new Timestamp(dateTime);
            List<String> temp = leaderboard.addWinner(ConfigScreen.getPlayerName(),
                    GameScreen.getScore(), ts);

            TextView lb = (TextView) findViewById(R.id.leaderboardText);
            String leaderString = "";
            List<List<String>> tempLeaders = leaderboard.getSortedWinners();
            for (int i = 0; i < tempLeaders.size(); i++) {
//                if (i % 2 == 0) {
                    List<String> c = tempLeaders.get(i);
                    leaderString = leaderString + "\n" + c;
//                }
            }
            lb.setText("Score: " + temp.get(1) + "\n" + leaderString);
            TextView end = (TextView) findViewById(R.id.end);
            TextView leaderBoard = (TextView) findViewById(R.id.leaderBoard);
            Button restart = (Button) findViewById(R.id.restart);

            restart.setOnClickListener(view2 -> {
                Intent intent = new Intent(EndScreen.this, Welcome.class);
                startActivity(intent);
            });
        });

    }
}
