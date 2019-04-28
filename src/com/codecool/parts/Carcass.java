package com.codecool.parts;

import com.codecool.enums.IsFramed;

public class Carcass extends Part {
    private int depth;
    private int horizontalSection = 1;
    private int verticalSection = 1;
    private IsFramed framing;
    
    public Carcass(int height, int width, int depth, IsFramed framing) {
        super(height, width);
        this.depth = depth;
        this.verticalSection = verticalSection;
        this.horizontalSection = horizontalSection;
        this.framing = framing;
    }
    
    public int getDepth() {
        return depth;
    }
    
    public int getHorizontalSection() {
        return horizontalSection;
    }
    
    public void setHorizontalSection(int horizontalSection) {
        this.horizontalSection = horizontalSection;
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
