package com.codecool.enums;

public enum Application {
    TRAFICH(6),
    TRAFICM(5),
    HOMEH(4),
    HOMEL(3);
    
    private final int qualified;
    
    Application(int qualified) {
        this.qualified = qualified;
    }
    
    public int getQualified() {
        return qualified;
    }
}
