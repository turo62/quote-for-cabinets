package com.codecool.api;

import com.codecool.components.BoughtComponent;

import java.util.List;

public abstract class Store implements java.io.Serializable {
    private List<BoughtComponent> stock;
    
    Store() {
        this.stock = stock;
    }
    
    public List<BoughtComponent> getStock() {
        return stock;
    }
}
