package com.example.gamescreen;

<<<<<<< HEAD
<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
=======
import android.content.Intent;
import android.content.pm.ActivityInfo;
>>>>>>> main
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class EndScreen extends AppCompatActivity {

    private static String end = "The End";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_screen);
<<<<<<< HEAD
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
=======
        TextView end = (TextView) findViewById(R.id.end);
        TextView leaderBoard = (TextView) findViewById(R.id.leaderBoard);
        Button restart = (Button) findViewById(R.id.restart);

        restart.setOnClickListener(view -> {
            Intent intent = new Intent(EndScreen.this, Welcome.class);
            startActivity(intent);
>>>>>>> main
        });
    }
}
