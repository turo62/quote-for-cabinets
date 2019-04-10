package com.codecool.components;

import com.codecool.enums.AreaToUse;
import com.codecool.enums.Load;

public abstract class MenMadeSheet extends Wood {
    
    public MenMadeSheet(String name, String producer, Load load, double value, AreaToUse qualified, int length, int width, int thickness) {
        super(name, producer, load, value, qualified, length, width, thickness);
    }
}
