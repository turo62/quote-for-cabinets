package com.codecool.parts;

import com.codecool.components.BoughtComponent;

import java.util.List;

public class Door extends Part {
    private boolean morticed;
    private List<BoughtComponent> assembly;
    
    public Door(String name, int height, int width, boolean morticed, List<BoughtComponent> assembly) {
        super(name, height, width, assembly);
        this.morticed = morticed;
    }
    
    public boolean isMorticed() {
        return morticed;
    }
    
    public boolean setMorticed() {
        return true;
    }
}
