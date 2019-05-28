package com.codecool.api;

import com.codecool.components.*;
import com.codecool.enums.*;
import com.codecool.exceptions.ComponentIsAddedException;
import com.codecool.exceptions.NoComponentException;
import com.codecool.exceptions.NoDesignException;
import com.codecool.exceptions.NotEnoughException;
import com.codecool.parts.Carcass;
import com.codecool.parts.DesignPattern;
import com.codecool.parts.Door;
import com.codecool.parts.Part;

import java.io.*;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Scanner;

public class UserInventory extends Inventory {
    private double money;
    private List<Cabinet> cabinets = new ArrayList<>();
    private List<DesignPattern> orderedCabinets = new ArrayList<>();
    private List<BoughtComponent> boughtComponents = new ArrayList<>();
    private List<Part> myParts = new ArrayList<>();
    private BoughtComponent myComponent;
    public transient AllPrinting invPrint = new AllPrinting();
    
    public UserInventory(int money) {
        this.money = money;
    }
    
    public double getMoney() {
        return money;
    }
    
    public void setMoney(double value) {
        this.money += value;
    }
    
    private void loadedMoney(double money) {
        this.money = money;
    }
    
    private void setCabinets(List<Cabinet> cabinets) {
        this.cabinets = cabinets;
    }
    
    public List<Cabinet> getCabinets() {
        return cabinets;
    }
    
    public List<Part> getMyParts() {
        return myParts;
    }
    
    public void setMyParts(List<Part> myParts) {
        this.myParts = myParts;
    }
    
    private void setBoughtComponents(List<BoughtComponent> boughtComponents) {
        this.boughtComponents = boughtComponents;
    }
    
    public List<BoughtComponent> getBoughtComponents() {
        return boughtComponents;
    }
    
    private void setOrderedCabinets(List<DesignPattern> orderedCabinets) {
        this.orderedCabinets = orderedCabinets;
    }
    
    public List<DesignPattern> getDesigns() {
        return orderedCabinets;
    }
    
    public void addComponent(BoughtComponent boughtComponent) {
        boughtComponents.add(boughtComponent);
    }
    
    private BoughtComponent addComponentByName(String name, int number) throws NotEnoughException, NoComponentException {
        List<BoughtComponent> availableComponents = getBoughtComponents();
        BoughtComponent givenComponent = null;
        int count = 0;
        
        for (int i = 0; i < availableComponents.size(); i++) {
            if (availableComponents.get(i).getName().equals(name)) {
                givenComponent = availableComponents.get(i);
                count = i;
            }
        }
        
        if (givenComponent == null) {
            throw new NoComponentException("There is no such component in stock. Stock up some.");
        } else if (givenComponent.getNumber() < number) {
            throw new NotEnoughException("Not enough on stock. Buy some.");
        } else {
            availableComponents.get(count).manageStock(number);
        }
        
        return givenComponent;
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
    
    private BoughtComponent dimensioning(BoughtComponent selectedWood, int length, int width, String name) {
        Wood rawWood = (Wood) selectedWood.getComponent();
        double unitPrice = rawWood.getValue() / (rawWood.getLength() * rawWood.getWidth());
        
        if (rawWood instanceof Lumber) {
            Lumber newPlank = new Lumber(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (unitPrice * length * width), rawWood.getQualified(), length, width, rawWood.getThickness(), ((Lumber) rawWood).getSpecies());
            Lumber newPlank1 = new Lumber(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (unitPrice * (rawWood.getWidth() - width) * rawWood.getLength()), rawWood.getQualified(), rawWood.getLength(), (rawWood.getWidth() - width), rawWood.getThickness(), ((Lumber) rawWood).getSpecies());
            Lumber newPlank2 = new Lumber(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (rawWood.getValue() - newPlank.getValue() - newPlank1.getValue()), rawWood.getQualified(), (rawWood.getLength() - length), width, rawWood.getThickness(), ((Lumber) rawWood).getSpecies());
    
            if (newPlank1.getLength() >= Sizes.C.getSectionWidth() && newPlank1.getWidth() >= Sizes.C.getDepth() || newPlank1.getLength() >= Sizes.W.getSectionWidth() && newPlank1.getWidth() >= Sizes.W.getDepth()) {
                addComponent(new BoughtComponent(newPlank1.getName(), 1, newPlank1));
            } else newPlank.setValue(-1 * newPlank1.getValue());
    
            if (newPlank2.getLength() >= Sizes.C.getSectionWidth() && newPlank2.getWidth() >= Sizes.C.getDepth() || newPlank2.getLength() >= Sizes.W.getSectionWidth() && newPlank2.getWidth() >= Sizes.W.getDepth()) {
                addComponent(new BoughtComponent(newPlank2.getName(), 1, newPlank2));
            } else newPlank.setValue(-1 * newPlank2.getValue());
            
            return new BoughtComponent(name, 1, newPlank);
            
        } else if (rawWood instanceof ChipBoard) {
            ChipBoard newPlank = new ChipBoard(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (unitPrice * length * width), rawWood.getQualified(), length, width, rawWood.getThickness());
            ChipBoard newPlank1 = new ChipBoard(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (unitPrice * (rawWood.getWidth() - width) * rawWood.getLength()), rawWood.getQualified(), rawWood.getLength(), (rawWood.getWidth() - width), rawWood.getThickness());
            ChipBoard newPlank2 = new ChipBoard(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (rawWood.getValue() - newPlank.getValue() - newPlank1.getValue()), rawWood.getQualified(), (rawWood.getLength() - length), width, rawWood.getThickness());
    
            if (newPlank1.getLength() >= Sizes.C.getSectionWidth() && newPlank1.getWidth() >= Sizes.C.getDepth() || newPlank1.getLength() >= Sizes.W.getSectionWidth() && newPlank1.getWidth() >= Sizes.W.getDepth()) {
                addComponent(new BoughtComponent(newPlank1.getName(), 1, newPlank1));
            } else newPlank.setValue(-1 * newPlank1.getValue());
    
            if (newPlank2.getLength() >= Sizes.C.getSectionWidth() && newPlank2.getWidth() >= Sizes.C.getDepth() || newPlank2.getLength() >= Sizes.W.getSectionWidth() && newPlank2.getWidth() >= Sizes.W.getDepth()) {
                addComponent(new BoughtComponent(newPlank2.getName(), 1, newPlank2));
            } else newPlank.setValue(-1 * newPlank2.getValue());
    
            return new BoughtComponent(name, 1, newPlank);
            
        } else if (rawWood instanceof MDF) {
            MDF newPlank = new MDF(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (unitPrice * length * width), rawWood.getQualified(), length, width, rawWood.getThickness());
            MDF newPlank1 = new MDF(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (unitPrice * (rawWood.getWidth() - width) * rawWood.getLength()), rawWood.getQualified(), rawWood.getLength(), (rawWood.getWidth() - width), rawWood.getThickness());
            MDF newPlank2 = new MDF(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (rawWood.getValue() - newPlank.getValue() - newPlank1.getValue()), rawWood.getQualified(), (rawWood.getLength() - length), width, rawWood.getThickness());
    
            if (newPlank1.getLength() >= Sizes.C.getSectionWidth() && newPlank1.getWidth() >= Sizes.C.getDepth() || newPlank1.getLength() >= Sizes.W.getSectionWidth() && newPlank1.getWidth() >= Sizes.W.getDepth()) {
                addComponent(new BoughtComponent(newPlank1.getName(), 1, newPlank1));
            } else newPlank.setValue(-1 * newPlank1.getValue());
    
            if (newPlank2.getLength() >= Sizes.C.getSectionWidth() && newPlank2.getWidth() >= Sizes.C.getDepth() || newPlank2.getLength() >= Sizes.W.getSectionWidth() && newPlank2.getWidth() >= Sizes.W.getDepth()) {
                addComponent(new BoughtComponent(newPlank2.getName(), 1, newPlank2));
            } else newPlank.setValue(-1 * newPlank2.getValue());
            
            return new BoughtComponent(name, 1, newPlank);
            
        } else if (rawWood instanceof PlyWood) {
            PlyWood newPlank = new PlyWood(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (unitPrice * length * width), rawWood.getQualified(), length, width, rawWood.getThickness());
            PlyWood newPlank1 = new PlyWood(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (unitPrice * (rawWood.getWidth() - width) * rawWood.getLength()), rawWood.getQualified(), rawWood.getLength(), (rawWood.getWidth() - width), rawWood.getThickness());
            PlyWood newPlank2 = new PlyWood(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (rawWood.getValue() - newPlank.getValue() - newPlank1.getValue()), rawWood.getQualified(), (rawWood.getLength() - length), width, rawWood.getThickness());
    
            if (newPlank1.getLength() >= Sizes.C.getSectionWidth() && newPlank1.getWidth() >= Sizes.C.getDepth() || newPlank1.getLength() >= Sizes.W.getSectionWidth() && newPlank1.getWidth() >= Sizes.W.getDepth()) {
                addComponent(new BoughtComponent(newPlank1.getName(), 1, newPlank1));
            } else newPlank.setValue(-1 * newPlank1.getValue());
    
            if (newPlank2.getLength() >= Sizes.C.getSectionWidth() && newPlank2.getWidth() >= Sizes.C.getDepth() || newPlank2.getLength() >= Sizes.W.getSectionWidth() && newPlank2.getWidth() >= Sizes.W.getDepth()) {
                addComponent(new BoughtComponent(newPlank2.getName(), 1, newPlank2));
            } else newPlank.setValue(-1 * newPlank2.getValue());
    
            return new BoughtComponent(name, 1, newPlank);
            
        }
        return null;
    }
    
    public char simpleDecision(String message1, String message2) {
        char[] commands = new char[]{'y', 'n'};
        char command = 0;
        boolean stop = false;
    
        try {
        
            while (command == 0) {
                invPrint.simpleDecisionPrint(commands, message1, message2);
            
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
            invPrint.simpleDisplay("Wrong input");
        }
        return command;
    }
    
    public CabinetType chooseType() {
        CabinetType myType = null;
        String command;
        
        while (myType == null) {
            invPrint.simpleDisplay("Enter type of cabinet you want.");
            String[] commands = new String[]{
                    "wardrobe",
                    "commode"
            };
            do {
                invPrint.showMenu("Cabinet design", commands);
                command = invPrint.getInput();
                for (CabinetType type : EnumSet.allOf(CabinetType.class)) {
                    if (type.getUse().equals(command)) {
                        myType = type;
                    }
                }
            } while (commands.equals(command));
        }
        
        return myType;
    }
    
    public String chooseMaterial() {
        List<Wood> woodMaterial = new ArrayList<>();
        String material = "";
        String command;
        List<String> recommendations = new ArrayList<>();
        String chosen = "";
        
        while (material.equals("")) {
            invPrint.simpleDisplay("Enter material you want your cabinet made by.");
            String[] commands = new String[]{
                    "lumber",
                    "plywood",
                    "chipboard"
            };
            do {
                invPrint.showMenu("Type the name of material you want your cabinet made of", commands);
                command = invPrint.getInput();
                for (String com : commands) {
                    if (com.equals(command)) {
                        material = com;
                    }
                }
            } while (commands.equals(command));
        }
        
        if (material.equals("lumber")) {
            woodMaterial.addAll(getBoards());
        } else if (material.equals("plywood")) {
            woodMaterial.addAll(getPlies());
        } else if (material.equals("chipboard")) {
            woodMaterial.addAll(getChipBoards());
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
                invPrint.simpleDisplay("Please, select number of you want your cabinet made by. \n");
                while (!sc.hasNextInt()) {
                    invPrint.simpleDisplay("That's not a number! \n");
                    sc.next();
                }
                number = sc.nextInt();
            }
            
            while (number < 0 || number > recommendations.size());
            chosen = recommendations.get(number - 1);
        }
        
        return chosen;
    }
    
    public IsFramed setFrame() {
        IsFramed frame;
        invPrint.simpleDisplay("Do you want frameless or face framed design?");
        char choice = simpleDecision("framed", "frameless");
        if (choice == 'y') {
            frame = IsFramed.FF;
        } else {
            frame = IsFramed.FL;
        }
        return frame;
    }
    
    public IsInset setSeating() {
        IsInset seating;
        invPrint.simpleDisplay("Do you want inset doors/drawers or overlaying ones?");
        char choice = simpleDecision("inset", "overlay");
        if (choice == 'y') {
            seating = IsInset.INSET;
        } else {
            seating = IsInset.OVERLAY;
        }
        return seating;
    }
    
    public int setSections(CabinetType myType) {
        int sections = 0;
        if (myType == CabinetType.W) {
            invPrint.simpleDisplay("Select type of clothes you want to store in your wardrobe.");
            invPrint.simpleDisplay("Storing pullovers, panties.");
            if (simpleDecision("yes", "not") == 'y') {
                sections += 100;
            }
            invPrint.simpleDisplay("Storing coats.");
            if (simpleDecision("yes", "not") == 'y') {
                sections += 10;
            }
            invPrint.simpleDisplay("Storing shirts, trousers.");
            if (simpleDecision("yes", "not") == 'y') {
                sections++;
            }
        } else {
            invPrint.simpleDisplay("Do you need a large commode?");
            if (simpleDecision("yes", "not") == 'y') {
                sections = 3;
            } else {
                sections = 2;
            }
    
            invPrint.simpleDisplay("Do you need selves?");
            if (simpleDecision("yes", "not") == 'y') {
                sections += 10;
            }
        }
        
        return sections;
    }
    
    public String setHandle() {
        String handle;
        List<? extends Components> components;
        char choice = simpleDecision("knobs", "pulls");
        
        if (choice == 'y') {
            handle = setComponent(getKnobs(), "knobs");
        } else {
            handle = setComponent(getPulls(), "pulls");
        }
        
        return handle;
    }
    
    public String setComponent(List<? extends Components> components, String componentName) {
        int number = -1;
        Scanner sc = new Scanner(System.in);
    
        while (number < 0 || number > components.size()) {
            invPrint.displayCategory(components);
            
            do {
                invPrint.simpleDisplay("Please, select number of your favourite " + componentName + " to cabinet. \n");
                while (!sc.hasNextInt()) {
                    invPrint.simpleDisplay("That's not a number! \n");
                    sc.next();
                }
                number = sc.nextInt();
            }
            
            while (number < 0 || number > components.size());
            number = sc.nextInt();
        
        }
        return components.get(number).getName();
    }
    
    public int setShelves(CabinetType myType, int verticalSections) {
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
    
    public String getClass(String handle) {
        List<Knobs> knobList = getKnobs();
        for (Knobs knob : knobList) {
            getClass().getSimpleName();
            if (knob.getName().equals(handle)) {
                return knob.getClass().getSimpleName();
            }
        }
        
        Pulls pull = getPulls().get(getPulls().size() - 1);
        return pull.getClass().getSimpleName();
    }
    
    public int getIndexByName(String name, List<? extends Components> components) {
        int index = 0;
        for (Components component : components) {
            if (component.getName().equals(name)) {
                index = components.indexOf(component);
            }
        }
        
        return index;
    }
    
    public String setHinge(CabinetType myType, int shelves, String handle, IsFramed framed, IsInset seating) {
        if (myType.equals(CabinetType.C) && shelves == 0) {
            return null;
        }
        
        String hinge = "hinge";
        Style myHandle;
        String falseSeating;
        String falseFrame;
        int aux;
        List<? extends Components> components = getHinges();
        
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
        
        if (getClass(handle).equals("Knobs")) {
            myHandle = (getKnobs().get(getIndexByName(handle, getKnobs()))).getStyle();
        } else {
            myHandle = (getPulls().get(getIndexByName(handle, getPulls()))).getStyle();
        }
        
        while (hinge.equals("hinge")) {
            do {
                hinge = setComponent(components, "hinge");
                while (!((Hinge) components.get(getIndexByName(hinge, components))).getStyle().equals(myHandle)) {
                    invPrint.simpleDisplay("Does not fit to handle. Please, select another.");
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
    
    public boolean setSlide() {
        boolean slide = false;
    
        invPrint.simpleDisplay("Are you interested in having the widest possible drawers?");
        
        char choice = simpleDecision("widest", "does not matter");
        
        if (choice == 'n') {
            slide = true;
        }
        
        return slide;
    }
    
    public void designCabinet(String name) {
        int numberOfDrawers;
        boolean slide;
        List<DesignPattern> myList = getDesigns();
        
        CabinetType myType = chooseType();
        String material = chooseMaterial();
        IsFramed framed = setFrame();
        IsInset seating = setSeating();
        int verticalSections = setSections(myType);
        int shelves = setShelves(myType, verticalSections);
        String handle = setHandle();
        String hinge = setHinge(myType, shelves, handle, framed, seating);
        
        if (myType.name().equals('W')) {
            numberOfDrawers = 0;
        } else {
            numberOfDrawers = ((verticalSections % 10 - shelves / 3) * 5);
        }
        
        if (myType.equals(CabinetType.W)) {
            slide = false;
        } else {
            slide = setSlide();
        }
        
        addDesign(new DesignPattern(name, myType, material, framed, verticalSections, shelves, handle, hinge, seating, numberOfDrawers, slide));
    }
    
    public BoughtComponent selectWood(String name) {
        List<BoughtComponent> stock = new ArrayList<>();
    
        List<? extends BoughtComponent> components = getBoughtComponents();
        
        components.stream().filter(component -> component.getName().equals(name)).forEach(component -> {
            stock.add(component);
        });
    
    
        int size = components.size();
        int number;
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            invPrint.printStockInfo(stock);
            
            do {
                invPrint.simpleDisplay("Please, select number of the wood you want your part being built. \n");
                while (!sc.hasNextInt()) {
                    invPrint.simpleDisplay("That's not a number! \n");
                    sc.next();
                }
                number = sc.nextInt() - 1;
            }

            while (number < 0 || number >= size);
    
            BoughtComponent myWood = new BoughtComponent(stock.get(number).getName(), 1, stock.get(number).getComponent());
    
            int index = 0;
    
            for (BoughtComponent component : components) {
                //invPrint.printBoughtComponentDetails(component);
                if (stock.get(number).equals(component) && component.getNumber() > 1) {
                    component.manageStock(1);
                } else if (stock.get(number).equals(component) && component.getNumber() == 1) {
                    index = components.indexOf(component);
                }
                //invPrint.printBoughtComponentDetails(component);
            }
    
            if (index != 0) {
                components.remove(components.get(index));
            }
    
            return myWood;
        }
    }
    
    public DesignPattern selectDesign() throws NoDesignException {
        List<DesignPattern> orderedDesign = getDesigns();
        DesignPattern chosenPattern = null;
        int choice;
        
        if (orderedDesign.size() == 0) {
            throw new NoDesignException("There is no design available. Please, set new cabinet order.");
        }
        
        while (chosenPattern == null) {
            do {
                invPrint.simpleDisplay("Select the number of design.");
                int counter = 1;
                for (DesignPattern singleDesign : orderedDesign) {
                    System.out.println(counter + ") " + singleDesign.getName());
                    counter++;
                }
                choice = Integer.parseInt(invPrint.getInput());
            } while (choice < 1 || choice > orderedDesign.size());
            
            chosenPattern = orderedDesign.get(choice - 1);
        }
        return chosenPattern;
    }
    
    public void buildCarcass(DesignPattern chosenDesign) throws NoComponentException, ComponentIsAddedException {
        int height;
        int depth;
        int width;
        int sectionWidth;
        int thickness = 18;
        List<BoughtComponent> partComponents = new ArrayList<>();
        
        int sections = sectionsForBuilding(chosenDesign);
        
        if (chosenDesign.getMyType().equals(CabinetType.C)) {
            height = Sizes.C.getHeight();
            depth = Sizes.C.getDepth();
            sectionWidth = Sizes.C.getSectionWidth();
            width = sections * (thickness + sectionWidth) + thickness;
            
        } else {
            height = Sizes.W.getHeight();
            depth = Sizes.W.getDepth();
            sectionWidth = Sizes.W.getSectionWidth();
            width = sections * (thickness + sectionWidth) + thickness;
        }
        
        prepareSides(2, height, depth, "side", chosenDesign, partComponents);
        prepareSides(2, width - (thickness * (sections - 1)), depth, "end", chosenDesign, partComponents);
        prepareSides(sections - 1, height - 2 * thickness, depth - 6, "divider", chosenDesign, partComponents);
        prepareSides(chosenDesign.getShelves(), sectionWidth, depth - 20, "shelf", chosenDesign, partComponents);
        prepareBack(height - 12, width - 12, partComponents, chosenDesign);
        
        Carcass newCarcass = new Carcass(chosenDesign.getName(), height, width, depth, chosenDesign.getFramed(), partComponents);
        
        myParts.add(newCarcass);
    }
    
    //Only commode door is ready.
    public void buildDoors(DesignPattern chosenDesign) throws NotEnoughException, NoComponentException {
        List<BoughtComponent> partComponents = new ArrayList<>();
        int number = 0;
        String name = "";
        int height = 0;
        int width = 0;
        int handleNumber = 0;
        boolean morticed = false;
        
        if (chosenDesign.getMyType().equals(CabinetType.C) && chosenDesign.getShelves() > 0) {
            setCommodeDoor(chosenDesign, partComponents);
            number = 2;
            handleNumber++;
        }
        BoughtComponent handle = addComponentByName(chosenDesign.getHandle(), handleNumber);
        BoughtComponent hinge = addComponentByName(chosenDesign.getHinge(), number);
        partComponents.add(new BoughtComponent(handle.getName(), handleNumber, handle.getComponent()));
        partComponents.add(new BoughtComponent(hinge.getName(), number, hinge.getComponent()));
        Door newDoor = new Door(partComponents.get(0).getName(), height, width, morticed, partComponents);
        
        if (((Hinge) hinge.getComponent()).getMount().equals(IsRecess.MM.getMount())) {
            morticed = newDoor.setMorticed();
        }
        
        myParts.add(newDoor);
    }
    
    private int sectionsForBuilding(DesignPattern chosenDesign) {
        int sections = 0;
        int dsections = chosenDesign.getVerticalSections();
        
        if (dsections == 111 || dsections % 10 == 3) {
            sections = 3;
        } else if (dsections == 1 || dsections == 10 || dsections == 100) {
            sections = 1;
        } else {
            sections = 2;
        }
        
        return sections;
    }
    
    private List<BoughtComponent> prepareSides(int j, int length, int width, String name, DesignPattern chosenDesign, List<BoughtComponent> partComponents) {
    
        for (int i = 0; i < j; i++) {
            invPrint.simpleDisplay("\n Please, select wood for preparing " + name + "\n");
            BoughtComponent myWood = selectWood(chosenDesign.getMaterial());
            myComponent = dimensioning(myWood, length, width, name);
            int number = 0;
            if (partComponents.size() == 0) {
                partComponents.add(myComponent);
            } else if (partComponents.size() == 1) {
                if (partComponents.get(0).getName().equals(myComponent.getName())) {
                    partComponents.get(0).manageStock(-1);
                } else {
                    partComponents.add(myComponent);
                }
            } else if (partComponents.size() > 1) {
                if (partComponents.get(partComponents.size() - 1).getName().equals(myComponent.getName())) {
                    partComponents.get(partComponents.size() - 1).manageStock(-1);
                } else {
                    partComponents.add(myComponent);
                }
            }
    
        }
        
        return partComponents;
    }
    
    //Stock management does not work!!! To be completed.
    private void prepareBack(int height, int width, List<BoughtComponent> partComponents, DesignPattern chosenDesign) throws NoComponentException, ComponentIsAddedException {
        int sections = sectionsForBuilding(chosenDesign);
        int numberOfBackParts = 1;
        int number = 0;
        BoughtComponent myWood = null;
        
        if (sections == 3) {
            numberOfBackParts = 3;
            width = width / 3;
        }
        
        for (int i = 1; i <= numberOfBackParts; i++) {
            myWood = selectWoodForInners(6, height, width);
            
            if (((PlyWood) myWood.getComponent()).getLength() < height || ((PlyWood) myWood.getComponent()).getWidth() < width) {
                throw new NoComponentException("Wrong selection. Choose another.");
            }
            
            myComponent = dimensioning(myWood, height, width, "back");
        }
        
        if (numberOfBackParts == 3) {
            ((PlyWood) myComponent.getComponent()).newWidth(width * 3);
        }
        
        
        for (BoughtComponent component : partComponents) {
            if (component.getName().equals(myComponent.getName())) {
                throw new ComponentIsAddedException("This component is already installed!");
            } else {
                number++;
            }
        }
        
        if (number != 0) {
            partComponents.add(myComponent);
            myWood.manageStock(1);
        }
    }
    
    private BoughtComponent selectWoodForInners(int thickness, int height, int width) throws NoComponentException {
        BoughtComponent myWood = null;
        List<BoughtComponent> components = getBoughtComponents();
        List<BoughtComponent> plies = new ArrayList<>();
        
        for (int i = components.size(); i-- > 0; ) {
            if (components.get(i).getComponent() instanceof PlyWood && ((PlyWood) components.get(i).getComponent()).getThickness() == thickness && ((PlyWood) components.get(i).getComponent()).getLength() >= height && ((PlyWood) components.get(i).getComponent()).getWidth() >= width) {
                return components.get(i);
            }
        }
        
        if (myWood == null) {
            throw new NoComponentException("No stock of such wood. Buy some.");
        }
        
        return myWood;
    }
    
    private List<BoughtComponent> setCommodeDoor(DesignPattern chosenDesign, List<BoughtComponent> partComponents) {
        String name = "";
        int height = 0;
        int width = 0;
        
        if (chosenDesign.getSeating() == IsInset.INSET && chosenDesign.getFramed().equals(IsFramed.FL)) {
            name = "doorCIFL";
            height = Sizes.C.getHeight() - 36;
            width = Sizes.C.getSectionWidth();
        } else if (chosenDesign.getSeating() == IsInset.INSET && chosenDesign.getFramed().equals(IsFramed.FF)) {
            name = "doorCIFF";
            height = Sizes.C.getHeight() - 80;
            width = Sizes.C.getSectionWidth() - 22;
        } else if (chosenDesign.getSeating() == IsInset.OVERLAY && chosenDesign.getFramed().equals(IsFramed.FL)) {
            name = "doorCOFL";
            height = Sizes.C.getHeight() - 24;
            width = Sizes.C.getSectionWidth() + 12;
        } else if (chosenDesign.getSeating() == IsInset.OVERLAY && chosenDesign.getFramed().equals(IsFramed.FF)) {
            name = "doorCOFF";
            height = Sizes.C.getHeight() - 68;
            width = Sizes.C.getSectionWidth() - 10;
        }
        
        return prepareSides(1, height, width, name, chosenDesign, partComponents);
    }
    
    private double calculateCost(Part myPart, double cost) {
        List<BoughtComponent> assembly = myPart.getAssembly();
        
        for (BoughtComponent component : assembly) {
            cost += component.getNumber() * component.getComponent().getValue();
        }
        
        return cost;
    }
    
    public void saveInventory() throws IOException {
        FileOutputStream foS = new FileOutputStream("cabinet-shop.ser");
        ObjectOutputStream ooS = new ObjectOutputStream(foS);
        ooS.writeDouble(money);
        ooS.writeObject(cabinets);
        ooS.writeObject(orderedCabinets);
        ooS.writeObject(boughtComponents);
        ooS.writeObject(myParts);
        ooS.flush();
        foS.close();
        ooS.close();
    }
    
    public void loadInventory() {
        try {
            FileInputStream fileIn = new FileInputStream("cabinet-shop.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            double money = (double) in.readDouble();
            List<Cabinet> cabinets = (List<Cabinet>) in.readObject();
            List<DesignPattern> orderedCabinets = (List<DesignPattern>) in.readObject();
            List<BoughtComponent> boughtComponents = (List<BoughtComponent>) in.readObject();
            List<Part> myParts = (List<Part>) in.readObject();
            loadedMoney(money);
            setCabinets(cabinets);
            setOrderedCabinets(orderedCabinets);
            setBoughtComponents(boughtComponents);
            setMyParts(myParts);
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            invPrint.simpleDisplay("Load failed, starting new cabinet shop!");
        }
    }
}