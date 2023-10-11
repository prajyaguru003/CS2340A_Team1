package com.example.gamescreen;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;

public class EndScreen extends AppCompatActivity {

    private static String end = "The End";

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
        });

    }
}
