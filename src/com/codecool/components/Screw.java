package com.codecool.components;

import com.codecool.enums.AreaToUse;
import com.codecool.enums.Stuff;

public abstract class Screw extends Hardware {
    private int length;
    private int diameter;
    
    public Screw(String name, String producer, double value, AreaToUse qualified, Stuff madeBy, int length, int diameter) {
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
}
