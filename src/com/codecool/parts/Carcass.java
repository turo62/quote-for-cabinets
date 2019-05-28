package com.codecool.parts;

import com.codecool.components.BoughtComponent;
import com.codecool.enums.IsFramed;

import java.util.List;

public class Carcass extends Part {
    private int depth;
    private IsFramed framing;
    private List<BoughtComponent> assembly;
    
    public Carcass(String name, int height, int width, int depth, IsFramed framing, List<BoughtComponent> assembly) {
        super(name, height, width, assembly);
        this.depth = depth;
        this.framing = framing;
    }
    
    public void setFraming(IsFramed framing) {
        this.framing = framing;
    }
    
    public int getDepth() {
        return depth;
    }
    
    public IsFramed getFraming() {
        return framing;
    }
}