package com.example.gamescreen.ViewModel.Enemy;

public class Gun extends Weapon {
    private int damage;
    private int durability;
    private boolean inUse;
    private Bullet[] ammo;
    public Gun(int damage, int durability, boolean inUse) {
        this.damage = damage;
        this.durability = durability;
        this.inUse = inUse;
    }

    public int getDamage() {
        return damage;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public int criticalAttack() {
        return damage * 5;
    }
}
