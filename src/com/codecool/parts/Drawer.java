package com.codecool.parts;

import com.codecool.components.BoughtComponent;
import com.codecool.components.KnobsAndPulls;
import com.codecool.enums.IsInset;

import java.util.ArrayList;
import java.util.List;

public class Drawer extends Part {
    private int depth;
    private KnobsAndPulls handle;
    private IsInset seating;
    private boolean slide;
    private List<BoughtComponent> assembly = new ArrayList<>();
    
    public Drawer(String name, int height, int length, int depth, List<BoughtComponent> assembly) {
        super(name, height, length, assembly);
        this.depth = depth;
        this.handle = handle;
        this.seating = seating;
        this.slide = slide;
        this.assembly = assembly;
    }
}
