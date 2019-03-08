package com.codecool.api.components;

import com.codecool.api.enums.AreaToUse;
import com.codecool.api.enums.Load;

public class BlockBoard extends MenMadeSheet {
    
    public BlockBoard(String name, String producer, Load LOW, int value, AreaToUse HOMEH, int length, int width, int thickness) {
        super(name, producer, LOW, value, HOMEH, length, width, thickness);
    }
}
