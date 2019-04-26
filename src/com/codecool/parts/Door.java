package com.codecool.parts;

import com.codecool.components.Hinge;
import com.codecool.components.KnobsAndPulls;
import com.codecool.enums.IsInset;

public class Door {
    private int height;
    private int width;
    private String madeOf;
    private KnobsAndPulls handle;
    private Hinge hinge;
    private IsInset seating;
    
    public Door(int height, int width) {
        this.height = height;
        this.width = width;
        this.madeOf = madeOf;
        this.handle = handle;
        this.hinge = hinge;
        this.seating = seating;
    }
}
