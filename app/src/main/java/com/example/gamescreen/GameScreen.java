package com.example.gamescreen;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.drawable.Drawable;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.os.Bundle;


public class GameScreen extends AppCompatActivity {

    private static Drawable character;
    private static int[] position;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);
        ProgressBar health = (ProgressBar) findViewById(R.id.health_bar);
        Button interact = (Button) findViewById(R.id.interact);
        Button movement = (Button) findViewById(R.id.movement);
        ImageView player = (ImageView) findViewById(R.id.character);
        player.setImageDrawable(ConfigScreen.sprite);
        this.position = new int[2];
    }

    private void lost() {

    }
}
