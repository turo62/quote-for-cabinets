package com.codecool.cmd;

import com.codecool.exceptions.NotEnoughException;

public class Main {
    
    public static void main(String[] args) {
        CmdMenu myMenu = new CmdMenu();
        try {
            myMenu.start();
        } catch (NotEnoughException e) {
            e.printStackTrace();
        }
    }
}
