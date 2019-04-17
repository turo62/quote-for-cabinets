package com.codecool.api;

import com.codecool.components.BoughtComponent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Store implements java.io.Serializable {
    protected List<BoughtComponent> stock = new ArrayList<>();
    private Iterator<BoughtComponent> stockIterator;
    
    public Store() {
        this.stock = stock;
    }
    
    public List<BoughtComponent> getStock() {
        return stock;
    }
    
    public Iterator<BoughtComponent> getIterator() {
        return this.stockIterator;
    }
    
    private class StockIterator implements Iterator {
        private int index;
        
        public boolean hasNext() {
            if (index < stock.size()) {
                return true;
            }
            return false;
        }
        
        public BoughtComponent next() {
            return stock.get(index++);
        }
    }
}
