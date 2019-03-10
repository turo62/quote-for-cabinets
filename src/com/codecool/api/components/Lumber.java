package com.codecool.api.components;

import com.codecool.api.enums.AreaToUse;
import com.codecool.api.enums.Load;

public class Lumber extends Wood {
    private String species;
    
    Lumber(String name, String producer, Load load, double value, AreaToUse qualified, int length, int width, int thickness) {
        super(name, producer, load, value, qualified, length, width, thickness);
        this.species = species;
    }
    
    public String getSpecies() {
        return species;
    }
    
    public void setSpecies(String species) {
        this.species = species;
    }
    
    @Override
    public String details() {
        return "Name: " + this.getName() + "\n" +
                "Producer: " + this.getProducer() + "\n" +
                "Species of wood: " + this.getSpecies() + "\n" +
                "Load capacity: " + this.getLoad() + "\n" +
                "Price ($): " + this.getValue() + "\n" +
                "Level of utilization: " + this.getQualified() + "\n" +
                "Sizes: " + this.getLength() + "mm (length) " + this.getWidth() + "mm (width) " + this.getThickness() + "mm (thickness)" + "\n";
    }
}
