package com.example.gamescreen.ViewModel;

import com.example.gamescreen.Model.TileConfigurationData;
import java.util.ArrayList;
import java.util.List;

public class TileConfigurationLogic {
    TileConfigurationData data;
    private static List<TileConfigurationLogic> configs;
    private static int configIndex;

    public TileConfigurationLogic(){
        data = new TileConfigurationData();
        if(configs == null){
            configs = new ArrayList<>();
            configIndex = -1;
        }
        configs.add(this);
        configIndex++;
    }
    public static TileConfigurationLogic getConfig(){
        return configs.get(configIndex);
    }
    public int getTileNum(){
        return data.getTileNum();
    }

}
