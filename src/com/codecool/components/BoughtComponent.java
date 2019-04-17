package com.codecool.components;

public class BoughtComponent {
    private String name;
    private int number;
    private Components component;
    
    public BoughtComponent(String name, int number, Components component) {
        this.name = name;
        this.number = number;
        this.component = component;
    }
    
    public int getNumber() {
        return number;
    }
    
    public void setNumber(int value) {
        this.number += value;
    }
    
    public String getName() {
        return name;
    }
    
    public Components getComponent() {
        return component;
    }
}
