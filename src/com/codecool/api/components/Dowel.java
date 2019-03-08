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
}
