package com.example.gamescreen.ViewModel.Weapons;

import com.example.gamescreen.ViewModel.GameLogic;
import com.example.gamescreen.ViewModel.Grid;

public class BlobLogic {
    private Blob boulder1;
    private static Grid grid;
    GameLogic gameLogic;
    private static final String TAG = "EnemyMovement";
    public BlobLogic(GameLogic gameLogic) {
        boulder1 = new Blob(5);
        this.grid = gameLogic.getGrid();
        this.gameLogic = gameLogic;
    }
    public void placeBlob(int x, int y){
        grid.setCoordinate(x, y, 8);
    }
}
