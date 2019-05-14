package com.codecool.parts;

import com.codecool.components.BoughtComponent;

import java.util.ArrayList;
import java.util.List;

public class Drawer extends Part {
    private int depth;
    private boolean slide;
    private List<BoughtComponent> assembly = new ArrayList<>();
    
    public Drawer(String name, double cost, int height, int length, int depth) {
        super(name, cost, height, length);
        this.depth = depth;
        this.slide = slide;
        this.assembly = assembly;
    }
}
