package com.codecool.enums;

public enum Sizes {
    C(2200, 600, 400, 3, 2),
    W(1200, 415, 600, 3, 2);
    
    private final int height;
    private final int depth;
    private final int sectionWidth;
    private final int sectionsL;
    private final int sectionsS;
    
    Sizes(int height, int depth, int sectionWidth, int sectionsL, int sectionsS) {
        this.height = height;
        this.depth = depth;
        this.sectionWidth = sectionWidth;
        this.sectionsL = sectionsL;
        this.sectionsS = sectionsS;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getDepth() {
        return depth;
    }
    
    public int getSectionWidth() {
        return sectionWidth;
    }
    
    public int getSectionsL() {
        return sectionsL;
    }
    
    public int getSectionsS() {
        return sectionsS;
    }
}
