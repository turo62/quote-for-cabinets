package com.codecool.cmd;

import com.codecool.api.*;
import com.codecool.components.*;
import com.codecool.exceptions.*;
import com.codecool.parts.DesignPattern;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CmdMenu {
    
    private String savePath = "cabinet-shop.ser";
    private HardWareStore hardwareShop = new HardWareStore(1000000);
    private WoodStore woodShop = new WoodStore(1000000);
    private UserInventory inventory = new UserInventory(250000);
    private AllPrinting display = new AllPrinting();
    
    CmdMenu() {
        if (new File(savePath).exists()) {
            load();
        } else {
            display.simpleDisplay("New shop started!");
        }
    }
    
    void start() throws NotEnoughException, NoDesignException, NoSuchOptionException, NoComponentException, ComponentIsAddedException {
        String[] commands = new String[]{
                "store (s)",
                "cabinets (c)",
                "inventory (i)",
                "help (h)",
                "exit (e)"
        };
        
        while (true) {
            display.showMenu("Main Menu", commands);
            String command = display.getInput();
            
            switch (command) {
                case "s":
                    storeMenu();
                    break;
                case "c":
                    cabinetMenu();
                    break;
                case "i":
                    inventoryMenu();
                    break;
                case "h":
                    helpMenu();
                    break;
                case "e":
                    saveBusinessStatus();
                    System.exit(0);
                default:
                    System.out.println("Unknown command " + command + "!");
                    break;
            }
        }
    }
    
    private void storeMenu() throws NotEnoughException, NoSuchOptionException {
        String[] commands = new String[]{
                "list all (a)",
                "list component (c)",
                "buy (u)",
                "sell (s)",
                "back (b)"
        };
        
        while (true) {
            display.showMenu("Store Menu", commands);
            String command = display.getInput();
            
            switch (command) {
                case "a":
                    listAll();
                    break;
                case "c":
                    listCategory(inventory);
                    break;
                case "u":
                    shopping();
                    break;
                case "s":
                    break;
                case "b":
                    return;
                default:
                    System.out.println("Unknown command: " + command + "!");
                    break;
            }
        }
    }
    
    private void cabinetMenu() throws NotEnoughException, NoDesignException, NoComponentException, ComponentIsAddedException {
        String[] commands = new String[]{
                "display all (a)",
                "list components (c)",
                "design (d)",
                "build (u)",
                "modify (m)",
                "back (b)"
        };
        
        while (true) {
            display.showMenu("Cabinet Menu", commands);
            String command = display.getInput();
            
            switch (command) {
                case "a":
                    break;
                case "c":
                    break;
                case "d":
                    designCabinet();
                    break;
                case "u":
                    buildCabinet();
                    break;
                case "m":
                    break;
                case "b":
                    return;
                default:
                    System.out.println("Unknown command " + command + "!");
                    break;
            }
        }
    }
    
    //To be implemented!
    private void inventoryMenu() {
        String[] commands = new String[]{
                "display all (a)",
                "list component (c)",
                "remove (r)",
                "back (b)"
        };
        
        while (true) {
            display.showMenu("Inventory Menu", commands);
            String command = display.getInput();
            
            switch (command) {
                case "a":
                    break;
                case "c":
                    break;
                case "r":
                    break;
                case "b":
                    return;
                default:
                    System.out.println("Unknown command " + command + "!");
                    break;
            }
        }
    }
    
    private void helpMenu() {
        System.out.println("\n" +
                "This small app is about managing your hobby of cabinetmaking. It lets you buying components,\n" +
                "making/modifying your own cabinet(s) and can sell what you produced.\n\n" +
                "Main menu options:\n" +
                "Store -> browse or buy components and sell cabinets made\n" +
                "Cabinets -> build/modify cabinets display your cabinets and their components\n" +
                "Inventory -> browse your components including remainders sheets or lumbers\n" +
                "Help -> display this tutorial\n" +
                "Exit -> close the shop after saving automatically"
        );
    }
    
    private void listAll() {
        List<? extends Components> components = inventory.getAllComponents();
        inventory.invPrint.displayCategory(components);
    }
    
    private List<? extends Components> chooseComponent(Inventory inventory) {
        List<? extends Components> componentList = null;
        listCategories(inventory);
        switch (display.getInput()) {
            case "back":
                return null;
            case "0":
                componentList = inventory.getBoards();
                break;
            case "1":
                componentList = inventory.getChipBoards();
                break;
            case "2":
                componentList = inventory.getMDFs();
                break;
            case "3":
                componentList = inventory.getPlies();
                break;
            case "4":
                componentList = inventory.getGlues();
                break;
            case "5":
                componentList = inventory.getDowels();
                break;
            case "6":
                componentList = inventory.getPocketHoleScrews();
                break;
            case "7":
                componentList = inventory.getScrews();
                break;
            case "8":
                componentList = inventory.getSlides();
                break;
            case "9":
                componentList = inventory.getHinges();
                break;
            case "10":
                componentList = inventory.getPulls();
                break;
            case "11":
                componentList = inventory.getKnobs();
                break;
            default:
                System.out.println("Wrong input!");
                break;
        }
        return componentList;
    }
    
    private void listCategories(Inventory inventory) {
        System.out.println("\nCommands (back or type a number):\n" +
                " 0) Lumbers (" + inventory.getBoards().size() + ")" + "\n" +
                " 1) Chipboard sheets (" + inventory.getChipBoards().size() + ")" + "\n" +
                " 2) MDF sheets (" + inventory.getMDFs().size() + ")" + "\n" +
                " 3) Plywood sheets (" + inventory.getPlies().size() + ")" + "\n" +
                " 4) Glues (" + inventory.getGlues().size() + ")" + "\n" +
                " 5) Dowels (" + inventory.getDowels().size() + ")" + "\n" +
                " 6) Pockethole screws (" + inventory.getPocketHoleScrews().size() + ")" + "\n" +
                " 7) Chipboard screws (" + inventory.getScrews().size() + ")" + "\n" +
                " 8) Slides (" + inventory.getSlides().size() + ")" + "\n" +
                " 9) Hinges(" + inventory.getHinges().size() + ")" + "\n" +
                "10) Pulls (" + inventory.getPulls().size() + ")" + "\n" +
                "11) Knobs (" + inventory.getKnobs().size() + ")" + "\n");
    }
    
    private void listCategory(Inventory myInventory) {
        List<? extends Components> componentList = chooseComponent(myInventory);
        inventory.invPrint.displayCategory(componentList);
        
    }
    
    private void shopping() throws NotEnoughException {
        List<? extends BoughtComponent> stock;
        int choice = 0;
        display.simpleDisplay("Enter a character to choose type of goods \n");
        char input = inventory.simpleDecision("hardware", "lumber/men made sheets");
        if (input == 'y') {
            choice = 1;
        } else if (input == 'n') {
            choice = 2;
        }
    
        stock = loadStock(choice);
        display.printStockInfo(stock);
        buyingComponents(stock);
        printBoughtStock();
    }
    
    private List<? extends BoughtComponent> loadStock(int myNumber) {
        List<? extends Components> components = inventory.getAllComponents();
        int number = 10000;
        int number1 = 50;
        List<BoughtComponent> myStock = new ArrayList<>();
        
        if (myNumber == 1 && hardwareShop.getStock().size() == 0) {
            for (Components component : components) {
                if (!(component instanceof Wood)) {
                    hardwareShop.addComponent(component, number);
                }
            }
            myStock = hardwareShop.getStock();
        } else if (myNumber == 1 && hardwareShop.getStock().size() != 0) {
            myStock = hardwareShop.getStock();
        } else if (myNumber == 2 && woodShop.getStock().size() == 0) {
            for (Components component : components) {
                if (!(component instanceof Hardware)) {
                    woodShop.addComponent(component, number1);
                }
            }
            myStock = woodShop.getStock();
        } else if (myNumber == 2 && woodShop.getStock().size() != 0) {
            myStock = woodShop.getStock();
        }
        
        return myStock;
    }
    
    private void buyingComponents(List<? extends BoughtComponent> stock) throws NotEnoughException {
        double amountOfGood;
        double paidValue;
        while (true) {
            Scanner sc = new Scanner(System.in);
            int number;
            
            do {
                display.simpleDisplay("Please, select number of good you want to buy or enter '0' to stop shopping. \n");
                while (!sc.hasNextInt()) {
                    display.simpleDisplay("That's not a number! \n");
                    sc.next();
                }
                number = sc.nextInt();
            }
            
            while (number < 0 || number > stock.size());
            System.out.println("Thank you! Got " + number + "\n");
            
            if (number == 0) {
                break;
            }
            
            number -= 1;
            
            display.simpleDisplay("Enter amount you need. \n");
            amountOfGood = Double.parseDouble(display.getInput());
            
            if (stock.get(number).getComponent() instanceof Dowel || stock.get(number).getComponent() instanceof Screw) {
                paidValue = amountOfGood / 100 * stock.get(number).getComponent().getValue();
            } else {
                paidValue = amountOfGood * stock.get(number).getComponent().getValue();
            }
            
            double goodStock = stock.get(number).getNumber();
            
            if (amountOfGood > goodStock) {
                throw new NotEnoughException("Sorry but there is no such high stock available. Please, enter value below " + stock.get(number).getNumber());
            }
            
            if (inventory.getMoney() < paidValue) {
                throw new NotEnoughException("You have no money enough to buy so many goods.");
            }
            
            BoughtComponent newTreasure = new BoughtComponent(stock.get(number).getName(), amountOfGood, stock.get(number).getComponent());
            inventory.setMoney((-1) * paidValue);
            inventory.addComponent(newTreasure);
            stock.get(number).manageStock(amountOfGood);
            
            if (!(stock.get(number).getComponent() instanceof Wood)) {
                hardwareShop.setMoney(paidValue);
            } else {
                woodShop.setMoney(paidValue);
            }
        }
    }
    
    private void printBoughtStock() {
        double restOfMoney = inventory.getMoney();
        List<BoughtComponent> treasure = inventory.getBoughtComponents();
        System.out.println("You have $" + restOfMoney + " available for shopping. \n");
        
        for (BoughtComponent component : treasure) {
            System.out.println(component.getNumber() + "pcs of " + component.getComponent().toString());
        }
    }
    
    private void designCabinet() {
        display.simpleDisplay("Enter name of the cabinet: \n");
        inventory.designCabinet(display.getInput());
    }
    
    private void buildCabinet() throws NotEnoughException, NoDesignException, NoComponentException, ComponentIsAddedException {
    
        DesignPattern chosenDesign = inventory.selectDesign();
        inventory.buildCarcass(chosenDesign);
        inventory.buildDoors(chosenDesign);
        
        
    }
    
    private void load() {
        display.simpleDisplay("Load my shop? (y/n) ");
        String input = display.getInput();
        if (input.equals("y")) {
            loadShop();
        } else {
            display.simpleDisplay("New cabinetmaking shop started!");
        }
    }
    
    private void loadShop() {
        inventory.loadInventory();
        woodShop.loadWoodStore();
        hardwareShop.loadHardwareStore();
    }
    
    private void saveBusinessStatus() {
        try {
            inventory.saveInventory();
            woodShop.saveStoreStatus();
            hardwareShop.saveStoreStatus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
