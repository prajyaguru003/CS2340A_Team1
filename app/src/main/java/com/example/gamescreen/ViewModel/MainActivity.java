package com.example.gamescreen.ViewModel;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

//import com.example.gamescreen.View.ConfigurationView;
//import com.example.gamescreen.View.WelcomeView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(MainActivity.this,
                com.example.gamescreen.View.WelcomeView.class);
        startActivity(intent);
    }
}