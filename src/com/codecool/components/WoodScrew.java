package com.codecool.components;

import com.codecool.enums.AreaToUse;
import com.codecool.enums.Head;
import com.codecool.enums.Stuff;

public class WoodScrew extends Screw {
    private Head head;
    private Stuff madeBy;
    
    public WoodScrew(String name, String producer, double value, AreaToUse qualified, Stuff madeBy, int length, int diameter) {
        super(name, producer, value, qualified, madeBy, length, diameter);
        this.head = Head.COUNTERSUNK;
        this.madeBy = madeBy;
    }
    
    public Head getHead() {
        return head;
    }
    
    public String getStuff() {
        return madeBy.getMadeBy();
    }
    
    @Override
    public String details() {
        return "Name: " + this.getName() + "\n" +
                "Producer: " + this.getProducer() + "\n" +
                "Price ($ per 100pcs): " + this.getValue() + "\n" +
                "Level of utilization: " + this.getQualified() + "\n" +
                "Made by: " + this.getStuff() + "\n" + " / Head type: " + this.getHead() + "\n" +
                "Sizes: " + this.getLength() + "mm (length) " + this.getDiameter() + "mm (diameter)" + "\n";
    }
}
