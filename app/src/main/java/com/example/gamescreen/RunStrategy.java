package com.example.gamescreen;

import android.widget.Button;
import android.widget.ImageView;
import android.util.Log;

public class RunStrategy implements MovementStrategy {
    private static final String TAG = "RunStrategy: ";
    @Override
    public void moveRight(Button button, ImageView player) {
        button.setOnClickListener(view -> {
            Log.d(TAG, "Run Right");
        });
    }

    @Override
    public void moveLeft(Button button, ImageView player) {
        button.setOnClickListener(view -> {
            Log.d(TAG, "Run Right");
        });
    }

    @Override
    public void moveDown(Button button, ImageView player) {
        button.setOnClickListener(view -> {
            Log.d(TAG, "Run Right");
        });
    }

    @Override
    public void moveUp(Button button, ImageView player) {
        button.setOnClickListener(view -> {
            Log.d(TAG, "Run Right");
        });
    }
}
