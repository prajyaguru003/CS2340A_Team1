package com.example.gamescreen.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.cs2340_game.R;

public class EndingView extends AppCompatActivity {
    private static final String TAG = "EndingView";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_screen);

        Intent intent = getIntent();
        Log.d(TAG, "HELLLOOOOOOOOO");
        int value = intent.getIntExtra("key", -10);
        Log.d(TAG, "VALUE: " + value);
        TextView status = (TextView) findViewById(R.id.status);
        if(value == 1){
            status.setText("YOU WON!!! CONGRATS :)");
        } else{
            status.setText("You lost :(");
        }
        Button lb = (Button) findViewById(R.id.leaderboardBtn);
        lb.setOnClickListener(view -> {
            Intent lbIntent = new Intent(EndingView.this, LeaderboardView.class);
            lbIntent.putExtra("key", 1);
            lbIntent.putExtra("health", intent.getStringExtra("health"));
            lbIntent.putExtra("name", intent.getStringExtra("name"));
            startActivity(lbIntent);
        });
    }
}