package com.codecool.cmd;

import com.codecool.exceptions.NoMoneyException;
import com.codecool.exceptions.OutOfStockException;

public class Main {
    
    public static void main(String[] args) {
        CmdMenu myMenu = new CmdMenu();
        try {
            myMenu.start();
        } catch (NoMoneyException e) {
            e.printStackTrace();
        } catch (OutOfStockException e) {
            e.printStackTrace();
        }
    }
}
