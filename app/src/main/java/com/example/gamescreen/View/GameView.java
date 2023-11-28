package com.example.gamescreen.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cs2340_game.R;

import com.example.gamescreen.ViewModel.ConfigurationLogic;
import com.example.gamescreen.ViewModel.Enemy.Enemy;
import com.example.gamescreen.ViewModel.Enemy.EnemyMovementLogic;
import com.example.gamescreen.ViewModel.GameLogic;
import com.example.gamescreen.ViewModel.GameTimer;
import com.example.gamescreen.ViewModel.Items.GenerateItems;
import com.example.gamescreen.ViewModel.Items.Item;
import com.example.gamescreen.ViewModel.Items.Potion;
import com.example.gamescreen.ViewModel.Items.SlowEnemies;
import com.example.gamescreen.ViewModel.Items.SpeedBoost;
import com.example.gamescreen.ViewModel.TileConfigurationLogic;
import com.example.gamescreen.ViewModel.Weapons.BlobLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;

public class GameView extends AppCompatActivity {
    ConfigurationLogic playerConfig;
    TileConfigurationLogic tileConfig;
    GameLogic gameLogic;
    ImageView player;
    Timer gameTimer;
    EnemyMovementLogic enemyMovement;
    List<ImageView> enemies;
    BlobLogic blobLogic;
    GenerateItems items;
    List<ImageView> itemImages;
    List<Integer> itemIndex;
    int tile;
    private static final String TAG = "GameView";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        playerConfig = ConfigurationLogic.getConfig();
        Intent intent = getIntent();
        int value = intent.getIntExtra("layout", 1);
        if(value == 1){
            tile = 1;
            setContentView(R.layout.tile1);
        } else if(value == 2){
            tile = 2;
            setContentView(R.layout.tile2);
        } else if(value == 3){
            tile = 3;
            setContentView(R.layout.tile3);
        } else{
            win();
        }
//        Log.d(TAG, "PLAYERCONFIG: " + playerConfig.toString());
        tileConfig = TileConfigurationLogic.getConfig();
        DisplayMetrics display = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(display);
        int screenWidth = display.heightPixels;
        int screenLength = display.widthPixels;
        gameLogic = new GameLogic(screenLength, screenWidth, playerConfig);
        blobLogic = new BlobLogic(gameLogic);
        items = new GenerateItems(gameLogic);
        itemImages = new ArrayList<>();
        itemIndex = items.getItems();
        gameLogic.setItems(itemIndex);
        enemyMovement = new EnemyMovementLogic(gameLogic);
        enemies = new ArrayList<>();
        enemies.add(new ImageView(this));
        enemies.add(new ImageView(this));
        enemies.add(new ImageView(this));
        enemies.add(new ImageView(this));
        player = new ImageView(this);
        player.setImageDrawable(playerConfig.getSprite());
        List<Integer> pixelCoordinates = gameLogic.getPlayerPixels();
        ConstraintLayout.LayoutParams playerParams = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
        );
        playerParams.width = gameLogic.getPixelWidth();
        playerParams.height = gameLogic.getPixelHeight();
        player.setLayoutParams(playerParams);
        ConstraintLayout layout = findViewById(R.id.parent_gamescreen);
        layout.addView(player);
        player.setX(pixelCoordinates.get(0));
        player.setY(pixelCoordinates.get(1));
        showSelected();
        generateWalls();
        setStar();
        setItems();
        updateEnemies(0);
        gameOn();
    }
    private void generateWalls(){
        int[][] grid = gameLogic.getGridCopy();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 5){
//                    Log.d(TAG, "THERE IS A 5 HERE");
                    ImageView wall = new ImageView(this);
                    wall.setImageResource(R.drawable.stonewall);
                    ConstraintLayout.LayoutParams wallParams = new ConstraintLayout.LayoutParams(
                            ConstraintLayout.LayoutParams.WRAP_CONTENT,
                            ConstraintLayout.LayoutParams.WRAP_CONTENT
                    );
                    wallParams.width = gameLogic.getPixelWidth();
                    wallParams.height = gameLogic.getPixelHeight();
                    wall.setLayoutParams(wallParams);
                    ConstraintLayout layout = findViewById(R.id.parent_gamescreen);
                    layout.addView(wall);
                    wall.setX(i * gameLogic.getPixelWidth());
                    wall.setY(j * gameLogic.getPixelHeight());
                }
            }
        }
    }
    private void gameOn(){
        startTimer();
        Button up = (Button) findViewById(R.id.btnup);
        Button down = (Button) findViewById(R.id.btndown);
        Button left = (Button) findViewById(R.id.btnleft);
        Button right = (Button) findViewById(R.id.btnright);
        buttonClicked(up, "up");
        buttonClicked(down, "down");
        buttonClicked(left, "left");
        buttonClicked(right, "right");
        placeBlob();
    }
    private void buttonClicked(Button button, String btnID){
//        Log.d(TAG, "POSSSSIIITIOOONN" + " " + player.getX() + " " + player.getY());
        button.setOnClickListener(view -> {
            List<Integer> playerPos = new ArrayList<>();
            if(btnID == "up"){
                playerPos = gameLogic.moveUp();
            }
            if(btnID == "down"){
                playerPos = gameLogic.moveDown();
            }
            if(btnID == "left"){
                playerPos = gameLogic.moveLeft();
            }
            if(btnID == "right"){
                playerPos = gameLogic.moveRight();
            }
            playerConfig.setPixelX(playerPos.get(0));
            playerConfig.setPixelY(playerPos.get(1));
            player.setX(playerConfig.getPixelX());
            player.setY(playerConfig.getPixelY());
//            Log.d(TAG, "POSSSSIIITIOOONN" + " " + player.getX() + " " + player.getY());
//            Log.d(TAG, "POSSSSIIITIOOONN" + " " + gameLogic.getPlayerCoordinates().toString());
            List<Integer> playerCoordinates = gameLogic.getPlayerCoordinates();
            if(gameLogic.checkGoal(playerCoordinates.get(0), playerCoordinates.get(1))) {
//                Log.d(TAG, "FOUND THE STAR!!!!!!");
                Intent intent = new Intent(GameView.this, GameView.class);
                Intent oldIntent = getIntent();
                intent.putExtra("layout", oldIntent.getIntExtra("layout", 1) + 1);
                startActivity(intent);
            }
        });

    }

    private void placeBlob(){
        Button button = (Button) findViewById(R.id.blobPlacer);
        button.setOnClickListener(view -> {
            List<Integer> coords = gameLogic.getPlayerCoordinates();
            int x = coords.get(0);
            int y = coords.get(1);
            blobLogic.placeBlob(x, y);
            ImageView blob = new ImageView(this);
            blob.setImageResource(R.drawable.blob);
            ConstraintLayout.LayoutParams wallParams = new ConstraintLayout.LayoutParams(
                    ConstraintLayout.LayoutParams.WRAP_CONTENT,
                    ConstraintLayout.LayoutParams.WRAP_CONTENT
            );
            wallParams.width = gameLogic.getPixelWidth();
            wallParams.height = gameLogic.getPixelHeight();
            blob.setLayoutParams(wallParams);
            ConstraintLayout layout = findViewById(R.id.parent_gamescreen);
            layout.addView(blob);
            int[] goldStarCoordinates = gameLogic.getGoldStar();
            blob.setX(gameLogic.getPixelWidth() * x);
            blob.setY(gameLogic.getPixelHeight()* y);
        });
    }

    private void showSelected() {
        TextView name = (TextView) findViewById(R.id.name);
        name.setTextColor(Color.WHITE);
        TextView hp = (TextView) findViewById(R.id.health);
        hp.setTextColor(Color.WHITE);
        TextView diff = (TextView) findViewById(R.id.difficulty);
        diff.setTextColor(Color.WHITE);
        TextView tileNum = (TextView) findViewById(R.id.tileNum);
        tileNum.setTextColor(Color.WHITE);
        String n = "Name: " + playerConfig.getName();
        String health = "HP: " + playerConfig.getHp();
        String diffic = "Difficulty: " + playerConfig.getDifficulty();
        Intent intent = getIntent();
        String setTile = "Tile: " + intent.getIntExtra("layout", 1);
        name.setText(n);
        hp.setText(health);
        diff.setText(diffic);
        tileNum.setText(setTile);
//        Log.d(TAG, "SPRITE: " + playerConfig.getSprite());
    }
    public void setItems(){
        for(int i = 0; i<itemIndex.size(); i++){
            ImageView item = new ImageView(this);
            item.setImageResource(R.drawable.lightning_bolt);
            if(i%3 == 0){
                item.setImageResource(R.drawable.potion);
            } else if(i%3 == 1){
                item.setImageResource(R.drawable.lightning_bolt);
            } else if (i%3 == 2){
                item.setImageResource(R.drawable.clock);
            }
            ConstraintLayout.LayoutParams wallParams = new ConstraintLayout.LayoutParams(
                    ConstraintLayout.LayoutParams.WRAP_CONTENT,
                    ConstraintLayout.LayoutParams.WRAP_CONTENT
            );
            wallParams.width = gameLogic.getPixelWidth();
            wallParams.height = gameLogic.getPixelHeight();
            item.setLayoutParams(wallParams);
            if (item.getParent() != null) {
                ((ViewGroup) item.getParent()).removeView(item);
            }
            ConstraintLayout layout = findViewById(R.id.parent_gamescreen);
            itemImages.add(item);
            Item itemObject = items.getRealItems().get(i);
            item.setX(gameLogic.getPixelWidth() * itemObject.getX());
            item.setY(gameLogic.getPixelHeight() * itemObject.getY());
            layout.addView(item);
        }
    }

    public void updateItems(){
//        Log.d(TAG, "ITEMS ARRAY: " + itemIndex.toString());
//        Log.d(TAG, "ITEMINDEXSIZE: " + itemIndex.size());
        for(int i = 0; i<itemIndex.size(); i++){
            if(itemIndex.get(i) == 0){
//                Log.d(TAG, "UPDATE ITEMS");
                ImageView imageViewToRemove = itemImages.get(i);
                ConstraintLayout layout = findViewById(R.id.parent_gamescreen);
                layout.removeView(imageViewToRemove);
                layout.requestLayout();
            }
        }
    }
    private void setStar(){
        ImageView star = new ImageView(this);
        star.setImageResource(R.drawable.goldstar);
        ConstraintLayout.LayoutParams wallParams = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
        );
        wallParams.width = gameLogic.getPixelWidth();
        wallParams.height = gameLogic.getPixelHeight();
        star.setLayoutParams(wallParams);
        ConstraintLayout layout = findViewById(R.id.parent_gamescreen);
        layout.addView(star);
        int[] goldStarCoordinates = gameLogic.getGoldStar();
        star.setX(gameLogic.getPixelWidth() * goldStarCoordinates[0]);
        star.setY(gameLogic.getPixelHeight()* goldStarCoordinates[1]);
    }
    private void startTimer(){
        gameTimer = new Timer();
        GameTimer gameTimerTask = new GameTimer(this, enemyMovement);
        gameTimer.scheduleAtFixedRate(gameTimerTask, 0, 400);
    }
    public void updateEnemies(int el){
        List<Enemy> enemyObjects = enemyMovement.getEnemies();
        for(int i = 0; i<enemyObjects.size(); i++){
            ImageView enemy = enemies.get(i);
            enemy.setImageResource(R.drawable.ninja);
            ConstraintLayout.LayoutParams wallParams = new ConstraintLayout.LayoutParams(
                    ConstraintLayout.LayoutParams.WRAP_CONTENT,
                    ConstraintLayout.LayoutParams.WRAP_CONTENT
            );
            wallParams.width = gameLogic.getPixelWidth();
            wallParams.height = gameLogic.getPixelHeight();
            enemy.setLayoutParams(wallParams);
            if (enemy.getParent() != null) {
                ((ViewGroup) enemy.getParent()).removeView(enemy);
            }
            ConstraintLayout layout = findViewById(R.id.parent_gamescreen);
            if(el-1 != i){
                enemies.get(i).setX(enemyObjects.get(i).x * gameLogic.getPixelWidth());
                enemies.get(i).setY(enemyObjects.get(i).y * gameLogic.getPixelHeight());
                layout.addView(enemy);
            } else{
                ImageView imageViewToRemove = enemy;
                layout = findViewById(R.id.parent_gamescreen);
                layout.removeView(imageViewToRemove);
                layout.requestLayout();
            }
        }
        if(el != 0){
            enemyObjects.remove(el-1);
        }
    }
    public void updateHealth(){
        TextView name = (TextView) findViewById(R.id.health);
//        Log.d(TAG, "HP: " + playerConfig.getHp());
//        Log.d(TAG, "HP: " + playerConfig.getHp());
        if(playerConfig.getHp() <= 0){
            if (gameTimer != null) {
                gameTimer.cancel();
            }
            lose();
        }
        String health = "HP: " + playerConfig.getHp();
        name.setText(health);
    }
    public void lose(){
        if (gameTimer != null) {
            gameTimer.cancel();
        }

//        Log.d(TAG, "YOU LOST!!!!");
        Intent intent = new Intent(GameView.this, EndingView.class);
        intent.putExtra("key", -1);
        startActivity(intent);
    }
    public void win(){
        if (gameTimer != null) {
            gameTimer.cancel();
        }

        String health = "" + playerConfig.getHp();
        String name = "" + playerConfig.getName();
        Intent intent = new Intent(GameView.this, EndingView.class);
        intent.putExtra("key", 1);
        intent.putExtra("health", health);
        intent.putExtra("name", name);
        startActivity(intent);
    }
    public void updateScore(){
        TextView score = (TextView) findViewById(R.id.score);
//        Log.d(TAG, "HP: " + playerConfig.getHp());
//        Log.d(TAG, "HP: " + playerConfig.getHp());
        Random random = new Random();
        int y = 1 + random.nextInt(5);
        int temp = playerConfig.getHp() * y;
        String scoreText = "Score: " + temp;
        score.setText(scoreText);
    }

}