package com.example.gamescreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.widget.Button;
import android.util.Log;
import android.os.Bundle;

public class Welcome extends AppCompatActivity {
    private static final String TAG = "Welcome";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.welcome_screen);
        Button start = (Button) findViewById(R.id.btnStart);
        Button exit = (Button) findViewById(R.id.btnExit);
        startClicked(start);
        exitClicked(exit);
    }

    private void startClicked(Button start) {
        start.setOnClickListener(view -> {
            Log.d(TAG, "onClick: Clicked Start!");
            Intent intent = new Intent(Welcome.this, ConfigScreen.class);
            startActivity(intent);
        });
    }

    private void exitClicked(Button exit) {
        exit.setOnClickListener(view -> {
            Log.d(TAG, "onClick: Clicked Start!");
            //finish();
            System.exit(0);
        });
    }
}

