package com.codecool.enums;

public enum CabinetType {
    W("wardrobe"),
    C("commode");
    public String use;
    
    CabinetType(String use) {
        this.use = use;
    }
    
    public String getUse() {
        return use;
    }
}
