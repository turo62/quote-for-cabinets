package com.codecool.api.components;

import com.codecool.api.enums.AreaToUse;
import com.codecool.api.enums.Load;

public class PlyWood extends MenMadeSheet {
    PlyWood(String name, String producer, Load MEDIUM, double value, AreaToUse TRAFICM, int length, int width, int thickness) {
        super(name, producer, MEDIUM, value, TRAFICM, length, width, thickness);
    }
    
    /**
     * size is 1525×1525 mm and 2500×1250 mm
     */
    
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
