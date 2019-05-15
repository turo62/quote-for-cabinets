package com.codecool.api;

import com.codecool.components.*;
import com.codecool.enums.Sizes;
import com.codecool.parts.DesignPattern;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInventory extends Inventory {
    private double money;
    private List<Cabinet> cabinets = new ArrayList<>();
    private List<DesignPattern> orderedCabinets = new ArrayList<>();
    private List<BoughtComponent> boughtComponents = new ArrayList<>();
    private List<BoughtComponent> remainders = new ArrayList<>();
    private DisplayStore inventoryPrinting = new DisplayStore();
    
    public UserInventory() {
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
    
    public List<DesignPattern> getDesigns() {
        return orderedCabinets;
    }
    
    public List<BoughtComponent> getRemainders() {
        return remainders;
    }
    
    public void addComponent(BoughtComponent boughtComponent) {
        boughtComponents.add(boughtComponent);
    }
    
    private void addToRemainderList(BoughtComponent remainder) {
        remainders.add(remainder);
    }
    
    public void addDesign(DesignPattern newPattern) {
        orderedCabinets.add(newPattern);
    }
    
    public void removeBoughtComponent(BoughtComponent component) {
        boughtComponents.remove(component);
    }
    
    public void planingWood(Lumber rawLumber) {
        if (rawLumber.getSpecies().equals("pine")) {
            rawLumber.setThickness(4);
        }
        rawLumber.setThickness(8);
    }
    
    private BoughtComponent dimensioning(Wood rawWood, int length, int width, String name) {
        double unitPrice = rawWood.getValue() / (rawWood.getLength() * rawWood.getWidth());
        
        if (rawWood instanceof Lumber) {
            Lumber newPlank = new Lumber(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (unitPrice * length * width), rawWood.getQualified(), length, width, rawWood.getThickness(), ((Lumber) rawWood).getSpecies());
            Lumber newPlank1 = new Lumber(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (unitPrice * rawWood.setWidth(width) * length), rawWood.getQualified(), length, rawWood.setWidth(width), rawWood.getThickness(), ((Lumber) rawWood).getSpecies());
            Lumber newPlank2 = new Lumber(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (newPlank.getValue() - newPlank1.getValue()), rawWood.getQualified(), rawWood.setLength(length), width, rawWood.getThickness(), ((Lumber) rawWood).getSpecies());
            
            if (newPlank1.getLength() > Sizes.W.getSectionWidth() && newPlank1.getWidth() > Sizes.C.getDepth()) {
                addToRemainderList(new BoughtComponent(newPlank1.getName(), 1, newPlank1));
            } else newPlank.setValue(-1 * newPlank1.getValue());
            
            if (newPlank2.getLength() > Sizes.W.getSectionWidth() && newPlank2.getWidth() > Sizes.C.getDepth()) {
                addToRemainderList(new BoughtComponent(newPlank2.getName(), 1, newPlank2));
            } else newPlank.setValue(-1 * newPlank2.getValue());
            
            return new BoughtComponent(name, 1, newPlank);
            
        } else if (rawWood instanceof ChipBoard) {
            ChipBoard newPlank = new ChipBoard(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (unitPrice * length * width), rawWood.getQualified(), length, width, rawWood.getThickness());
            ChipBoard newPlank1 = new ChipBoard(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (unitPrice * rawWood.setWidth(width) * length), rawWood.getQualified(), length, rawWood.setWidth(width), rawWood.getThickness());
            ChipBoard newPlank2 = new ChipBoard(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (newPlank.getValue() - newPlank1.getValue()), rawWood.getQualified(), rawWood.setLength(length), width, rawWood.getThickness());
            
            if (newPlank1.getLength() > Sizes.W.getSectionWidth() && newPlank1.getWidth() > Sizes.C.getDepth()) {
                addToRemainderList(new BoughtComponent(newPlank1.getName(), 1, newPlank1));
            } else newPlank.setValue(-1 * newPlank1.getValue());
            
            if (newPlank2.getLength() > Sizes.W.getSectionWidth() && newPlank2.getWidth() > Sizes.C.getDepth()) {
                addToRemainderList(new BoughtComponent(newPlank2.getName(), 1, newPlank2));
            } else newPlank.setValue(-1 * newPlank2.getValue());
            
            return new BoughtComponent(name, 1, newPlank);
            
        } else if (rawWood instanceof MDF) {
            MDF newPlank = new MDF(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (unitPrice * length * width), rawWood.getQualified(), length, width, rawWood.getThickness());
            MDF newPlank1 = new MDF(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (unitPrice * rawWood.setWidth(width) * length), rawWood.getQualified(), length, rawWood.setWidth(width), rawWood.getThickness());
            MDF newPlank2 = new MDF(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (newPlank.getValue() - newPlank1.getValue()), rawWood.getQualified(), rawWood.setLength(length), width, rawWood.getThickness());
            
            if (newPlank1.getLength() > Sizes.W.getSectionWidth() && newPlank1.getWidth() > Sizes.C.getDepth()) {
                addToRemainderList(new BoughtComponent(newPlank1.getName(), 1, newPlank1));
            } else newPlank.setValue(-1 * newPlank1.getValue());
            
            if (newPlank2.getLength() > Sizes.W.getSectionWidth() && newPlank2.getWidth() > Sizes.C.getDepth()) {
                addToRemainderList(new BoughtComponent(newPlank2.getName(), 1, newPlank2));
            } else newPlank.setValue(-1 * newPlank2.getValue());
            
            return new BoughtComponent(name, 1, newPlank);
            
        } else if (rawWood instanceof PlyWood) {
            PlyWood newPlank = new PlyWood(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (unitPrice * length * width), rawWood.getQualified(), length, width, rawWood.getThickness());
            PlyWood newPlank1 = new PlyWood(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (unitPrice * rawWood.setWidth(width) * length), rawWood.getQualified(), length, rawWood.setWidth(width), rawWood.getThickness());
            PlyWood newPlank2 = new PlyWood(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (newPlank.getValue() - newPlank1.getValue()), rawWood.getQualified(), rawWood.setLength(length), width, rawWood.getThickness());
            
            if (newPlank1.getLength() > Sizes.W.getSectionWidth() && newPlank1.getWidth() > Sizes.C.getDepth()) {
                addToRemainderList(new BoughtComponent(newPlank1.getName(), 1, newPlank1));
            } else newPlank.setValue(-1 * newPlank1.getValue());
            
            if (newPlank2.getLength() > Sizes.W.getSectionWidth() && newPlank2.getWidth() > Sizes.C.getDepth()) {
                addToRemainderList(new BoughtComponent(newPlank2.getName(), 1, newPlank2));
            } else newPlank.setValue(-1 * newPlank2.getValue());
            
            return new BoughtComponent(name, 1, newPlank);
            
        }
        return null;
    }
    
    public void saveShopStatus() throws IOException {
        FileOutputStream foS = new FileOutputStream("cabinet-shop.ser");
        ObjectOutputStream ooS = new ObjectOutputStream(foS);
        ooS.writeObject(this);
        ooS.flush();
        foS.close();
        ooS.close();
    }
    
    private Components selectWood(String name) {
        List<Components> stock = new ArrayList<>();
        List<Double> stockAmount = new ArrayList<>();
        
        List<BoughtComponent> remainders = getRemainders();
        List<? extends BoughtComponent> components = getBoughtComponents();
        
        remainders.stream().filter(component -> component.getName().equals(name)).forEach(component -> {
            stock.add(component.getComponent());
            stockAmount.add(component.getNumber());
        });
        
        components.stream().filter(component -> component.getName().equals(name)).forEach(component -> {
            stock.add(component.getComponent());
            stockAmount.add(component.getNumber());
        });
        
        int number;
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            inventoryPrinting.displayCategory(stock);
            
            do {
                System.out.println("Please, select number of the wood you want your part being built. \n");
                while (!sc.hasNextInt()) {
                    System.out.println("That's not a number! \n");
                    sc.next();
                }
                number = sc.nextInt();
            }
            
            while (number < 0 || number > components.size());
            
            return stock.get(number);
        }
    }
}
