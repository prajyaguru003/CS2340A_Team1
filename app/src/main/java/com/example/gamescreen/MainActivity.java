package com.example.gamescreen;
/*
package com.example.gamescreen

public class EndScreen {
}*/


import android.content.Intent;
import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Intent intent = new Intent(MainActivity.this, Welcome.class);
//        startActivity(intent);
        Intent test_coordinate_grid = new Intent(MainActivity.this, Coordinate_grid.class);
        startActivity(test_coordinate_grid);
    }
}
