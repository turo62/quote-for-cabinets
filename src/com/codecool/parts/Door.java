package com.codecool.parts;

import com.codecool.components.BoughtComponent;
import com.codecool.components.Hinge;
import com.codecool.components.KnobsAndPulls;
import com.codecool.enums.IsInset;

import java.util.List;

public class Door extends Part {
    private KnobsAndPulls handle;
    private Hinge hinge;
    private IsInset seating;
    private boolean morticed;
    private List<BoughtComponent> assembly;
    
    public Door(String name, int height, int width) {
        super(name, height, width);
        this.handle = handle;
        this.hinge = hinge;
        this.seating = seating;
        this.morticed = morticed;
        this.assembly = assembly;
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
    
    public boolean isMorticed() {
        return morticed;
    }
    
    public void setMorticed(boolean morticed) {
        this.morticed = morticed;
    }
}
