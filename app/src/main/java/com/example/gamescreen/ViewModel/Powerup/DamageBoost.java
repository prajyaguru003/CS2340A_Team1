package com.example.gamescreen.ViewModel.Powerup;
import com.example.gamescreen.ViewModel.Player;

public class DamageBoost extends PowerupDecorator {
    protected Player player;
    public DamageBoost(Player player) {
        super(player);
        // set damage boost x1.5
    }
}