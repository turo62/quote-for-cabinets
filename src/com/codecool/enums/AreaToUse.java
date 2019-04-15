package com.codecool.enums;

import java.util.Arrays;

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
    
    public static AreaToUse valueOfInt(int i) {
        return Arrays.stream(AreaToUse.values())
                .filter(e -> e.getQualified() == i)
                .findFirst()
                .orElse(null);
    }
}
