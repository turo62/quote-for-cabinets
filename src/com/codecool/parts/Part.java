package com.codecool.parts;

import com.codecool.components.BoughtComponent;

import java.io.Serializable;
import java.util.List;

public abstract class Part implements Serializable {
    private String name;
    private int height;
    private int width;
    private List<BoughtComponent> assembly;
    
    Part(String name, int height, int width) {
        this.name = name;
        this.height = height;
        this.width = width;
        this.assembly = assembly;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getWidth() {
        return width;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void assemble(BoughtComponent partComponent) {
        boolean isIncluded = false;
        for (BoughtComponent component : assembly) {
            if (component.getName().equals(partComponent.getName())) {
                component.manageStock(-1);
                isIncluded = true;
            }
        }
        if (!isIncluded) {
            assembly.add(partComponent);
        }
    }
}

