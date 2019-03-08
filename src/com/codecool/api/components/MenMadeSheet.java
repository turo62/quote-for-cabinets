package com.codecool.api.components;

import com.codecool.api.enums.AreaToUse;
import com.codecool.api.enums.Load;

public class MenMadeSheet extends Wood {
    
    MenMadeSheet(String name, String producer, Load load, int value, AreaToUse qualified, int length, int width, int thickness) {
        super(name, producer, load, value, qualified, length, width, thickness);
    }
}
