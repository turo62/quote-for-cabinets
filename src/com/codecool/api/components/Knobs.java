package com.codecool.api.components;

import com.codecool.api.enums.AreaToUse;
import com.codecool.api.enums.Finish;
import com.codecool.api.enums.Stuff;
import com.codecool.api.enums.Style;

public class Knobs extends KnobsAndPulls {
    
    private int diameter;
    private int height;
    
    Knobs(String name, String producer, double value, AreaToUse qualified, Stuff madeBy, Style style, Finish color, int diameter, int height) {
        super(name, producer, value, qualified, madeBy, style, color);
        this.diameter = diameter;
        this.height = height;
    }
    
    public int getDiameter() {
        return diameter;
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
                "Sizes: " + this.getDiameter() + "mm (diameter / ) " + this.getHeight() + "mm (height)" + "\n";
    }
}
