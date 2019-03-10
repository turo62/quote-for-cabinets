package com.codecool.api.components;

import com.codecool.api.enums.AreaToUse;
import com.codecool.api.enums.Finish;
import com.codecool.api.enums.Stuff;
import com.codecool.api.enums.Style;

public class Pulls extends KnobsAndPulls {
    private int length;
    private int height;
    
    Pulls(String name, String producer, double value, AreaToUse qualified, Stuff madeBy, Style style, Finish color, int length, int height) {
        super(name, producer, value, qualified, madeBy, style, color);
        this.length = length;
        this.height = height;
    }
    
    public int getLength() {
        return length;
    }
    
    public int getHeight() {
        return height;
    }
    
    
    @Override
    public String details() {
        return "Name: " + this.getName() + "\n" +
                "Producer: " + this.getProducer() + "\n" +
                "Price ($): " + this.getValue() + "\n" +
                "Level of utilization: " + this.getQualified() + "\n" +
                "Made by: " + this.getMadeBy() + "\n" +
                "Style: " + this.getStyle() + "/finish: " + this.getColor() + "\n" +
                "Sizes: " + this.getLength() + "mm (length / ) " + this.getHeight() + "mm (height)" + "\n";
    }
}
