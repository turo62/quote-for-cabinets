package com.codecool.components;

import com.codecool.enums.AreaToUse;
import com.codecool.enums.Load;

public class Lumber extends Wood {
    private String species;
    
    public Lumber(String name, String producer, Load load, double value, AreaToUse qualified, int length, int width, int thickness, String species) {
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
