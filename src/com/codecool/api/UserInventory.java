package com.codecool.api;

import com.codecool.components.BoughtComponent;
import com.codecool.components.Components;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserInventory extends Inventory {
    private int money;
    private List<Cabinet> cabinets = new ArrayList<>();
    private List<BoughtComponent> boughtComponents = new ArrayList<>();
    private Iterator<BoughtComponent> boughtComponentIterator;
    
    public UserInventory(int money) {
        this.money = money;
    }
    
    public int getMoney() {
        return money;
    }
    
    public void setMoney(int value) {
        this.money += value;
    }
    
    public void manageMoney(int amount) {
        money += amount;
    }
    
    public List<Cabinet> getCabinets() {
        return cabinets;
    }
    
    public List<BoughtComponent> getBoughtComponents() {
        return boughtComponents;
    }
    
    public void addCabinet(Cabinet myCabinet) {
        cabinets.add(myCabinet);
    }
    
    public void addComponent(Components component, int number) {
        BoughtComponent toStockComponent = new BoughtComponent(component.getName(), number, component);
        boughtComponents.add(toStockComponent);
    }
    
    
    public Iterator<BoughtComponent> getIterator() {
        return this.boughtComponentIterator;
    }
    
    public void saveShopStatus() throws IOException {
        FileOutputStream foS = new FileOutputStream("cabinet-shop.ser");
        ObjectOutputStream ooS = new ObjectOutputStream(foS);
        ooS.writeObject(this);
        ooS.flush();
        ooS.close();
    }
    
    private class BoughtComponentIterator implements Iterator {
        private int index;
        
        public boolean hasNext() {
            if (index < boughtComponents.size()) {
                return true;
            }
            return false;
        }
        
        public BoughtComponent next() {
            return boughtComponents.get(index++);
        }
    }
}
