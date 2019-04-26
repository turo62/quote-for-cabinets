package com.codecool.cmd;

import com.codecool.api.HardWareStore;
import com.codecool.api.Inventory;
import com.codecool.api.UserInventory;
import com.codecool.api.WoodStore;
import com.codecool.components.*;
import com.codecool.exceptions.NoMoneyException;
import com.codecool.exceptions.OutOfStockException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CmdMenu {
    
    private String savePath = "cabinet-shop.ser";
    private HardWareStore hardwareShop = new HardWareStore(1000000);
    private Scanner userInput = new Scanner(System.in);
    private WoodStore woodShop = new WoodStore(1000000);
    private UserInventory inventory = new UserInventory(250000);
    private String currentType;
    private BoughtComponent boughtComponent;
    
    CmdMenu() {
        if (new File(savePath).exists()) {
            load();
        } else {
            System.out.println("New shop started!");
        }
    }
    
    void start() {
        String[] commands = new String[]{
                "store",
                "cabinets",
                "inventory",
                "help",
                "exit"
        };
        
        while (true) {
            showMenu("Main Menu", commands);
            String command = getInput();
            
            switch (command) {
                case "store":
                    storeMenu();
                    break;
                case "cabinets":
                    cabinetMenu();
                    break;
                case "inventory":
                    inventoryMenu();
                    break;
                case "help":
                    helpMenu();
                    break;
                case "exit":
                    //saveBusinessStatus();
                    System.exit(0);
                default:
                    System.out.println("Unknown command " + command + "!");
                    break;
            }
        }
    }
    
    private void storeMenu() {
        String[] commands = new String[]{
                "list all",
                "list component",
                "buy",
                "sell",
                "back"
        };
        
        while (true) {
            showMenu("Store Menu", commands);
            String command = getInput();
            
            switch (command) {
                case "list all":
                    listAll();
                    break;
                case "list component":
                    listCategory(inventory);
                    break;
                case "buy":
                    shopping();
                    break;
                case "sell":
                    break;
                case "back":
                    return;
                default:
                    System.out.println("Unknown command " + command + "!");
                    break;
            }
        }
    }
    
    private void cabinetMenu() {
        String[] commands = new String[]{
                "display all",
                "list components",
                "build",
                "modify",
                "back"
        };
        
        while (true) {
            showMenu("Cabinet Menu", commands);
            String command = getInput();
            
            switch (command) {
                case "display all":
                    break;
                case "list components":
                    break;
                case "build":
                    break;
                case "modify":
                    break;
                case "back":
                    return;
                default:
                    System.out.println("Unknown command " + command + "!");
                    break;
            }
        }
    }
    
    private void inventoryMenu() {
        String[] commands = new String[]{
                "display all",
                "list component",
                "remove",
                "back"
        };
        
        while (true) {
            showMenu("Inventory Menu", commands);
            String command = getInput();
            
            switch (command) {
                case "display all":
                    break;
                case "list component":
                    break;
                case "remove":
                    break;
                case "back":
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
                "Inventory -> browse your components including remainders of a sheet or lumbers\n" +
                "Help -> display this tutorial\n" +
                "Exit -> close the shop after saving automatically"
        );
    }
    
    private void showMenu(String title, String[] commands) {
        System.out.println("\n" + "\n" + title + "\n");
        System.out.print("Commands  | ");
        for (String command : commands) {
            System.out.print(command + " | ");
        }
        System.out.println("\n" + "\n");
    }
    
    private String getInput() {
        String input = userInput.nextLine().toLowerCase();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>o<<<<<<<<<<<<<<<<<<<<<<<<<");
        return input;
    }
    
    private void listAll() {
        List<? extends Components> components = inventory.getAllComponents();
        displayCategory(components);
    }
    
    private List<? extends Components> chooseComponent(Inventory inventory) {
        List<? extends Components> componentList = null;
        listCategories(inventory);
        switch (getInput()) {
            case "back":
                return null;
            case "0":
                componentList = inventory.getBoards();
                currentType = "lumber";
                break;
            case "1":
                componentList = inventory.getChipBoards();
                currentType = "chipBoard";
                break;
            case "2":
                componentList = inventory.getMDFs();
                currentType = "MDF";
                break;
            case "3":
                componentList = inventory.getPlies();
                currentType = "plywood";
                break;
            case "4":
                componentList = inventory.getGlues();
                currentType = "glue";
                break;
            case "5":
                componentList = inventory.getDowels();
                currentType = "dowel";
                break;
            case "6":
                componentList = inventory.getPocketHoleScrews();
                currentType = "pocketHoleScrew";
                break;
            case "7":
                componentList = inventory.getScrews();
                currentType = "screw";
                break;
            case "8":
                componentList = inventory.getSlides();
                currentType = "slides";
                break;
            case "9":
                componentList = inventory.getHinges();
                currentType = "hinge";
                break;
            case "10":
                componentList = inventory.getPulls();
                currentType = "pulls";
                break;
            case "11":
                componentList = inventory.getKnobs();
                currentType = "knobs";
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
    
    private void displayCategory(List<? extends Components> components) {
        if (components.size() == 0) {
            System.out.println("\nNo items'");
            return;
        }
        
        int count = 0;
        for (int i = 0; i < components.size(); i++) {
            if (i == 0 || i > 0 && !components.get(i - 1).getClass().equals(components.get(i).getClass())) {
                System.out.println("\n");
                System.out.println(components.get(i).getClass().getSimpleName() + ":");
            }
            System.out.println(count + ") " + components.get(i).toString());
            count++;
        }
    }
    
    private void listCategory(Inventory inventory) {
        List<? extends Components> componentList = chooseComponent(inventory);
        displayCategory(componentList);
        
    }
    
    
    private void shopping() {
        List<BoughtComponent> stock = new ArrayList<>();
        System.out.println("Do you want to buy hardware (y) or lumbers/men made sheets (any other key)? \n");
        String input = getInput();
        stock = loadStock(input);
        printStockInfo(stock);
        buyingComponents(stock);
        checkShopping();
    }
    
    private List<BoughtComponent> loadStock(String input) {
        List<Components> components = inventory.getAllComponents();
        int number = 10000;
        int number1 = 50;
        List<BoughtComponent> stock = new ArrayList<>();
        
        for (Components component : components) {
            if (!(component instanceof Wood)) {
                if (!hardwareShop.getStock().contains(component)) {
                    hardwareShop.addComponent(component, number);
                }
            } else if (!(component instanceof Hardware)) {
                if (!woodShop.getStock().contains(component)) {
                    woodShop.addComponent(component, number1);
                }
            }
        }
        
        if (input.equals("y")) {
            stock = hardwareShop.getStock();
        } else {
            stock = woodShop.getStock();
        }
    
        return stock;
    }
    
    private void printStockInfo(List<BoughtComponent> stock) {
        int count = 1;
        for (BoughtComponent boughtComponent : stock) {
            System.out.println(count + ")  " + boughtComponent.getComponent().details());
            count++;
        }
    }
    
    private void buyingComponents(List<BoughtComponent> stock) {
        double money = inventory.getMoney();
        double amountOfGood = 0;
        double paidValue = 0;
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                int number;
                do {
                    System.out.println("Please, select number of good you want to buy or enter '0' to stop shopping.");
                    while (!sc.hasNextInt()) {
                        System.out.println("That's not a number!");
                        sc.next();
                    }
                    number = sc.nextInt();
                } while (number < 0 || number > stock.size());
                System.out.println("Thank you! Got " + number);
    
                if (number == 0) {
                    break;
                }
    
                number -= 1;
                
                System.out.println("Enter amount you need.");
                amountOfGood = Double.parseDouble(getInput());
        
                if (stock.get(number).getComponent() instanceof Dowel || stock.get(number).getComponent() instanceof Screw) {
                    paidValue = amountOfGood / 100 * stock.get(number).getComponent().getValue();
                } else {
                    paidValue = amountOfGood * stock.get(number).getComponent().getValue();
                }
        
                double goodStock = stock.get(number).getNumber();
                if (amountOfGood > goodStock) {
                    System.out.println("Deal");
                    throw new OutOfStockException("Sorry but there is no such high stock available. Please, enter value below " + stock.get(number).getNumber());
                }
        
                if (inventory.getMoney() < paidValue) {
                    System.out.println("Deal is failed.");
                    throw new NoMoneyException("You have no money enough to buy so many goods.");
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
            } catch (OutOfStockException e) {
                e.printStackTrace();
            } catch (NoMoneyException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void checkShopping() {
        double newMoney = hardwareShop.getMoney();
        List<BoughtComponent> stock = hardwareShop.getStock();
        double restOfMoney = inventory.getMoney();
        List<BoughtComponent> treasure = inventory.getBoughtComponents();
        System.out.println(restOfMoney);
        System.out.println(newMoney);
        for (BoughtComponent component : stock) {
            System.out.println(component.getName() + component.getNumber());
        }
        for (BoughtComponent component : treasure) {
            System.out.println(component.getName() + component.getNumber());
        }
    }
    
    
    private void buildCabinet() {
        //function of cabinet
        //getcarcass
        //isFramed
        //getDrawers (carving?)
        //getDoors (carving?)
        //getFeet
    }
    
    private void load() {
        System.out.print("Load my shop? (y/n) ");
        String input = getInput();
        if (input.equals("y")) {
            loadShop();
        } else {
            System.out.println("New cabinetmaking shop started!");
        }
    }
    
    private void loadShop() {
        try {
            FileInputStream fileIn = new FileInputStream(savePath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            inventory = (UserInventory) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("My shop loaded!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Load failed, starting new shop!");
        }
    }
    
    private void saveBusinessStatus() {
        try {
            inventory.saveShopStatus();
            woodShop.saveStoreStatus();
            hardwareShop.saveStoreStatus();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

