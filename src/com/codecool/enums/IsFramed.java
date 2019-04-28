package com.codecool.enums;

public enum IsFramed {
    FL("frameless"),
    FF("face framed");
    private String frame;
    
    IsFramed(String frame) {
        this.frame = frame;
    }
    
    public String getFrame() {
        return frame;
    }
}
