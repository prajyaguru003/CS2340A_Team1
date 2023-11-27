package com.example.gamescreen.ViewModel.Enemy;

public class Gun extends Weapon {
    private int damage;
    private int durability;
    private boolean inUse;
    private int critCount;
    private int critical;
    private Bullet[] ammo;
    public Gun(int damage, int durability, boolean inUse, int critical) {
        this.damage = damage;
        this.durability = durability;
        this.inUse = inUse;
        this.critical = critical;
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
}
