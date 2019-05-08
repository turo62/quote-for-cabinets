package com.codecool.components;

import java.io.Serializable;

public class BoughtComponent implements Serializable {
    private String name;
    private double number;
    private Components component;
    
    public BoughtComponent(String name, double number, Components component) {
        this.name = name;
        this.number = number;
        this.component = component;
    }
    
    public double getNumber() {
        return number;
    }
    
    public void setNumber(double value) {
        this.number = value;
    }
    
    public void manageStock(double value) {
        this.number -= value;
    }
    
    public String getName() {
        return name;
    }
    
    public Components getComponent() {
        return component;
    }
}
