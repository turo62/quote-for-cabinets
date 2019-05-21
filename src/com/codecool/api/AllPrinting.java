package com.codecool.api;

import com.codecool.components.BoughtComponent;
import com.codecool.components.Components;

import java.util.List;
import java.util.Scanner;

public class AllPrinting {
    private Scanner userInput = new Scanner(System.in);
    
    public String getInput() {
        String input = userInput.nextLine().toLowerCase();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>o<<<<<<<<<<<<<<<<<<<<<<<<<");
        return input;
    }
    
    public void showMenu(String title, String[] commands) {
        System.out.println("\n" + title + "\n");
        System.out.print("Commands  | ");
        for (String command : commands) {
            System.out.print(command + " | ");
        }
        System.out.println("\n Enter the character in brackets to choose then <Enter>.");
        System.out.println("\n");
    }
    
    public void simpleDecisionPrint(char[] commands, String message1, String message2) {
        System.out.println("Enter " + commands[0] + " for " + message1 + " or " + commands[1] + " for " + message2);
    }
    
    public void simpleDisplay(String text) {
        System.out.println(text);
    }
    
    public void displayCategory(List<? extends Components> components) {
        if (components.size() == 0) {
            simpleDisplay("\n No items!");
            return;
        }
        
        int count = 0;
        for (int i = 0; i < components.size(); i++) {
            if (i == 0 || i > 0 && !components.get(i - 1).getClass().equals(components.get(i).getClass())) {
                System.out.println("\n" + components.get(i).getClass().getSimpleName() + ":");
            }
            System.out.println(count + ") " + components.get(i).toString());
            count++;
        }
    }
    
    public void printStockInfo(List<? extends BoughtComponent> stock) {
        int count = 1;
        for (BoughtComponent boughtComponent : stock) {
            System.out.println(count + ")  " + boughtComponent.getComponent().details());
            count++;
        }
    }
    
    public void printBoughtComponent(List<BoughtComponent> myBoughtStock) {
        int count = 1;
        for (BoughtComponent boughtComponent : myBoughtStock) {
            System.out.println(count + ") " + boughtComponent.getNumber() + " pcs " + boughtComponent.getComponent().details());
        }
    }
    
    public void printBoughtComponentDetails(BoughtComponent component) {
        System.out.println(component.getName() + " , " + component.getNumber());
    }
}