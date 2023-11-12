package Model;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConfigurationData {
    private String name = "invalid";
    private String difficulty = "invalid";
    private int spriteID = -1;
    private int hp = -1;
    private Set<String> difficulties;
    private Set<Integer> spriteIDs;
    private Drawable sprite;
    public ConfigurationData() {
        List<String> difficulties = Arrays.asList("Easy", "Medium", "Hard");
        this.difficulties = new HashSet<>();
        this.difficulties.addAll(difficulties);
        List<Integer> spriteIDs = Arrays.asList(1, 2, 3);
        this.spriteIDs = new HashSet<>();
        this.spriteIDs.addAll(spriteIDs);
    }

    public String getName() {
        return name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public int getSpriteID() {
        return spriteID;
    }

    public Set<String> getDifficulties() {
        return difficulties;
    }

    public Set<Integer> getSpriteIDs() {
        return spriteIDs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
        if(difficulty.equals("Easy")){
            this.hp = 100;
        }
        if(difficulty.equals("Medium")){
            this.hp = 75;
        }
        if(difficulty.equals("Hard")){
            this.hp = 50;
        }
    }

    public int getHp() {
        return hp;
    }

//    public void setHp(int hp) {
//        this.hp = hp;
//    }

    public void setSpriteID(int spriteID) {
        this.spriteID = spriteID;
    }

    public void setDifficulties(Set<String> difficulties) {
        this.difficulties = difficulties;
    }

    public void setSpriteIDs(Set<Integer> spriteIDs) {
        this.spriteIDs = spriteIDs;
    }

    public Drawable getSprite() {
        return sprite;
    }

    public void setSprite(Drawable sprite) {
        this.sprite = sprite;
    }
}
