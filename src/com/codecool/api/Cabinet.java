package com.codecool.api;

import com.codecool.parts.Part;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cabinet implements Serializable {
    private String name;
    private int price;
    private int cost;
    private List<Part> parts = new ArrayList<>();
    
    public Cabinet(String name) {
        this.name = name;
        this.price = price;
        this.cost = cost;
        this.parts = parts;
    }
    
    //getcarcass
    //isFramed
    //getDrawers (carving?)
    //getDoors (carving?)
    //getFeet
    //vertical section(s)
    //horizontal sections
    
}
