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
        Intent testCoordinateGrid = new Intent(MainActivity.this, CoordinateGrid.class);
        startActivity(testCoordinateGrid);
    }
}
