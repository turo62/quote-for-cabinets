package com.codecool.enums;

import java.util.Arrays;

public enum AngleToOpen {
    HIGH(270),
    MEDIUM(180),
    LOW(120);
    
    private final int angle;
    
    AngleToOpen(int angle) {
        this.angle = angle;
    }
    
    public int getAngle() {
        return angle;
    }
    
    public static AngleToOpen valueOfInt(int i) {
        return Arrays.stream(AngleToOpen.values())
                .filter(e -> e.getAngle() == i)
                .findFirst()
                .orElse(null);
    }
}
