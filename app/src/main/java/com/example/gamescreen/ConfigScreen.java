package com.example.gamescreen;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.drawable.Drawable;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;

public class ConfigScreen extends AppCompatActivity{
    public static int hp;
    private static final int hpEasy = 100;
    private static final int hpMedium = 75;
    private static final int hpHard = 50;
    public static String difficulty;
    public static Drawable sprite;
    public static TextView playerName;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setName();
    }
    private void setName(){
        setContentView(R.layout.setname);
        TextView name = (TextView) findViewById(R.id.nameInput);
        Button btnContinue = (Button) findViewById(R.id.btnContinueName);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name != null && name.length() > 0){ //also add for name to not be whitespaces
                    playerName = name;
                    difficulty();
                } else{
                    Intent intent = new Intent(ConfigScreen.this, ConfigScreen.class);
                    startActivity(intent);
                }
            }
        });
    }
    private void difficulty(){
        setContentView(R.layout.setdifficulty);
        Button easy = (Button) findViewById(R.id.btnEasy);
        Button medium = (Button) findViewById(R.id.btnMedium);
        Button hard = (Button) findViewById(R.id.btnHard);
        difficultyClicked(easy, hpEasy, "Easy");
        difficultyClicked(medium, hpMedium, "Medium");
        difficultyClicked(hard, hpHard, "Hard");
    }
    private void difficultyClicked(Button button, int hp, String diff){
        difficulty = diff;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_hp(hp);
                sprite();
            }
        });
    }
    private static void set_hp(int x){
        hp = x;
    }
    private void sprite(){
        setContentView(R.layout.choosesprite);
        ImageButton sprite1 = (ImageButton) findViewById(R.id.btnSprite1);
        ImageButton sprite2 = (ImageButton) findViewById(R.id.btnSprite2);
        ImageButton sprite3 = (ImageButton) findViewById(R.id.btnSprite3);
        spriteClicked(sprite1, 1);
        spriteClicked(sprite2, 2);
        spriteClicked(sprite3, 3);
    }
    private void spriteClicked(ImageButton button, int spriteNum) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sprite = button.getDrawable();
                showSelected();
            }
        });
    }
    private void showSelected(){
        setContentView(R.layout.showselected);
        TextView name = (TextView) findViewById(R.id.nameSelect);
        ImageView setSprite = (ImageView) findViewById(R.id.spriteSelect);
        name.setText("Name: " + playerName.getText());
        setSprite.setImageDrawable(sprite);
        Button acknowledge = (Button) findViewById(R.id.btnAcknowledge);
        acknowledge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfigScreen.this, GameScreen.class);
                startActivity(intent);
            }
        });
    }
}
