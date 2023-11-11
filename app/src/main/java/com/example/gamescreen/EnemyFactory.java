package com.example.gamescreen;
public abstract class EnemyFactory {

    public abstract Enemy createEnemy1(int hp, int movementSpeed);
    public abstract Enemy createEnemy2(int hp, int movementSpeed);
    public abstract Enemy createEnemy3(int hp, int movementSpeed);
    public abstract Enemy createEnemy4(int hp, int movementSpeed);
    //method names to be decided later based on real enemy names!
}
