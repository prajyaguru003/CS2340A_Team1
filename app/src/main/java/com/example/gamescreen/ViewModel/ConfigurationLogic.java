package com.example.gamescreen.ViewModel;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.example.gamescreen.Model.ConfigurationData;

public class ConfigurationLogic {
    ConfigurationData data;
    private static List<ConfigurationLogic> configs;
    private static int configIndex;
    private static final String TAG = "ConfigLogic";
    private int pixelX;
    private int pixelY;
    public ConfigurationLogic() {
        data = new ConfigurationData();
        if(configs == null){
            configs = new ArrayList<>();
            configIndex = -1;
        }
        configs.add(this);
        configIndex++;
    }
    public boolean setValidName(String name){
        if(checkNameValid(name)){
            data.setName(name);
            return true;
        }
        return false;
    }
    public boolean setValidDifficulty(String difficulty){
        if(data.getDifficulties().contains(difficulty)){
            data.setDifficulty(difficulty);
            return true;
        }
        return false;
    }
    public boolean setValidSprite(int spriteID){
        if(data.getSpriteIDs().contains(spriteID)){
            data.setSpriteID(spriteID);
            return true;
        }
        return false;
    }
    private static boolean checkNameValid(Object pname){
        if (pname != null && ((String)pname).length() > 0) {
            String name = (String) pname;
            for (int i = 0; i < name.length(); i++) { //checks to see if name is whitespaces
                if (!(name.charAt(i) == ' ')) {
                    return true;
                }
            }
        }
        return false;
    }
    public String getName(){
        return data.getName();
    }

    public String getDifficulty() {
        return data.getDifficulty();
    }

    public int getSpriteID() {
        return data.getSpriteID();
    }

    public Set<String> getDifficulties() {
        return data.getDifficulties();
    }

    public Set<Integer> getSpriteIDs() {
        return data.getSpriteIDs();
    }
    public static ConfigurationLogic getConfig(){
        return configs.get(configIndex);
    }
    public int getHp(){
        return data.getHp();
    }
    public Drawable getSprite(){
        return data.getSprite();
    }
    public void setSprite(Drawable sprite){
        data.setSprite(sprite);
    }

    public void setPixelX(int pixelX) {
        this.pixelX = pixelX;
    }

    public void setPixelY(int pixelY) {
        this.pixelY = pixelY;
    }

    public int getPixelX() {
        return pixelX;
    }

    public int getPixelY() {
        return pixelY;
    }
    public void setHp(int hp){
        data.setHp(hp);
    }
    public int getDamage(){
        return data.getDamage();
    }
}
