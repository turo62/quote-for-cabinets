package com.codecool.api.enums;

public enum Stuff {
    W("wood"),
    S("steel"),
    B("brass");
    
    private final String madeBy;
    
    Stuff(String madeBy) {
        this.madeBy = madeBy;
    }
    
    public String getMadeBy() {
        return madeBy;
    }
}
