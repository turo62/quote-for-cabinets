package com.codecool.api.enums;

public enum AreaToUse {
    TRAFICH(6),
    TRAFICM(5),
    HOMEH(4),
    HOMEL(3);
    
    private final int qualified;
    
    AreaToUse(int qualified) {
        this.qualified = qualified;
    }
    
    public int getQualified() {
        return qualified;
    }
}
