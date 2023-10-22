package com.example.gamescreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

public class ConfigScreen extends AppCompatActivity {
    private static int hp;
    private static int hpEasy = 100;
    private static int hpMedium = 75;
    private static int hpHard = 50;
    private static String difficulty;
    private static Drawable sprite;
    private static String playerName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setName();
    }

    private void setName() {
        setContentView(R.layout.setname);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        TextView name = (TextView) findViewById(R.id.nameInput);
        Button btnContinue = (Button) findViewById(R.id.btnContinueName);
        btnContinue.setOnClickListener(view -> {
            if (name != null && name.length() > 0) { //also add for name to not be whitespaces
                boolean foundLetter = false;
                for (int i = 0; i < name.length(); i++) {
                    if (name.getText().toString().charAt(i) != ' ') {
                        foundLetter = true;
                    }
                }
                if (!foundLetter) {
                    Toast toast = Toast.makeText(ConfigScreen.this,
                            "Enter a valid name!", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    playerName = name.getText().toString();
                    difficulty();
                }
            } else {
                Toast toast = Toast.makeText(ConfigScreen.this,
                        "Enter a valid name!", Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

    private void difficulty() {
        setContentView(R.layout.setdifficulty);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Button easy = (Button) findViewById(R.id.btnEasy);
        Button medium = (Button) findViewById(R.id.btnMedium);
        Button hard = (Button) findViewById(R.id.btnHard);
        difficultyClicked(easy, hpEasy, "Easy");
        difficultyClicked(medium, hpMedium, "Medium");
        difficultyClicked(hard, hpHard, "Hard");
    }

    private void difficultyClicked(Button button, int hp, String diff) {
        difficulty = diff;
        button.setOnClickListener(view -> {
            setHp(hp);
            sprite();
        });
    }

    public static void setDifficulty(String diff, int num) {
        if (diff.equals("Easy")) {
            hpEasy = num;
            difficulty = Integer.toString(hpEasy);
        } else if (diff.equals("Medium")) {
            hpMedium = num;
            difficulty = Integer.toString(hpMedium);
        } else if (diff.equals("Hard")) {
            hpHard = num;
            difficulty = Integer.toString(hpHard);
        }
    }

    public static void setHp(int x) {
        if (x < 0) {
            hp = 0;
        } else {
            hp = x;
        }
    }

    public static String getDifficulty() {
        return difficulty;
    }

    public static Drawable getSprite() {
        return sprite;
    }

    public static String getPlayerName() {
        return playerName;
    }

    public static int gethp() {
        return hp;
    }

    private void sprite() {
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
            sprite = button.getDrawable();
            showSelected();
        });
    }

    private void showSelected() {
        setContentView(R.layout.showselected);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        TextView name = (TextView) findViewById(R.id.nameSelect);
        ImageView setSprite = (ImageView) findViewById(R.id.spriteSelect);
        String setName = "Name: " + playerName;
        name.setText(setName);
        setSprite.setImageDrawable(sprite);
        Button acknowledge = (Button) findViewById(R.id.btnAcknowledge);
        acknowledge.setOnClickListener(view -> {
            Intent intent = new Intent(ConfigScreen.this, GameScreen.class);
            startActivity(intent);
        });
    }
}
