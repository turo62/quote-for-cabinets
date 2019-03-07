package com.codecool.api.components;

import com.codecool.api.enums.AreaToUse;
import com.codecool.api.enums.Stuff;

public abstract class Screw extends Hardware {
    private int length;
    private int diameter;
    
    public Screw(String name, String producer, int value, AreaToUse qualified, Stuff madeBy, int length, int diameter) {
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
