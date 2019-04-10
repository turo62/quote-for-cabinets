package com.codecool.components;

import com.codecool.enums.AreaToUse;
import com.codecool.enums.Load;

public abstract class Wood extends Components {
    private int length;
    private int width;
    private int thickness;
    private Load load;
    
    public Wood(String name, String producer, Load load, double value, AreaToUse qualified, int length, int width, int thickness) {
        super(name, producer, value, qualified);
        this.load = load;
        this.length = length;
        this.width = width;
        this.thickness = thickness;
    }
    
    public Load getLoad() {
        return load;
    }
    
    public void setLoad(Load load) {
        this.load = load;
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
