package com.codecool.api.components;

import com.codecool.api.enums.*;

public class Hinge extends Hardware {
    
    private AngleToOpen angle;
    private IsRecess mount;
    private Style style;
    private Finish color;
    private int length;
    private int width;
    private int thickness;
    
    Hinge(String name, String producer, double value, AreaToUse qualified, Stuff madeBy, Style style, Finish color, AngleToOpen angle, IsRecess mount, int length, int width, int thickness) {
        super(name, producer, value, qualified, madeBy);
        this.style = style;
        this.color = color;
        this.angle = angle;
        this.mount = mount;
        this.length = length;
        this.width = width;
        this.thickness = thickness;
    }
    
    public Style getStyle() {
        return style;
    }
    
    public Finish getColor() {
        return color;
    }
    
    public AngleToOpen getAngle() {
        return angle;
    }
    
    public IsRecess getMount() {
        return mount;
    }
    
    public void setMount(IsRecess mount) {
        this.mount = mount;
    }
    
    public int getLength() {
        return length;
    }
    
    public void setLength(int length) {
        this.length = length;
    }
    
    public int getWidth() {
        return width;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public int getThickness() {
        return thickness;
    }
    
    public void setThickness(int thickness) {
        this.thickness = thickness;
    }
    
    @Override
    public String details() {
        return "Name: " + this.getName() + "\n" +
                "Producer: " + this.getProducer() + "\n" +
                "Price ($): " + this.getValue() + "\n" +
                "Level of utilization: " + this.getQualified() + "\n" +
                "Made by: " + this.getMadeBy() + "\n" +
                "Style: " + this.getStyle() + "/finish: " + this.getColor() + " / max. open angle " + this.getAngle() + " / way of mounting " + this.getMount() + "\n" +
                "Sizes: " + this.getLength() + "mm (length / ) " + this.getWidth() + "mm (width)" + this.getThickness() + "mm (thickness)" + "\n";
    }
}
