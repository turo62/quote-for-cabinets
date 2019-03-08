package com.codecool.api.components;

import com.codecool.api.enums.*;

public class Hinge extends Hardware {
    
    private AngleToOpen angle;
    private IsRecess mount;
    private Style style;
    private Finish color;
    
    Hinge(String name, String producer, int value, AreaToUse qualified, Stuff madeBy, Style style, Finish color, AngleToOpen angle, IsRecess mount) {
        super(name, producer, value, qualified, madeBy);
    }
}
