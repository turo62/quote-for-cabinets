package com.codecool.api;

import com.codecool.parts.Part;

import java.util.ArrayList;
import java.util.List;

public class Cabinet {
    private String name;
    private int price;
    private int cost;
    private int verticalSection = 1;
    private int height;
    private int width;
    private int depth;
    private List<Part> parts = new ArrayList<>();
    
    public Cabinet(String name) {
        this.name = name;
        this.price = price;
        this.cost = cost;
        this.parts = parts;
        this.verticalSection = verticalSection;
        this.height = height;
        this.width = width;
        this.depth = depth;
    }
    //getcarcass
    //isFramed
    //getDrawers (carving?)
    //getDoors (carving?)
    //getFeet
    //vertical section(s)
    //horizontal sections
    
}
