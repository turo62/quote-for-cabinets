package com.codecool.components;

import com.codecool.enums.AreaToUse;
import com.codecool.enums.Load;

public class PlyWood extends MenMadeSheet {
    public PlyWood(String name, String producer, Load MEDIUM, double value, AreaToUse TRAFICM, int length, int width, int thickness) {
        super(name, producer, MEDIUM, value, TRAFICM, length, width, thickness);
    }
    
    @Override
    public String details() {
        return "Name: " + this.getName() + "\n" +
                "Producer: " + this.getProducer() + "\n" +
                "Load capacity: " + this.getLoad() + "\n" +
                "Price ($): " + this.getValue() + "\n" +
                "Level of utilization: " + this.getQualified() + "\n" +
                "Sizes: " + this.getLength() + "mm (length) " + this.getWidth() + "mm (width) " + this.getThickness() + "mm (thickness)" + "\n";
    }
}
