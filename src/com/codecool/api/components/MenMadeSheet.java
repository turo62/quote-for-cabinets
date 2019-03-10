package com.codecool.api.components;

import com.codecool.api.enums.AreaToUse;
import com.codecool.api.enums.Load;

public abstract class MenMadeSheet extends Wood {
    
    MenMadeSheet(String name, String producer, Load load, double value, AreaToUse qualified, int length, int width, int thickness) {
        super(name, producer, load, value, qualified, length, width, thickness);
    }
}
