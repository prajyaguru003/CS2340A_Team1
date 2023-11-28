package com.example.gamescreen.ViewModel;
//import android.util.Log;

import com.example.gamescreen.View.GameView;
import com.example.gamescreen.ViewModel.Enemy.EnemyMovementLogic;

//import java.util.Timer;
import java.util.TimerTask;
public class GameTimer extends TimerTask {
    private static final String TAG = "TimerTask";
    private long startTime;
    private long elapsedTime;
    private EnemyMovementLogic enemyMovement;
    private GameView gameView;
    public GameTimer(GameView gameview, EnemyMovementLogic enemyMovement) {
        this.startTime = System.currentTimeMillis();
        this.enemyMovement = enemyMovement;
        this.gameView = gameview;
    }
    @Override
    public void run() {
        gameView.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                elapsedTime = System.currentTimeMillis() - startTime;
                updateGame(elapsedTime);
            }
        });
    }
    private void updateGame(long elapsedTime){
        if(elapsedTime % 200 == 0){
            int enemyEl = enemyMovement.moveEnemies();
            gameView.updateEnemies(enemyEl);
        } if(elapsedTime % 200 == 0){
            gameView.updateHealth();
            gameView.updateItems();
            gameView.updateScore();
        }
//        Log.d(TAG, "TIMER HAS BEEN STARTED");
    }
}
