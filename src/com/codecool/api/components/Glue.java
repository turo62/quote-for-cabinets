package com.codecool.api.components;

public class Glue {
    
    private String name;
    private int settingTime;
    private String strength;
    
    /**
     * PVA 170-250,
     * bone glue 200-300
     */
    
    private int appliedVolume;
    private boolean waterResistance;
    
    public Glue(String name, String strength, int appliedVolume, boolean waterResistance) {
        this.name = name;
        this.strength = strength;
        this.appliedVolume = appliedVolume;
        this.waterResistance = waterResistance;
        this.settingTime = settingTime;
    }
    
    public int getSettingTime() {
        return settingTime;
    }
    
    public void setSettingTime(int time) {
        this.settingTime = time;
    }
}
