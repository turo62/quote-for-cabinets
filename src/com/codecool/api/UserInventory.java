package com.codecool.api;

import com.codecool.components.BoughtComponent;
import com.codecool.parts.DesignPattern;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class UserInventory extends Inventory {
    private double money;
    private List<Cabinet> cabinets = new ArrayList<>();
    private List<DesignPattern> orderedCabinets = new ArrayList<>();
    private List<BoughtComponent> boughtComponents = new ArrayList<>();
    
    public UserInventory(int money) {
        this.money = money;
    }
    
    public double getMoney() {
        return money;
    }
    
    public void setMoney(double value) {
        this.money += value;
    }
    
    public List<Cabinet> getCabinets() {
        return cabinets;
    }
    
    public List<BoughtComponent> getBoughtComponents() {
        return boughtComponents;
    }
    
    public void addComponent(BoughtComponent boughtComponent) {
        boughtComponents.add(boughtComponent);
    }
    
    public void saveShopStatus() throws IOException {
        FileOutputStream foS = new FileOutputStream("cabinet-shop.ser");
        ObjectOutputStream ooS = new ObjectOutputStream(foS);
        ooS.writeObject(this);
        ooS.flush();
        foS.close();
        ooS.close();
    }
}
