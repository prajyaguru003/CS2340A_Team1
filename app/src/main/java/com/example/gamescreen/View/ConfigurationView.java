package com.example.gamescreen.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
//import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cs2340_game.R;

import com.example.gamescreen.ViewModel.ConfigurationLogic;
import com.example.gamescreen.ViewModel.TileConfigurationLogic;

public class ConfigurationView extends AppCompatActivity {
    private ConfigurationLogic config;
    private TileConfigurationLogic tileConfig;
    private static final String TAG = "ConfigView";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        config = new ConfigurationLogic();
        tileConfig = new TileConfigurationLogic();
        setName();
    }
    private void setName() {
        setContentView(R.layout.setname);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Button btnContinue = (Button) findViewById(R.id.btnContinueName);
        EditText name = (EditText) findViewById(R.id.nameInput);
        btnContinue.setOnClickListener(view -> {
            String pName = name.getText().toString();
            if (!config.setValidName(pName)) {
                Toast toast = Toast.makeText(ConfigurationView.this,
                        "Enter a valid name!", Toast.LENGTH_LONG);
                toast.show();
            } else {
                setDifficulty();
            }
        });
    }
    private void setDifficulty() {
        setContentView(R.layout.setdifficulty);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Button easy = (Button) findViewById(R.id.btnEasy);
        Button medium = (Button) findViewById(R.id.btnMedium);
        Button hard = (Button) findViewById(R.id.btnHard);
        difficultyClicked(easy, "Easy");
        difficultyClicked(medium, "Medium");
        difficultyClicked(hard, "Hard");
    }
    private void difficultyClicked(Button button, String diff) {
        button.setOnClickListener(view -> {
            if (config.setValidDifficulty(diff)) {
                setSprite();
            }
        });
    }
    private void setSprite() {
        setContentView(R.layout.choosesprite);
        ImageButton sprite1 = (ImageButton) findViewById(R.id.btnSprite1);
        ImageButton sprite2 = (ImageButton) findViewById(R.id.btnSprite2);
        ImageButton sprite3 = (ImageButton) findViewById(R.id.btnSprite3);
        spriteClicked(sprite1);
        spriteClicked(sprite2);
        spriteClicked(sprite3);
    }
    private void spriteClicked(ImageButton button) {
        button.setOnClickListener(view -> {
            Drawable sprite = button.getDrawable();
            config.setSprite(sprite);
            showSelected(sprite);
        });
    }
    private void showSelected(Drawable sprite) {
        setContentView(R.layout.showselected);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        TextView name = (TextView) findViewById(R.id.nameSelect);
        ImageView setSprite = (ImageView) findViewById(R.id.spriteSelect);
        String setName = "Name: " + config.getName();
        name.setText(setName);
        setSprite.setImageDrawable(sprite);
        Button acknowledge = (Button) findViewById(R.id.btnAcknowledge);
        acknowledge.setOnClickListener(view -> {
            Intent intent = new Intent(ConfigurationView.this, GameView.class);
            startActivity(intent);
        });
    }
}