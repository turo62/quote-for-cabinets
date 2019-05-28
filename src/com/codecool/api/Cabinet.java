package com.codecool.api;

import com.codecool.parts.Part;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cabinet implements Serializable {
    private String name;
    private double price;
    private double cost;
    private List<Part> parts = new ArrayList<>();
    
    public Cabinet(String name, double price, double cost, List<Part> parts) {
        this.name = name;
        this.price = price;
        this.cost = cost;
        this.parts = parts;
    }
    
    public List<Part> getParts() {
        return parts;
    }
    
    public void setParts(List<Part> parts) {
        this.parts = parts;
    }
    
    public List<Part> addPart(Part part) {
        parts.add(part);
        
        return parts;
    }
    
    //getcarcass
    //isFramed
    //getDrawers
    //getDoors
    
    
}
