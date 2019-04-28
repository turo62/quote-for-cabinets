package com.codecool.parts;

import com.codecool.components.Hinge;
import com.codecool.components.KnobsAndPulls;
import com.codecool.enums.IsInset;

public class Door extends Part {
    private KnobsAndPulls handle;
    private Hinge hinge;
    private IsInset seating;
    
    public Door(int height, int width, String madeOf) {
        super(height, width);
        this.handle = handle;
        this.hinge = hinge;
        this.seating = seating;
    }
    
    public void setHandle(KnobsAndPulls handle) {
        this.handle = handle;
    }
    
    public void setHinge(Hinge hinge) {
        this.hinge = hinge;
    }
    
    public void setSeating(IsInset seating) {
        this.seating = seating;
    }
}
