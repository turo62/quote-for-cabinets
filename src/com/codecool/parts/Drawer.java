package com.codecool.parts;

import com.codecool.components.KnobsAndPulls;
import com.codecool.enums.IsInset;

public class Drawer extends Part {
    private int depth;
    private int handleNumber;
    private KnobsAndPulls handle;
    private IsInset seating;
    private boolean slide;
    
    public Drawer(int height, int length, int depth, KnobsAndPulls handle) {
        super(height, length);
        this.depth = depth;
        this.handleNumber = handleNumber;
        this.handle = handle;
        this.seating = seating;
        this.slide = slide;
    }
}
