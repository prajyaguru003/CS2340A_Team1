package com.example.gamescreen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
//import android.widget.ProgressBar;

public class GameScreen extends AppCompatActivity {

    //    private static Drawable character;
    //    private static int[] position;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);
        //ProgressBar health = (ProgressBar) findViewById(R.id.health_bar);
        //Button interact = (Button) findViewById(R.id.interact);
        //Button up = (Button) findViewById(R.id.move_up);
        //Button down = (Button) findViewById(R.id.move_down);
        //Button left = (Button) findViewById(R.id.move_left);
        //Button right = (Button) findViewById(R.id.move_right);
        ImageView player = (ImageView) findViewById(R.id.character);
        player.setImageDrawable(ConfigScreen.getSprite());
        //position = new int[2];
        showSelected();

    }

    private void showSelected() {
        TextView name = (TextView) findViewById(R.id.nameSelect);
        TextView hp = (TextView) findViewById(R.id.healthSelect);
        TextView diff = (TextView) findViewById(R.id.difficultySelect);
        String n = "Name: " + ConfigScreen.getPlayerName();
        String health = "HP: " + ConfigScreen.gethp();
        String diffic = "Difficulty: " + ConfigScreen.getDifficulty();
        name.setText(n);
        hp.setText(health);
        diff.setText(diffic);

        Button acknowledge = (Button) findViewById(R.id.interact);
        acknowledge.setOnClickListener(view -> {
            Intent intent = new Intent(GameScreen.this, EndScreen.class);
            startActivity(intent);
        });
    }
    //    private void movement() {
    //
    //    }
    //
    //    private void lost() {
    //
    //    }
}
