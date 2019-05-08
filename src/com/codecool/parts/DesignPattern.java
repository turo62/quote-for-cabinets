package com.codecool.parts;

import com.codecool.enums.CabinetType;
import com.codecool.enums.IsFramed;
import com.codecool.enums.IsInset;

public class DesignPattern {
    private CabinetType myType;
    private String material;
    private IsFramed framed;
    private int verticalSections;
    private String shelves;
    private String handle;
    private String hinge;
    private IsInset seating;
    private int numberOfDrawers;
    private boolean slide;
    
    public DesignPattern(CabinetType myType, String material, IsFramed framed, int verticalSections, String shelves, String handle, String hinge, IsInset seating, int numberOfDrawers, boolean slide) {
        this.myType = myType;
        this.material = material;
        this.framed = framed;
        this.verticalSections = verticalSections;
        this.shelves = shelves;
        this.handle = handle;
        this.hinge = hinge;
        this.seating = seating;
        this.numberOfDrawers = numberOfDrawers;
        this.slide = slide;
    }
    
    public CabinetType getMyType() {
        return myType;
    }
    
    public void setMyType(CabinetType myType) {
        this.myType = myType;
    }
    
    public String getMaterial() {
        return material;
    }
    
    public void setMaterial(String material) {
        this.material = material;
    }
    
    public IsFramed getFramed() {
        return framed;
    }
    
    public void setFramed(IsFramed framed) {
        this.framed = framed;
    }
    
    public int getVerticalSections() {
        return verticalSections;
    }
    
    public void setVerticalSections(int verticalSections) {
        this.verticalSections = verticalSections;
    }
    
    public String getShelves() {
        return shelves;
    }
    
    public void setShelves(String shelves) {
        this.shelves = shelves;
    }
    
    public String getHandle() {
        return handle;
    }
    
    public void setHandle(String handle) {
        this.handle = handle;
    }
    
    public String getHinge() {
        return hinge;
    }
    
    public void setHinge(String hinge) {
        this.hinge = hinge;
    }
    
    public IsInset getSeating() {
        return seating;
    }
    
    public void setSeating(IsInset seating) {
        this.seating = seating;
    }
    
    public int getNumberOfDrawers() {
        return numberOfDrawers;
    }
    
    public void setNumberOfDrawers(int numberOfDrawers) {
        this.numberOfDrawers = numberOfDrawers;
    }
    
    public boolean isSlide() {
        return slide;
    }
    
    public void setSlide(boolean slide) {
        this.slide = slide;
    }
}
