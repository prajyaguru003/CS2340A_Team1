package com.example.gamescreen.ViewModel.Enemy;

public class EnemyWeapon {
    private int damage;
    private boolean inUse;
    public EnemyWeapon(int damage, boolean inUse) {
        this.damage = damage;
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
