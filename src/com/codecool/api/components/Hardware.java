package com.codecool.api.components;

import com.codecool.api.enums.AreaToUse;
import com.codecool.api.enums.Stuff;

public abstract class Hardware extends Components {
    private Stuff madeBy;
    
    public Hardware(String name, String producer, int value, AreaToUse qualified, Stuff madeBy) {
        super(name, producer, value, qualified);
        this.madeBy = madeBy;
    }
    
    public Stuff getMadeBy() {
        return madeBy;
    }
}
