package com.codecool.api.components;

import com.codecool.api.enums.AngleToOpen;
import com.codecool.api.enums.AreaToUse;
import com.codecool.api.enums.IsRecess;
import com.codecool.api.enums.Stuff;

public class Hinge extends Hardware {
    
    private AngleToOpen angle;
    private IsRecess mount;
    
    Hinge(String name, String producer, int value, AreaToUse qualified, Stuff madeBy) {
        super(name, producer, value, qualified, madeBy);
        this.angle = angle;
        this.mount = mount;
    }
    
    public AngleToOpen getAngle() {
        return angle;
    }
    
    public IsRecess getMount() {
        return mount;
    }
}
