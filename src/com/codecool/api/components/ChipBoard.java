package com.codecool.api.components;

import com.codecool.api.enums.AreaToUse;
import com.codecool.api.enums.Load;

public class ChipBoard extends MenMadeSheet {
    ChipBoard(String name, String producer, Load LOW, double value, AreaToUse HOMEH, int length, int width, int thickness) {
        super(name, producer, LOW, value, HOMEH, length, width, thickness);
    }
    
    /**
     * size is 2800×2050 mm
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
