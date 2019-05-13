package com.codecool.parts;

import com.codecool.components.BoughtComponent;
import com.codecool.enums.IsFramed;

import java.util.ArrayList;
import java.util.List;

public class Carcass extends Part {
    private int depth;
    private int verticalSection;
    private IsFramed framing;
    private List<BoughtComponent> assembly = new ArrayList<>();
    
    public Carcass(String name, int height, int width, int depth, int verticalSection, IsFramed framing) {
        super(name, height, width);
        this.depth = depth;
        this.verticalSection = verticalSection;
        this.framing = framing;
        this.assembly = assembly;
    }
    
    public void setDepth(int depth) {
        this.depth = depth;
    }
    
    public void setFraming(IsFramed framing) {
        this.framing = framing;
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
