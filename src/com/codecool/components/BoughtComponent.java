package com.codecool.components;

public class BoughtComponent {
    private String name;
    private double number = 15.0;
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
