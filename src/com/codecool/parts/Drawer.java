package com.codecool.parts;

import com.codecool.components.KnobsAndPulls;
import com.codecool.enums.IsInset;

public class Drawer {
    private int depth;
    private int length;
    private KnobsAndPulls handle;
    private String madeOf;
    private IsInset seating;
    
    public Drawer(int depth, int length, KnobsAndPulls handle) {
        this.depth = depth;
        this.length = length;
        this.handle = handle;
        this.madeOf = madeOf;
        this.seating = seating;
    }
}
