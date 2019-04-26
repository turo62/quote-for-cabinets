package com.codecool.api;

import com.codecool.components.BoughtComponent;

import java.io.Serializable;
import java.util.List;

public abstract class Store implements Serializable {
    private List<BoughtComponent> stock;
    
    Store() {
        this.stock = stock;
    }
    
    public List<BoughtComponent> getStock() {
        return stock;
    }
}
