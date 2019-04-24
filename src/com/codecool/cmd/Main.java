package com.codecool.cmd;

import com.codecool.exceptions.noMatchException;
import com.codecool.exceptions.noMoneyException;
import com.codecool.exceptions.outOfStockException;

public class Main {
    
    public static void main(String[] args) throws outOfStockException, noMatchException, noMoneyException {
        new CmdMenu().start();
    }
}
