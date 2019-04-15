package com.codecool.cmd;

public class Cabinet extends Inventory {
    private String name;
    private String function;
    private int price;
    private int cost;
    
    public Cabinet(String name, String function, int price, int cost) {
        this.name = name;
        this.function = function;
        this.price = price;
        this.cost = cost;
    }
    //getcarcass
    //isFramed
    //getDrawers (carving?)
    //getDoors (carving?)
    //getFeet
    
}
