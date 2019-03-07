package com.codecool.api.components;

import com.codecool.api.enums.AreaToUse;
import com.codecool.api.enums.Head;
import com.codecool.api.enums.Stuff;

public class PocketHoleScrew extends Screw {
    private Head head;
    
    PocketHoleScrew(String name, String producer, int value, AreaToUse qualified, Stuff madeBy, int length, int diameter) {
        super(name, producer, value, qualified, madeBy, length, diameter);
        this.head = head;
    }
    
    public Head getHead() {
        return head;
    }
}
