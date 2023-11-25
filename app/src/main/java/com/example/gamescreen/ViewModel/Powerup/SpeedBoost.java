package com.example.gamescreen.ViewModel.Powerup;
import com.example.gamescreen.ViewModel.Player;

public class SpeedBoost extends PowerupDecorator {
    protected Player player;
    public SpeedBoost(Player player) {
        super(player);
        // set speed boost x2
    }
    @Override
    public void boost() {
        player.setSpeed(player.getSpeed() * 2);
    }
}