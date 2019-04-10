package com.codecool.cmd;

import com.codecool.operations.Inventory;

public class Store extends Inventory {
    
    private static XMLLoader xmlLoader = new XMLLoader();
    
    public Store() {
        super(
                xmlLoader.getLumbers(),
                xmlLoader.getChipBoards(),
                xmlLoader.getMDFs(),
                xmlLoader.getPlyWoods(),
                xmlLoader.getGlues(),
                xmlLoader.getDowels(),
                xmlLoader.getPocketHoleScrews(),
                xmlLoader.getWoodscrews(),
                xmlLoader.getSlides(),
                xmlLoader.getHinges(),
                xmlLoader.getPulls(),
                xmlLoader.getKnobs());
    }
}
