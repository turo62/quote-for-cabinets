package com.codecool.api;

import com.codecool.components.*;
import com.codecool.enums.*;
import com.codecool.exceptions.NoDesignException;
import com.codecool.parts.Carcass;
import com.codecool.parts.DesignPattern;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Scanner;

public class UserInventory extends Inventory {
    private double money;
    private PlyWood genericPly;
    private List<Cabinet> cabinets = new ArrayList<>();
    private Carcass myCarcass;
    private List<DesignPattern> orderedCabinets = new ArrayList<>();
    private List<BoughtComponent> boughtComponents = new ArrayList<>();
    private BoughtComponent myComponent;
    public AllPrinting invPrint = new AllPrinting();
    
    public UserInventory(int money) {
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
    
    public void addComponent(BoughtComponent boughtComponent) {
        boughtComponents.add(boughtComponent);
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
    
            if (newPlank1.getLength() > Sizes.C.getSectionWidth() && newPlank1.getWidth() > Sizes.C.getDepth() || newPlank1.getLength() > Sizes.W.getSectionWidth() && newPlank1.getWidth() > Sizes.W.getDepth()) {
                addComponent(new BoughtComponent(newPlank1.getName(), 1, newPlank1));
            } else newPlank.setValue(-1 * newPlank1.getValue());
    
            if (newPlank2.getLength() > Sizes.C.getSectionWidth() && newPlank2.getWidth() > Sizes.C.getDepth() || newPlank2.getLength() > Sizes.W.getSectionWidth() && newPlank2.getWidth() > Sizes.W.getDepth()) {
                addComponent(new BoughtComponent(newPlank2.getName(), 1, newPlank2));
            } else newPlank.setValue(-1 * newPlank2.getValue());
            
            return new BoughtComponent(name, 1, newPlank);
            
        } else if (rawWood instanceof ChipBoard) {
            ChipBoard newPlank = new ChipBoard(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (unitPrice * length * width), rawWood.getQualified(), length, width, rawWood.getThickness());
            ChipBoard newPlank1 = new ChipBoard(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (unitPrice * (rawWood.getWidth() - width) * rawWood.getLength()), rawWood.getQualified(), rawWood.getLength(), (rawWood.getWidth() - width), rawWood.getThickness());
            ChipBoard newPlank2 = new ChipBoard(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (rawWood.getValue() - newPlank.getValue() - newPlank1.getValue()), rawWood.getQualified(), (rawWood.getLength() - length), width, rawWood.getThickness());
    
            if (newPlank1.getLength() > Sizes.C.getSectionWidth() && newPlank1.getWidth() > Sizes.C.getDepth() || newPlank1.getLength() > Sizes.W.getSectionWidth() && newPlank1.getWidth() > Sizes.W.getDepth()) {
                addComponent(new BoughtComponent(newPlank1.getName(), 1, newPlank1));
            } else newPlank.setValue(-1 * newPlank1.getValue());
    
            if (newPlank2.getLength() > Sizes.C.getSectionWidth() && newPlank2.getWidth() > Sizes.C.getDepth() || newPlank2.getLength() > Sizes.W.getSectionWidth() && newPlank2.getWidth() > Sizes.W.getDepth()) {
                addComponent(new BoughtComponent(newPlank2.getName(), 1, newPlank2));
            } else newPlank.setValue(-1 * newPlank2.getValue());
    
            return new BoughtComponent(name, 1, newPlank);
            
        } else if (rawWood instanceof MDF) {
            MDF newPlank = new MDF(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (unitPrice * length * width), rawWood.getQualified(), length, width, rawWood.getThickness());
            MDF newPlank1 = new MDF(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (unitPrice * (rawWood.getWidth() - width) * rawWood.getLength()), rawWood.getQualified(), rawWood.getLength(), (rawWood.getWidth() - width), rawWood.getThickness());
            MDF newPlank2 = new MDF(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (rawWood.getValue() - newPlank.getValue() - newPlank1.getValue()), rawWood.getQualified(), (rawWood.getLength() - length), width, rawWood.getThickness());
    
            if (newPlank1.getLength() > Sizes.C.getSectionWidth() && newPlank1.getWidth() > Sizes.C.getDepth() || newPlank1.getLength() > Sizes.W.getSectionWidth() && newPlank1.getWidth() > Sizes.W.getDepth()) {
                addComponent(new BoughtComponent(newPlank1.getName(), 1, newPlank1));
            } else newPlank.setValue(-1 * newPlank1.getValue());
    
            if (newPlank2.getLength() > Sizes.C.getSectionWidth() && newPlank2.getWidth() > Sizes.C.getDepth() || newPlank2.getLength() > Sizes.W.getSectionWidth() && newPlank2.getWidth() > Sizes.W.getDepth()) {
                addComponent(new BoughtComponent(newPlank2.getName(), 1, newPlank2));
            } else newPlank.setValue(-1 * newPlank2.getValue());
            
            return new BoughtComponent(name, 1, newPlank);
            
        } else if (rawWood instanceof PlyWood) {
            PlyWood newPlank = new PlyWood(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (unitPrice * length * width), rawWood.getQualified(), length, width, rawWood.getThickness());
            PlyWood newPlank1 = new PlyWood(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (unitPrice * (rawWood.getWidth() - width) * rawWood.getLength()), rawWood.getQualified(), rawWood.getLength(), (rawWood.getWidth() - width), rawWood.getThickness());
            PlyWood newPlank2 = new PlyWood(rawWood.getName(), rawWood.getProducer(), rawWood.getLoad(), (rawWood.getValue() - newPlank.getValue() - newPlank1.getValue()), rawWood.getQualified(), (rawWood.getLength() - length), width, rawWood.getThickness());
    
            if (newPlank1.getLength() > Sizes.C.getSectionWidth() && newPlank1.getWidth() > Sizes.C.getDepth() || newPlank1.getLength() > Sizes.W.getSectionWidth() && newPlank1.getWidth() > Sizes.W.getDepth()) {
                addComponent(new BoughtComponent(newPlank1.getName(), 1, newPlank1));
            } else newPlank.setValue(-1 * newPlank1.getValue());
    
            if (newPlank2.getLength() > Sizes.C.getSectionWidth() && newPlank2.getWidth() > Sizes.C.getDepth() || newPlank2.getLength() > Sizes.W.getSectionWidth() && newPlank2.getWidth() > Sizes.W.getDepth()) {
                addComponent(new BoughtComponent(newPlank2.getName(), 1, newPlank2));
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
            System.out.println("Wrong input");
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
                System.out.println("Please, select number of you want your cabinet made by. \n");
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
        System.out.println("Do you want frameless or face framed design?");
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
        
        System.out.println(falseSeating + falseFrame);
        
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
    
    public void designCabinet() {
        invPrint.simpleDisplay("Enter name of the cabinet: \n");
        String name = invPrint.getInput();
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
        System.out.println(getClass(handle));
        
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

            while (number < 0 || number >= components.size());
    
            BoughtComponent myWood = new BoughtComponent(stock.get(number).getName(), 1, stock.get(number).getComponent());
    
            int index = 0;
    
            for (BoughtComponent component : components) {
                invPrint.printBoughtComponentDetails(component);
                if (stock.get(number).equals(component) && component.getNumber() > 1) {
                    component.manageStock(1);
                } else if (stock.get(number).equals(component) && component.getNumber() == 1) {
                    index = components.indexOf(component);
                }
                invPrint.printBoughtComponentDetails(component);
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
            System.out.println(chosenPattern.getName() + " " + chosenPattern.getMyType() + " " + chosenPattern.getMaterial() + " " + chosenPattern.getFramed() +
                    " " + chosenPattern.getSeating() + " " + chosenPattern.getShelves() + " " + chosenPattern.getVerticalSections() + " " + chosenPattern.getHandle() + " " + chosenPattern.getNumberOfDrawers() + " " + chosenPattern.isSlide());
        }
        return chosenPattern;
    }
    
    public void buildCarcass(DesignPattern chosenDesign) {
        int height;
        int depth;
        int width;
        int thickness = 18;
        int sections = 0;
        int dsections = chosenDesign.getVerticalSections();
        List<BoughtComponent> carcassList = new ArrayList<>();
        
        while (dsections > 0) {
            sections = sections + dsections % 10;
            dsections = dsections / 10;
        }
        System.out.println(chosenDesign.getMyType() + CabinetType.C.toString());
        if (chosenDesign.getMyType().equals(CabinetType.C)) {
            height = Sizes.C.getHeight();
            depth = Sizes.C.getDepth();
            width = sections * (thickness + Sizes.C.getSectionWidth()) + thickness;
            
        } else {
            height = Sizes.W.getHeight();
            depth = Sizes.W.getDepth();
            width = sections * (thickness + Sizes.W.getSectionWidth()) + thickness;
        }
        prepareSides(2, height, depth, "side", chosenDesign, carcassList);
        prepareSides(2, width - (thickness * (sections - 1)), depth, "end", chosenDesign, carcassList);
        prepareSides(sections - 1, height - 2 * thickness, depth - 6, "divider", chosenDesign, carcassList);
        Carcass newCarcass = new Carcass(chosenDesign.getName(), height, width, depth, chosenDesign.getFramed(), carcassList);
        prepareBack(height - 12, width - 12);
    }
    
    private List<BoughtComponent> prepareSides(int j, int length, int width, String name, DesignPattern chosenDesign, List<BoughtComponent> carcassList) {
    
    
        for (int i = 0; i < j; i++) {
            invPrint.simpleDisplay("\n Please, select wood for preparing " + name + "\n");
            BoughtComponent myWood = selectWood(chosenDesign.getMaterial());
            myComponent = dimensioning(myWood, length, width, name);
            System.out.println(myComponent.getComponent().details());
            for (BoughtComponent component : carcassList) {
                if (component.getName().equals(myComponent.getName())) {
                    component.manageStock(-1);
                } else {
                    carcassList.add(myComponent);
                }
            }
        }
        
        return carcassList;
    }
    
    private void prepareBack(int heigth, int width) {
        List<BoughtComponent> myStock = getBoughtComponents();
        List<BoughtComponent> woodForBack = new ArrayList<>();
        
        for (BoughtComponent component : myStock) {
            if (component.getComponent() instanceof PlyWood) {
                if (((PlyWood) component.getComponent()).getThickness() == 6) {
                    woodForBack.add(component);
                }
            }
        }
        invPrint.printBoughtComponent(woodForBack);
        invPrint.simpleDisplay("Please, select wood for back.");
        int choice = Integer.parseInt(invPrint.getInput());
    }
}