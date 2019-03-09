package com.codecool.api.components;

import com.codecool.api.enums.AreaToUse;

public abstract class Components implements java.io.Serializable {
    private String name;
    private String producer;
    private int value;
    private AreaToUse qualified;
    
    public Components(String name, String producer, int value, AreaToUse qualified) {
        this.name = name;
        this.producer = producer;
        this.value = value;
        this.qualified = qualified;
    }
    
    public String getName() {
        return name;
    }
    
    public String getProducer() {
        return producer;
    }
    
    public int getValue() {
        return value;
    }
    
    public AreaToUse getQualified() {
        return qualified;
    }
    
    public abstract String details();
    
    @Override
    public String toString() {
        return this.getName() + " " + this.getProducer() + " " + this.getQualified() + " " + "($ " + this.getValue() + ")";
    }
}

