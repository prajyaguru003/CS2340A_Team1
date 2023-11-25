package com.example.gamescreen.ViewModel.Powerup;
import com.example.gamescreen.ViewModel.Player;

public class DamageBoost extends PowerupDecorator {
    protected Player player;
    public DamageBoost(Player player) {
        super(player);
    }

    @Override
    public void boost() {
        player.setDamageMultiplier(player.getDamageMultiplier() * 2);
    }
}