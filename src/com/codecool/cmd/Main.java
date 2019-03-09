package com.codecool.cmd;

import com.codecool.api.enums.AngleToOpen;

public class Main {
    
    public static void main(String[] args) {
        AngleToOpen angle = AngleToOpen.valueOf("high".toUpperCase());
        System.out.println("Maximum opening angle of a door is " + angle.getAngle() + " degree.");
    }
}
