package com.example.gamescreen.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cs2340_game.R;
import com.example.gamescreen.ViewModel.LeaderboardLogic;
import com.example.gamescreen.ViewModel.MainActivity;

public class LeaderboardView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leaderboard);
        TextView lb = (TextView) findViewById(R.id.leaderboard);
        LeaderboardLogic instance = LeaderboardLogic.getInstance();
        Intent intent = getIntent();
        int value = intent.getIntExtra("key", -10);
        String name = intent.getStringExtra("name");
        String health = intent.getStringExtra("health");

        if(value == 1){
            instance.addWinner(name, health);
            lb.setText(instance.getSortedWinners().toString());
        }
        Button restart = (Button) findViewById(R.id.restart);
        lb.setOnClickListener(view -> {
            Intent lbIntent = new Intent(LeaderboardView.this, com.example.gamescreen.ViewModel.MainActivity.class);
            startActivity(lbIntent);
        });
    }
}
