package com.codecool.components;

import com.codecool.enums.AreaToUse;
import com.codecool.enums.Stuff;

public class Dowel extends Hardware {
    private int length;
    private int diameter;
    
    public Dowel(String name, String producer, double value, AreaToUse qualified, Stuff madeBy, int length, int diameter) {
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
                "Price ($ per 100 pcs): " + this.getValue() + "\n" +
                "Level of utilization: " + this.getQualified() + "\n" +
                "Species of wood made by: " + this.getMadeBy() + "\n" +
                "Sizes: " + this.getLength() + "mm (length) " + this.getDiameter() + "mm (diameter)" + "\n";
    }
}
