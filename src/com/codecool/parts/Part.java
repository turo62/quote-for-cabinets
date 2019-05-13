package com.codecool.parts;

import com.codecool.components.BoughtComponent;
import com.codecool.components.Components;

import java.util.List;

public abstract class Part {
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
    
    public void addComponent(String name, int number, Components component) {
        BoughtComponent builtPart = new BoughtComponent(name, number, component);
        assembly.add(builtPart);
    }
}

