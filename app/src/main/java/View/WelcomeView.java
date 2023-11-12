package View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.cs2340_game.R;

import android.content.pm.ActivityInfo;
import android.widget.Button;
import android.util.Log;

import ViewModel.MainActivity;

public class WelcomeView extends AppCompatActivity {
    private static final String TAG = "WelcomeView";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.welcome_screen);
        Button start = (Button) findViewById(R.id.btnStart);
        Button exit = (Button) findViewById(R.id.btnExit);
        startClicked(start);
        exitClicked(exit);
    }
    private void startClicked(Button start) {
        start.setOnClickListener(view -> {
            Log.d(TAG, "onClick: Clicked Start!");
            Intent intent = new Intent(WelcomeView.this, ConfigurationView.class);
            startActivity(intent);

        });
    }

    private void exitClicked(Button exit) {
        exit.setOnClickListener(view -> {
            Log.d(TAG, "onClick: Clicked Exit!");
            //finish();
            System.exit(0);
        });
    }
}