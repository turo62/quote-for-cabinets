package com.codecool.operations;

import com.codecool.cmd.Cabinet;
import com.codecool.cmd.Inventory;

import java.util.List;

public class UserInventory extends Inventory {
    private int money;
    private List<Cabinet> cabinets;
    
    public UserInventory(int money) {
        this.money = money;
    }
}
