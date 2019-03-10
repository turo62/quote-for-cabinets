package com.codecool.api.components;

import com.codecool.api.enums.AreaToUse;

public class Glue extends Components {
    
    private int settingTime;
    
    /**
     * PVA 170-250,
     * bone glue 200-300
     */
    
    private int appliedVolume;
    private boolean waterResistance;
    
    public Glue(String name, String producer, double value, AreaToUse qualified, int settingTime, int appliedVolume, boolean waterResistance) {
        super(name, producer, value, qualified);
        this.settingTime = settingTime;
        this.appliedVolume = appliedVolume;
        this.waterResistance = waterResistance;
    }
    
    public int getSettingTime() {
        return settingTime;
    }
    
    public int getAppliedVolume() {
        return appliedVolume;
    }
    
    public boolean isWaterResistance() {
        return waterResistance;
    }
    
    public String waterResistant() {
        if (isWaterResistance()) {
            return "Y";
        } else {
            return "N";
        }
    }
    
    @Override
    public String details() {
        return "Name: " + this.getName() + "\n" +
                "Producer: " + this.getProducer() + "\n" +
                "Price ($): " + this.getValue() + "\n" +
                "Level of utilization: " + this.getQualified() + "\n" +
                "Setting time: " + this.getSettingTime() + "min / volume to apply: " + getAppliedVolume() + "gr/sqm / is water resistant: " + waterResistant() + "\n";
    }
}
