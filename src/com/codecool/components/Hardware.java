package com.codecool.components;

import com.codecool.enums.AreaToUse;
import com.codecool.enums.Stuff;

public abstract class Hardware extends Components {
    private Stuff madeBy;
    
    public Hardware(String name, String producer, double value, AreaToUse qualified, Stuff madeBy) {
        super(name, producer, value, qualified);
        this.madeBy = madeBy;
    }
    
    public Stuff getMadeBy() {
        return madeBy;
    }
}
