package com.codecool.components;

import com.codecool.enums.AreaToUse;
import com.codecool.enums.Stuff;

public class Slides extends Hardware {
    private int length;
    private int width;
    private int depth;
    
    public Slides(String name, String producer, double value, AreaToUse qualified, Stuff S, int length, int width, int depth) {
        super(name, producer, value, qualified, S);
        this.length = length;
        this.width = width;
        this.depth = depth;
    }
    
    public int getLength() {
        return length;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getDepth() {
        return depth;
    }
    
    @Override
    public String details() {
        return "Name: " + this.getName() + "\n" +
                "Producer: " + this.getProducer() + "\n" +
                "Price ($): " + this.getValue() + "\n" +
                "Level of utilization: " + this.getQualified() + "Made by: " + this.getMadeBy() + "\n" +
                "Sizes: " + this.getLength() + "mm (length / ) " + this.getWidth() + "mm (width)" + this.getDepth() + "mm (depth)" + "\n";
    }
}
