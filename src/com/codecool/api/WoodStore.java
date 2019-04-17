package com.codecool.api;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WoodStore extends Store {
    
    private int money;
    
    public WoodStore(int money) {
        this.money = money;
    }
    
    public int getMoney() {
        return money;
    }
    
    public void saveStoreStatus() throws IOException {
        FileOutputStream foS = new FileOutputStream("wood-store.ser");
        ObjectOutputStream ooS = new ObjectOutputStream(foS);
        ooS.writeObject(this);
        ooS.flush();
        ooS.close();
    }
}
