package com.codecool.parts;

public abstract class Part {
    private int height;
    private int width;
    
    public Part(int height, int width) {
        this.height = height;
        this.width = width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getWidth() {
        return width;
    }
}

