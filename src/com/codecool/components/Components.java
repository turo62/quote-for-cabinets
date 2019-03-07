package com.codecool.components;

import com.codecool.enums.Application;

public abstract class Components implements java.io.Serializable {
    private String name;
    private String producer;
    private int value;
    private Application qualified;
    
    public Components(String name, String producer, int value, Application qualified) {
        this.name = name;
        this.producer = producer;
        this.value = value;
        this.qualified =qualified;
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
    
    public Application getQualified() {
        return qualified;
    }
    
    @Override
    public String toString(){
        return this.getName() + " " + this.getProducer() + " " + this.getQualified() + " " + "($ " + this.getValue() + ")";
    }
}

