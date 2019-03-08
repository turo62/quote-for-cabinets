package com.codecool.api.components;

import com.codecool.api.enums.AreaToUse;
import com.codecool.api.enums.Load;

public class PlyWood extends MenMadeSheet {
    PlyWood(String name, String producer, Load MEDIUM, int value, AreaToUse TRAFICM, int length, int width, int thickness) {
        super(name, producer, MEDIUM, value, TRAFICM, length, width, thickness);
    }
}
