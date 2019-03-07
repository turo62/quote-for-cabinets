package com.codecool.api.enums;

public enum AngleToOpen {
    HIGH(270),
    MEDIUM(180),
    LOW(95);
    
    private final int angle;
    
    AngleToOpen(int angle) {
        this.angle = angle;
    }
    
    public int getAngle() {
        return angle;
    }
}
