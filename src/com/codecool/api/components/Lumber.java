package com.codecool.api.components;

import com.codecool.api.enums.AreaToUse;
import com.codecool.api.enums.Load;

public class Lumber extends Wood {
    private String species;
    
    Lumber(String name, String producer, Load load, int value, AreaToUse qualified, int length, int width, int thickness) {
        super(name, producer, load, value, qualified, length, width, thickness);
        this.species = species;
    }
    
    public String getSpecies() {
        return species;
    }
    
    public void setSpecies(String species) {
        this.species = species;
    }
}
