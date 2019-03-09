package com.codecool.api.components;

import com.codecool.api.enums.AreaToUse;
import com.codecool.api.enums.Stuff;

public class Dowel extends Hardware {
    private int length;
    private int diameter;
    
    Dowel(String name, String producer, int value, AreaToUse qualified, Stuff madeBy) {
        super(name, producer, value, qualified, madeBy);
        this.length = length;
        this.diameter = diameter;
    }
    
    public int getLength() {
        return length;
    }
    
    public int getDiameter() {
        return diameter;
    }
    
    @Override
    public String details() {
        return "Name: " + this.getName() + "\n" +
                "Producer: " + this.getProducer() + "\n" +
                "Price ($): " + this.getValue() + "\n" +
                "Level of utilization: " + this.getQualified() + "\n" +
                "Species of wood made by: " + this.getMadeBy() + "\n" +
                "Sizes: " + this.getLength() + "mm (length) " + this.getDiameter() + "mm (diameter)" + "\n";
    }
}
