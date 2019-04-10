package com.codecool.components;

import com.codecool.enums.AreaToUse;
import com.codecool.enums.Head;
import com.codecool.enums.Stuff;

public class PocketHoleScrew extends Screw {
    private Head head;
    
    public PocketHoleScrew(String name, String producer, double value, AreaToUse qualified, Stuff madeBy, int length, int diameter) {
        super(name, producer, value, qualified, madeBy, length, diameter);
        this.head = Head.WASHERHEAD;
    }
    
    public Head getHead() {
        return head;
    }
    
    @Override
    public String details() {
        return "Name: " + this.getName() + "\n" +
                "Producer: " + this.getProducer() + "\n" +
                "Price ($ per 100pcs): " + this.getValue() + "\n" +
                "Level of utilization: " + this.getQualified() + "\n" +
                "Made by: " + this.getMadeBy() + "\n" + " / Head type: " + this.getHead() + "\n" +
                "Sizes: " + this.getLength() + "mm (length) " + this.getDiameter() + "mm (diameter)" + "\n";
    }
}
