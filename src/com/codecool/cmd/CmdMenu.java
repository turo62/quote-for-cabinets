package com.codecool.cmd;

import com.codecool.api.HardWareStore;
import com.codecool.api.Inventory;
import com.codecool.api.UserInventory;
import com.codecool.api.WoodStore;
import com.codecool.components.*;
import com.codecool.enums.*;
import com.codecool.exceptions.NotEnoughException;
import com.codecool.parts.DesignPattern;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Scanner;

class CmdMenu {
    
    private String savePath = "cabinet-shop.ser";
    private HardWareStore hardwareShop = new HardWareStore(1000000);
    private Scanner userInput = new Scanner(System.in);
    private WoodStore woodShop = new WoodStore(1000000);
    private UserInventory inventory = new UserInventory(250000);
    private String currentType;
    private BoughtComponent boughtComponent;
    private DesignPattern designDetails;
    
    CmdMenu() {
        if (new File(savePath).exists()) {
            load();
        } else {
            System.out.println("New shop started!");
        }
    }
    
    void start() throws NotEnoughException {
        String[] commands = new String[]{
                "store (s)",
                "cabinets (c)",
                "inventory (i)",
                "help (h)",
                "exit (e)"
        };
        
        while (true) {
            showMenu("Main Menu", commands);
            String command = getInput();
            
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
                    //saveBusinessStatus();
                    System.exit(0);
                default:
                    System.out.println("Unknown command " + command + "!");
                    break;
            }
        }
    }
    
    private void storeMenu() throws NotEnoughException {
        String[] commands = new String[]{
                "list all (a)",
                "list component (c)",
                "buy (b)",
                "sell (s)",
                "back (b)"
        };
        
        while (true) {
            showMenu("Store Menu", commands);
            String command = getInput();
            
            switch (command) {
                case "a":
                    listAll();
                    break;
                case "c":
                    listCategory(inventory);
                    break;
                case "s":
                    shopping();
                    break;
                case "e":
                    break;
                case "b":
                    return;
                default:
                    System.out.println("Unknown command: " + command + "!");
                    break;
            }
        }
    }
    
    private void cabinetMenu() throws NotEnoughException {
        String[] commands = new String[]{
                "display all (a)",
                "list components (c)",
                "design (d)",
                "build (u)",
                "modify (m)",
                "back (b)"
        };
        
        while (true) {
            showMenu("Cabinet Menu", commands);
            String command = getInput();
            
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
    
    private void inventoryMenu() {
        String[] commands = new String[]{
                "display all (a)",
                "list component (c)",
                "remove (r)",
                "back (b)"
        };
        
        while (true) {
            showMenu("Inventory Menu", commands);
            String command = getInput();
            
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
    
    private void showMenu(String title, String[] commands) {
        System.out.println("\n" + title + "\n");
        System.out.print("Commands  | ");
        for (String command : commands) {
            System.out.print(command + " | ");
        }
        System.out.println("\n Enter the letter in brackets to choose then <Enter>.");
        System.out.println("\n");
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
    
    
    private void shopping() throws NotEnoughException {
        List<BoughtComponent> stock;
        System.out.println("Do you want to buy hardware (y) or lumbers/men made sheets (n)? \n");
        String input = getInput();
        stock = loadStock(input);
        printStockInfo(stock);
        buyingComponents(stock);
        printBoughtStock();
    }
    
    private List<BoughtComponent> loadStock(String input) {
        List<Components> components = inventory.getAllComponents();
        int number = 10000;
        int number1 = 50;
        List<BoughtComponent> stock = new ArrayList<>();
    
        if (input.equals("y") && hardwareShop.getStock().size() == 0) {
            for (Components component : components) {
                if (!(component instanceof Wood)) {
                    hardwareShop.addComponent(component, number);
                }
            }
            stock = hardwareShop.getStock();
        } else if (input.equals("y") && hardwareShop.getStock().size() != 0) {
            stock = hardwareShop.getStock();
        } else if (input.equals("n") && woodShop.getStock().size() == 0) {
            for (Components component : components) {
                if (!(component instanceof Hardware)) {
                    woodShop.addComponent(component, number1);
                }
            }
            stock = woodShop.getStock();
        } else if (input.equals("n") && woodShop.getStock().size() != 0) {
            stock = hardwareShop.getStock();
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
    
    private void buyingComponents(List<BoughtComponent> stock) throws NotEnoughException {
        double amountOfGood;
        double paidValue;
        while (true) {
            Scanner sc = new Scanner(System.in);
            int number;
    
            do {
                System.out.println("Please, select number of good you want to buy or enter '0' to stop shopping. \n");
                while (!sc.hasNextInt()) {
                    System.out.println("That's not a number! \n");
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
    
            System.out.println("Enter amount you need. \n");
            amountOfGood = Double.parseDouble(getInput());
    
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
            System.out.println(component.getNumber() + "pcs of " + component.getName());
        }
    }
    
    private DesignPattern designCabinet() {
        System.out.println("Enter name of the cabinet: \n");
        String name = getInput();
        int numberOfDrawers;
        boolean slide;
        List<DesignPattern> myList = inventory.getDesigns();
        
        CabinetType myType = chooseType();
        String material = chooseMaterial();
        IsFramed framed = setFrame();
        IsInset seating = setSeating();
        int verticalSections = setSections(myType);
        int shelves = setShelves(myType, verticalSections);
        String handle = setHandle();
        String hinge = setHinge(myType, shelves, handle, framed, seating);
        System.out.println(getClass(handle));
    
        if (myType.name().equals('W')) {
            numberOfDrawers = 0;
        } else {
            numberOfDrawers = ((verticalSections % 10 - shelves % 3) * 5);
        }
    
        if (myType.equals(CabinetType.W)) {
            slide = false;
        } else {
            slide = setSlide();
        }
    
        inventory.addDesign(new DesignPattern(name, myType, material, framed, verticalSections, shelves, handle, hinge, seating, numberOfDrawers, slide));
        return designDetails;
    }
    
    private CabinetType chooseType() {
        CabinetType myType = null;
        String command;
        
        while (myType == null) {
            System.out.println("Enter type of cabinet you want.");
            String[] commands = new String[]{
                    "wardrobe",
                    "commode"
            };
            do {
                showMenu("Cabinet design", commands);
                command = getInput();
                for (CabinetType type : EnumSet.allOf(CabinetType.class)) {
                    if (type.getUse().equals(command)) {
                        myType = type;
                    }
                }
            } while (commands.equals(command));
        }
        
        return myType;
    }
    
    private String chooseMaterial() {
        List<Wood> woodMaterial = new ArrayList<>();
        String material = "";
        String command;
        List<String> recommendations = new ArrayList<>();
        String chosen = "";
        
        while (material.equals("")) {
            System.out.println("Enter material you want your cabinet made by.");
            String[] commands = new String[]{
                    "lumber",
                    "plywood",
                    "chipboard"
            };
            do {
                showMenu("Enter the kind of material", commands);
                command = getInput();
                for (String com : commands) {
                    if (com.equals(command)) {
                        material = com;
                    }
                }
            } while (commands.equals(command));
        }
        
        if (material.equals("lumber")) {
            woodMaterial.addAll(inventory.getBoards());
        } else if (material.equals("plywood")) {
            woodMaterial.addAll(inventory.getPlies());
        } else if (material.equals("chipboard")) {
            woodMaterial.addAll(inventory.getChipBoards());
        }
        
        for (Wood wood : woodMaterial) {
            if (wood.getThickness() > 15 && wood.getThickness() < 30) {
                recommendations.add(wood.getName());
            }
        }
        
        while (chosen.equals("")) {
            Scanner sc = new Scanner(System.in);
            int number;
            int count = 1;
            for (String recommendation : recommendations) {
                System.out.println(count + ") " + recommendation);
                count++;
            }
            
            do {
                System.out.println("Please, select number of you want your cabinet made by. \n");
                while (!sc.hasNextInt()) {
                    System.out.println("That's not a number! \n");
                    sc.next();
                }
                number = sc.nextInt();
            }
            
            while (number < 0 || number > recommendations.size());
            chosen = recommendations.get(number - 1);
        }
        
        return chosen;
    }
    
    private IsFramed setFrame() {
        IsFramed frame;
        System.out.println("Do you want frameless or face framed design?");
        char choice = simpleDecision("framed", "frameless");
        if (choice == 'y') {
            frame = IsFramed.FF;
        } else {
            frame = IsFramed.FL;
        }
        return frame;
    }
    
    private int setSections(CabinetType myType) {
        int sections = 0;
        if (myType == CabinetType.W) {
            System.out.println("Select type of clothes you want to store in your wardrobe.");
            System.out.println("Storing pullovers, panties.");
            if (simpleDecision("yes", "not") == 'y') {
                sections += 100;
            }
            System.out.println("Storing coats.");
            if (simpleDecision("yes", "not") == 'y') {
                sections += 10;
            }
            System.out.println("Storing shirts, trousers.");
            if (simpleDecision("yes", "not") == 'y') {
                sections++;
            }
        } else {
            System.out.println("Do you need a large commode?");
            if (simpleDecision("yes", "not") == 'y') {
                sections = 3;
            } else {
                sections = 2;
            }
    
            System.out.println("Do you need selves?");
            if (simpleDecision("yes", "not") == 'y') {
                sections += 10;
            }
        }
        
        return sections;
    }
    
    private IsInset setSeating() {
        IsInset seating;
        System.out.println("Do you want inset doors/drawers or overlaying ones?");
        char choice = simpleDecision("inset", "overlay");
        if (choice == 'y') {
            seating = IsInset.INSET;
        } else {
            seating = IsInset.OVERLAY;
        }
        return seating;
    }
    
    private String setHandle() {
        String handle;
        List<? extends Components> components;
        char choice = simpleDecision("knobs", "pulls");
        
        if (choice == 'y') {
            handle = setComponent(inventory.getKnobs(), "knobs");
        } else {
            handle = setComponent(inventory.getPulls(), "pulls");
        }
        
        return handle;
    }
    
    private String setComponent(List<? extends Components> components, String componentName) {
        int number;
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            displayCategory(components);
            
            do {
                System.out.println("Please, select number of your favourite " + componentName + " to cabinet. \n");
                while (!sc.hasNextInt()) {
                    System.out.println("That's not a number! \n");
                    sc.next();
                }
                number = sc.nextInt();
            }
            
            while (number < 0 || number > components.size());
            
            return components.get(number).getName();
        }
    }
    
    private String getClass(String handle) {
        List<Knobs> knobList = inventory.getKnobs();
        for (Knobs knob : knobList) {
            getClass().getSimpleName();
            if (knob.getName().equals(handle)) {
                return knob.getClass().getSimpleName();
            }
        }
        
        Pulls pull = inventory.getPulls().get(inventory.getPulls().size() - 1);
        return pull.getClass().getSimpleName();
    }
    
    private String setHinge(CabinetType myType, int shelves, String handle, IsFramed framed, IsInset seating) {
        if (myType.equals(CabinetType.C) && shelves == 0) {
            return null;
        }
        
        String hinge = "hinge";
        Style myHandle;
        String falseSeating;
        String falseFrame;
        int aux;
        List<? extends Components> components = inventory.getHinges();
        
        List<Knobs> newKnob;
        List<KnobsAndPulls> newHandle;
        
        if (seating.name().equals("INSET")) {
            falseSeating = "HO";
        } else {
            falseSeating = "IS";
        }
    
        if (framed.name().equals("FL")) {
            falseFrame = "FF";
        } else {
            falseFrame = "FL";
        }
    
        System.out.println(falseSeating + falseFrame);
        
        if (getClass(handle).equals("Knobs")) {
            myHandle = (inventory.getKnobs().get(getIndexByName(handle, inventory.getKnobs()))).getStyle();
        } else {
            myHandle = (inventory.getPulls().get(getIndexByName(handle, inventory.getPulls()))).getStyle();
        }
        
        while (hinge.equals("hinge")) {
            do {
                hinge = setComponent(components, "hinge");
                while (!((Hinge) components.get(getIndexByName(hinge, components))).getStyle().equals(myHandle)) {
                    System.out.println("Does not fit to handle. Please, select another.");
                    hinge = setComponent(components, "hinge");
                }
    
                aux = 0;
                if (hinge.contains(falseFrame)) {
                    aux++;
                }
                if (hinge.contains(falseSeating)) {
                    aux++;
                }
                System.out.println(aux);
            } while (aux != 0);
        }
        
        return hinge;
    }
    
    private int setShelves(CabinetType myType, int verticalSections) {
        float myAux;
        int shelves;
        
        if (myType.name().equals("W")) {
            if (verticalSections == 1 || verticalSections == 11) {
                shelves = 1;
            } else if (verticalSections == 10) {
                shelves = 0;
            } else if (verticalSections == 100) {
                shelves = 6;
            } else {
                shelves = 7;
            }
        } else {
            if (verticalSections < 10) {
                shelves = 0;
            } else {
                shelves = 3;
            }
        }
        return shelves;
    }
    
    private boolean setSlide() {
        boolean slide = false;
        
        System.out.println("Are you interested in having the widest possible drawers?");
        
        char choice = simpleDecision("widest", "does not matter");
        
        if (choice == 'n') {
            slide = true;
        }
        
        return slide;
    }
    
    private char simpleDecision(String message1, String message2) {
        char[] commands = new char[]{'y', 'n'};
        char command = 0;
        boolean stop = false;
        
        try {
            
            while (command == 0) {
                System.out.println("Enter " + commands[0] + " for " + message1 + " or " + commands[1] + " for " + message2);
                
                do {
                    command = (char) System.in.read();
                    for (char com : commands) {
                        if (com == command) {
                            stop = true;
                        }
                    }
                } while (!stop);
            }
        } catch (IOException e) {
            System.out.println("Wrong input");
        }
        return command;
    }
    
    private int getIndexByName(String name, List<? extends Components> components) {
        int index = 0;
        for (Components component : components) {
            if (component.getName().equals(name)) {
                index = components.indexOf(component);
            }
        }
        
        return index;
    }
    
    private void buildCabinet() throws NotEnoughException {
        String[] commands = new String[]{
                "select design (s)",
                "build carcass (c)",
                "build doors (d)",
                "build drawers (r)",
                "assemble (a)",
                "back (b)"
        };
        
        while (true) {
            System.out.println("Enter character in brackets to choose operation.");
            showMenu("Building cabinet Menu", commands);
            String command = getInput();
            
            switch (command) {
                case "s":
                    selectDesign();
                    break;
                case "c":
                    //buildCarcass();
                    break;
                case "d":
                    //buildDoors();
                    break;
                case "r":
                    //buildDrawers();
                    break;
                case "a":
                    //assemble();
                    break;
                case "b":
                    return;
                default:
                    System.out.println("Unknown command " + command + "!");
                    break;
                
                
                //setCabinetDetails();
                //function of cabinet
                //getCarcass
                //isFramed
                //getDrawers
                //getDoors
                //getFeet
            }
        }
    }
    
    private DesignPattern selectDesign() throws NotEnoughException {
        List<DesignPattern> orderedDesign = inventory.getDesigns();
        DesignPattern chosenPattern = null;
        int choice;
        
        if (orderedDesign.size() == 0) {
            throw new NotEnoughException("There is no design available. Please, set new cabinet order.");
        }
        
        while (chosenPattern == null) {
            do {
                System.out.println("Select the number of design.");
                int counter = 1;
                for (DesignPattern singleDesign : orderedDesign) {
                    System.out.println(counter + ") " + singleDesign.getName());
                    counter++;
                }
                choice = Integer.parseInt(getInput());
            } while (choice < 1 || choice > orderedDesign.size());
            
            chosenPattern = orderedDesign.get(choice - 1);
            System.out.println(chosenPattern.getName() + " " + chosenPattern.getMyType() + " " + chosenPattern.getMaterial() + " " + chosenPattern.getFramed() +
                    " " + chosenPattern.getFramed() + " " + chosenPattern.getShelves() + " " + chosenPattern.getVerticalSections() + " " + chosenPattern.getHandle() + " " + chosenPattern.getNumberOfDrawers() + " " + chosenPattern.isSlide());
        }
        return chosenPattern;
    }
    
    private void buildCarcass(DesignPattern chosenDesign) {
        int height;
        int depth;
        int width;
        int thickness;
        List<Wood> stock = new ArrayList<>();
        
        List<Components> components = inventory.getAllComponents();
        
        for (Components component : components) {
            if (component instanceof Wood) {
                stock.add((Wood) component);
            }
        }
        thickness = stock.get(getIndexByName(chosenDesign.getMaterial(), stock)).getThickness();
        
        if (chosenDesign.getMyType() == CabinetType.C) {
            height = Sizes.C.getHeight();
            depth = Sizes.C.getDepth();
            
            if (chosenDesign.getVerticalSections() % 10 == 3) {
                width = 4 * thickness + 3 * Sizes.C.getSectionWidth();
            } else {
                width = 3 * thickness + 2 * Sizes.C.getSectionWidth();
            }
        } else {
            height = Sizes.W.getHeight();
            depth = Sizes.W.getDepth();
            
            if (chosenDesign.getVerticalSections() == 111) {
                width = 4 * thickness + 3 * Sizes.W.getSectionWidth();
            } else if (chosenDesign.getVerticalSections() == 101 || chosenDesign.getVerticalSections() == 11) {
                width = 3 * thickness + 2 * Sizes.W.getSectionWidth();
            } else {
                width = 2 * thickness + Sizes.W.getSectionWidth();
            }
        }
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

