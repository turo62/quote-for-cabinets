package com.codecool.parts;

import com.codecool.enums.IsFramed;

public class Carcass extends Part {
    private int depth;
    private int verticalSection = 1;
    private IsFramed framing;
    private boolean morticed;
    
    public Carcass(int height, int width, int depth, int verticalSection, IsFramed framing, boolean morticed) {
        super(height, width);
        this.depth = depth;
        this.verticalSection = verticalSection;
        this.framing = framing;
        this.morticed = morticed;
    }
    
    public int getDepth() {
        return depth;
    }
    
    public int getVerticalSection() {
        return verticalSection;
    }
    
    public void setVerticalSection(int verticalSection) {
        this.verticalSection = verticalSection;
    }
    
    public IsFramed getFraming() {
        return framing;
    }
}
