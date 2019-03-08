package com.codecool.api.components;

import com.codecool.api.enums.AreaToUse;
import com.codecool.api.enums.Load;

public class MDF extends MenMadeSheet {
    
    MDF(String name, String producer, Load LOW, int value, AreaToUse TRAFICM, int length, int width, int thickness) {
        super(name, producer, LOW, value, TRAFICM, length, width, thickness);
    }
}