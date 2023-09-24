package com.example.gamescreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.Button;
import android.util.Log;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;

public class Welcome extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public Welcome(){
        setContentView(R.layout.welcome_screen);
        TextView welcome = (TextView) findViewById(R.id.Welcome);
        Log.d(TAG, "onCreate: Started");
        Button start = (Button) findViewById(R.id.btnStart);
        Button exit = (Button) findViewById(R.id.btnExit);

        start.setOnClickListener(view -> {
            Log.d(TAG, "onClick: Clicked Start!");
            Intent intent = new Intent(Welcome.this, ConfigScreen.class);
            startActivity(intent);
        });
    }
}
