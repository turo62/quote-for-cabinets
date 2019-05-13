package com.codecool.components;

import com.codecool.enums.AreaToUse;

public abstract class Components implements java.io.Serializable {
    private String name;
    private String producer;
    private double value;
    private AreaToUse qualified;
    
    public Components(String name, String producer, double value, AreaToUse qualified) {
        this.name = name;
        this.producer = producer;
        this.value = value;
        this.qualified = qualified;
    }
    
    public double setValue(double amount) {
        this.value -= amount;
        return value;
    }
    
    public String getName() {
        return name;
    }
    
    public String getProducer() {
        return producer;
    }
    
    public double getValue() {
        return value;
    }
    
    public AreaToUse getQualified() {
        return qualified;
    }
    
    public abstract String details();
    
    public String toString() {
        return this.getName() + " " + this.getProducer() + " " + this.getQualified() + " " + "($ " + this.getValue() + ")";
    }
}

