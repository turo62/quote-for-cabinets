package com.codecool.api.components;

import com.codecool.api.enums.AreaToUse;
import com.codecool.api.enums.Finish;
import com.codecool.api.enums.Stuff;
import com.codecool.api.enums.Style;

public abstract class KnobsAndPulls extends Hardware {
    
    private Style style;
    private Finish color;
    
    KnobsAndPulls(String name, String producer, int value, AreaToUse qualified, Stuff madeBy, Style style, Finish color) {
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
