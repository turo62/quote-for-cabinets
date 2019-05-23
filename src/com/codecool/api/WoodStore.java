package com.codecool.api;

import com.codecool.components.BoughtComponent;
import com.codecool.components.Components;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WoodStore extends Store implements Serializable {
    
    private static final long serialVersionUID = 6544560723913313411L;
    private List<BoughtComponent> stock = new ArrayList<>();
    private double money;
    private double number;
    
    public WoodStore(int money) {
        this.stock = stock;
        this.money = money;
        this.number = number;
    }
    
    public double getMoney() {
        return money;
    }
    
    public void setMoney(double value) {
        money += value;
    }
    
    public double getNumber() {
        return number;
    }
    
    public void setNumber(double number) {
        this.number += number;
    }
    
    @Override
    public List<BoughtComponent> getStock() {
        return stock;
    }
    
    public void addComponent(Components component, double number) {
        BoughtComponent toStockComponent = new BoughtComponent(component.getName(), number, component);
        stock.add(toStockComponent);
    }
    
    public void saveStoreStatus() throws IOException {
        FileOutputStream foS = new FileOutputStream("wood-store.ser");
        ObjectOutputStream ooS = new ObjectOutputStream(foS);
        ooS.writeDouble(money);
        ooS.writeObject(stock);
        ooS.flush();
        foS.close();
        ooS.close();
    }
    
    public void loadWoodStore() {
        try {
            FileInputStream fileIn = new FileInputStream("wood-store.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            int money = (int) in.readObject();
            List<BoughtComponent> stock = (List<BoughtComponent>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Load failed, starting new wood store!");
        }
    }
}
