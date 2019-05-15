package com.codecool.cmd;

import com.codecool.api.*;
import com.codecool.components.*;
import com.codecool.enums.*;
import com.codecool.exceptions.NoDesignException;
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
    private String currentType;
    private BoughtComponent boughtComponent;
    private DesignPattern designDetails;
    private DisplayStore allPrinting;
    private UserInventory inventory = new UserInventory();
    
    CmdMenu() {
        if (new File(savePath).exists()) {
            load();
        } else {
            System.out.println("New shop started!");
            System.out.println("please, enter value yu can spend on shop.");
            double input = Double.parseDouble(getInput());
            inventory.setMoney(input);
        }
    }
    
    void start() throws NotEnoughException, NoDesignException {
        String[] commands = new String[]{
                "store (s)",
                "cabinets (c)",
                "inventory (i)",
                "help (h)",
                "exit (e)"
        };
        
        while (true) {
            allPrinting.showMenu("Main Menu", commands);
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
                "buy (u)",
                "sell (s)",
                "back (b)"
        };
        
        while (true) {
            allPrinting.showMenu("Store Menu", commands);
            String command = getInput();
            
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
    
    private void cabinetMenu() throws NotEnoughException, NoDesignException {
        String[] commands = new String[]{
                "display all (a)",
                "list components (c)",
                "design (d)",
                "build (u)",
                "modify (m)",
                "back (b)"
        };
        
        while (true) {
            allPrinting.showMenu("Cabinet Menu", commands);
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
            allPrinting.showMenu("Inventory Menu", commands);
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
    
    private String getInput() {
        String input = userInput.nextLine().toLowerCase();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>o<<<<<<<<<<<<<<<<<<<<<<<<<");
        return input;
    }
    
    private void listAll() {
        List<? extends Components> components = inventory.getAllComponents();
        allPrinting.displayCategory(components);
    }
    
    private List<? extends Components> chooseComponent(Inventory inventory) {
        List<? extends Components> componentList = null;
        allPrinting.listCategories(inventory);
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
    
    private void listCategory(Inventory inventory) {
        List<? extends Components> componentList = chooseComponent(inventory);
        allPrinting.displayCategory(componentList);
    }
    
    private void shopping() throws NotEnoughException {
        List<BoughtComponent> stock;
        System.out.println("Do you want to buy hardware (y) or lumbers/men made sheets (n)? \n");
        String input = getInput();
        stock = loadStock(input);
        allPrinting.printStockInfo(stock);
        buyingComponents(stock);
        allPrinting.printBoughtStock();
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
                allPrinting.showMenu("Cabinet design", commands);
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
                allPrinting.showMenu("Enter the kind of material", commands);
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
            allPrinting.displayCategory(components);
            
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
    
    private void buildCabinet() throws NotEnoughException, NoDesignException {
        
        DesignPattern chosenDesign = selectDesign();
        buildCarcass(chosenDesign);
                    
    }
    
    private DesignPattern selectDesign() throws NoDesignException {
        List<DesignPattern> orderedDesign = inventory.getDesigns();
        DesignPattern chosenPattern = null;
        int choice;
        
        if (orderedDesign.size() == 0) {
            throw new NoDesignException("There is no design available. Please, set new cabinet order.");
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
        int thickness = 18;
        int sections = 0;
        int dsections = chosenDesign.getVerticalSections();
    
        while (dsections > 0) {
            sections = sections + dsections % 10;
            dsections = dsections / 10;
        }
        
        if (chosenDesign.getMyType() == CabinetType.C) {
            height = Sizes.C.getHeight();
            depth = Sizes.C.getDepth();
            width = sections * (thickness + Sizes.C.getSectionWidth()) + thickness;
            
        } else {
            height = Sizes.W.getHeight();
            depth = Sizes.W.getDepth();
            width = sections * (thickness + Sizes.W.getSectionWidth()) + thickness;
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

