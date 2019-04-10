package com.codecool.components;

import com.codecool.enums.AreaToUse;
import com.codecool.enums.Finish;
import com.codecool.enums.Stuff;
import com.codecool.enums.Style;

public abstract class KnobsAndPulls extends Hardware {
    
    private Style style;
    private Finish color;
    
    KnobsAndPulls(String name, String producer, double value, AreaToUse qualified, Stuff madeBy, Style style, Finish color) {
        super(name, producer, value, qualified, madeBy);
        this.style = style;
        this.color = color;
    }
    
    public Style getStyle() {
        return style;
    }
    
    public Finish getColor() {
        return color;
    }
}
