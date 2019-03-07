package com.codecool.components;

import com.codecool.enums.Application;

public abstract class Wood extends Components {
    private int length;
    private int width;
    private  int thickness;
    
    public Wood(String name, String producer, int value, Application qualified) {
        super(name, producer, value, qualified);
        this.length = length;
        this.width = width;
        this.thickness = thickness;
    }
    
    public int getLength() {
        return length;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getThickness() {
        return thickness;
    }
}
