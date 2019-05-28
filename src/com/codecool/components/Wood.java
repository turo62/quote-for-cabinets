package com.codecool.components;

import com.codecool.enums.AreaToUse;
import com.codecool.enums.Load;

public abstract class Wood extends Components {
    private int length;
    private int width;
    private int thickness;
    protected Load load;
    
    Wood(String name, String producer, Load load, double value, AreaToUse qualified, int length, int width, int thickness) {
        super(name, producer, value, qualified);
        this.load = load;
        this.length = length;
        this.width = width;
        this.thickness = thickness;
    }
    
    public void setThickness(int value) {
        this.thickness -= value;
    }
    
    public int setWidth(int value) {
        this.width -= value;
        return width;
    }
    
    public int newWidth(int value) {
        this.width = value;
        return width;
    }
    
    public int setLength(int value) {
        this.length -= value;
        return length;
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
    
    @Override
    public String details() {
        return "Name: " + this.getName() + "\n" +
                "Producer: " + this.getProducer() + "\n" +
                "Load capacity: " + this.getLoad() + "\n" +
                "Price ($): " + this.getValue() + "\n" +
                "Sizes: " + this.getLength() + "mm (length) " + this.getWidth() + "mm (width) " + this.getThickness() + "mm (thickness)" + "\n";
    }
}
