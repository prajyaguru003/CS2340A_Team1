package com.example.gamescreen.ViewModel.Powerup;
import com.example.gamescreen.ViewModel.Player;

public class HPBoost extends PowerupDecorator {
    protected Player player;
    public HPBoost(Player player) {
        super(player);
        // set HP boost x1.5
    }

    public void boost() {
        player.setHPMultiplier(player.getHPMultiplier() * 2);
    }
}
