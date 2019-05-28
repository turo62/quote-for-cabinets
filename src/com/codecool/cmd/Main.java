package com.codecool.cmd;

import com.codecool.exceptions.*;

public class Main {
    
    public static void main(String[] args) {
        CmdMenu myMenu = new CmdMenu();
        try {
            myMenu.start();
        } catch (NotEnoughException e) {
            e.printStackTrace();
        } catch (NoDesignException e) {
            e.printStackTrace();
        } catch (NoSuchOptionException e) {
            e.printStackTrace();
        } catch (NoComponentException e) {
            e.printStackTrace();
        } catch (ComponentIsAddedException e) {
            e.printStackTrace();
        }
    }
}
