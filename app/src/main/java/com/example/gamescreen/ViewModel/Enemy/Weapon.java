package com.example.gamescreen.ViewModel.Enemy;

public abstract class Weapon {
    private int damage;
    private int durability;
    private boolean inUse;

    public int getDamage() {
        return damage;
    }

    public int getDurability() {
        return durability;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }
}
