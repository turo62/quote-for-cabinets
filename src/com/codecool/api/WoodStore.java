package com.codecool.api;

import com.codecool.components.BoughtComponent;
import com.codecool.components.Components;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class WoodStore extends Store {
    
    private List<BoughtComponent> stock = new ArrayList<>();
    private int money;
    
    public WoodStore(int money) {
        this.stock = stock;
        this.money = money;
    }
    
    public int getMoney() {
        return money;
    }
    
    @Override
    public List<BoughtComponent> getStock() {
        return stock;
    }
    
    public void addComponent(Components component, int number) {
        BoughtComponent toStockComponent = new BoughtComponent(component.getName(), number, component);
        stock.add(toStockComponent);
    }
    
    public void saveStoreStatus() throws IOException {
        FileOutputStream foS = new FileOutputStream("wood-store.ser");
        ObjectOutputStream ooS = new ObjectOutputStream(foS);
        ooS.writeObject(this);
        ooS.flush();
        ooS.close();
    }
}
