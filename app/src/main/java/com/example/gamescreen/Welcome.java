package com.example.gamescreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.Button;
import android.util.Log;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;

public class Welcome extends AppCompatActivity {
    private static final String TAG = "Welcome";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);
        TextView welcome = (TextView) findViewById(R.id.Welcome);
        Log.d(TAG, "onCreate: Started");
        Button start = (Button) findViewById(R.id.btnStart);
        Button exit = (Button) findViewById(R.id.btnExit);
        startClicked(start);
        exitClicked(exit);
    }
    private void startClicked(Button start) {
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Clicked Start!");
                Intent intent = new Intent(Welcome.this, ConfigScreen.class);
                startActivity(intent);
            }
        });
    }
    private void exitClicked(Button exit) {
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Clicked Start!");
                //finish();
                System.exit(0);
            }
        });
    }
}

