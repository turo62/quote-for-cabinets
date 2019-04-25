package com.codecool.cmd;

import com.codecool.exceptions.NoMatchException;
import com.codecool.exceptions.NoMoneyException;
import com.codecool.exceptions.OutOfStockException;

public class Main {
    
    public static void main(String[] args) {
        try {
            new CmdMenu().start();
        } catch (NoMatchException e) {
            e.printStackTrace();
        } catch (OutOfStockException e) {
            e.printStackTrace();
        } catch (NoMoneyException e) {
            e.printStackTrace();
        }
    }
}
