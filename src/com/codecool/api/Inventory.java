package com.codecool.api;

import com.codecool.components.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Inventory implements java.io.Serializable {
    private List<Lumber> boards;
    private List<ChipBoard> chipBoards;
    private List<MDF> MDFs;
    private List<PlyWood> plies;
    private List<Glue> glues;
    private List<Dowel> dowels;
    private List<PocketHoleScrew> pocketHoleScrews;
    private List<WoodScrew> screws;
    private List<Slides> slides;
    private List<Hinge> hinges;
    private List<Pulls> pulls;
    private List<Knobs> knobs;
    private static XMLLoader xmlLoader = new XMLLoader();
    
    public Inventory(List<Lumber> boards,
                     List<ChipBoard> chipBoards,
                     List<MDF> MDFs,
                     List<PlyWood> plies,
                     List<Glue> glues,
                     List<Dowel> dowels,
                     List<PocketHoleScrew> pocketHoleScrews,
                     List<WoodScrew> screws,
                     List<Slides> slides,
                     List<Hinge> hinges,
                     List<Pulls> pulls,
                     List<Knobs> knobs) {
        this.boards = boards;
        this.chipBoards = chipBoards;
        this.MDFs = MDFs;
        this.plies = plies;
        this.glues = glues;
        this.dowels = dowels;
        this.pocketHoleScrews = pocketHoleScrews;
        this.screws = screws;
        this.slides = slides;
        this.hinges = hinges;
        this.pulls = pulls;
        this.knobs = knobs;
        
    }
    
    public Inventory() {
        this.boards = xmlLoader.getLumbers();
        this.chipBoards = xmlLoader.getChipBoards();
        this.MDFs = xmlLoader.getMDFs();
        this.plies = xmlLoader.getPlyWoods();
        this.glues = xmlLoader.getGlues();
        this.dowels = xmlLoader.getDowels();
        this.pocketHoleScrews = xmlLoader.getPocketHoleScrews();
        this.screws = xmlLoader.getWoodscrews();
        this.slides = xmlLoader.getSlides();
        this.hinges = xmlLoader.getHinges();
        this.pulls = xmlLoader.getPulls();
        this.knobs = xmlLoader.getKnobs();
    }
    
    public List<Components> getAllComponents() {
        List<Components> result = new ArrayList<>();
        
        result.addAll(boards);
        result.addAll(chipBoards);
        result.addAll(MDFs);
        result.addAll(plies);
        result.addAll(glues);
        result.addAll(dowels);
        result.addAll(pocketHoleScrews);
        result.addAll(screws);
        result.addAll(slides);
        result.addAll(hinges);
        result.addAll(pulls);
        result.addAll(knobs);
        
        return result;
    }
    
    public List<Lumber> getBoards() {
        return boards;
    }
    
    public List<ChipBoard> getChipBoards() {
        return chipBoards;
    }
    
    public List<MDF> getMDFs() {
        return MDFs;
    }
    
    public List<PlyWood> getPlies() {
        return plies;
    }
    
    public List<Glue> getGlues() {
        return glues;
    }
    
    public List<Dowel> getDowels() {
        return dowels;
    }
    
    public List<PocketHoleScrew> getPocketHoleScrews() {
        return pocketHoleScrews;
    }
    
    public List<WoodScrew> getScrews() {
        return screws;
    }
    
    public List<Slides> getSlides() {
        return slides;
    }
    
    public List<Hinge> getHinges() {
        return hinges;
    }
    
    public List<Pulls> getPulls() {
        return pulls;
    }
    
    public List<Knobs> getKnobs() {
        return knobs;
    }
    
    public Components getComponentByName(String name) {
        List<Components> fullList = getAllComponents();
        for (Components component : fullList) {
            if (component.getName().equals(name)) {
                return component;
            }
        }
        return null;
    }
    
    public void addItem(Components component) {
        if (component instanceof Lumber) {
            boards.add((Lumber) component);
        } else if (component instanceof ChipBoard) {
            chipBoards.add((ChipBoard) component);
        } else if (component instanceof MDF) {
            MDFs.add((MDF) component);
        } else if (component instanceof PlyWood) {
            plies.add((PlyWood) component);
        } else if (component instanceof Glue) {
            glues.add((Glue) component);
        } else if (component instanceof Dowel) {
            dowels.add((Dowel) component);
        } else if (component instanceof PocketHoleScrew) {
            pocketHoleScrews.add((PocketHoleScrew) component);
        } else if (component instanceof WoodScrew) {
            screws.add((WoodScrew) component);
        } else if (component instanceof Slides) {
            slides.add((Slides) component);
        } else if (component instanceof Hinge) {
            hinges.add((Hinge) component);
        } else if (component instanceof Pulls) {
            pulls.add((Pulls) component);
        } else if (component instanceof Knobs) {
            knobs.add((Knobs) component);
        }
    }
    
    public void removeItem(Components component) {
        if (component instanceof Lumber) {
            boards.remove(component);
        } else if (component instanceof ChipBoard) {
            chipBoards.remove(component);
        } else if (component instanceof MDF) {
            MDFs.remove(component);
        } else if (component instanceof PlyWood) {
            plies.remove(component);
        } else if (component instanceof Glue) {
            glues.remove(component);
        } else if (component instanceof Dowel) {
            dowels.remove(component);
        } else if (component instanceof PocketHoleScrew) {
            pocketHoleScrews.remove(component);
        } else if (component instanceof WoodScrew) {
            screws.remove(component);
        } else if (component instanceof Slides) {
            slides.remove(component);
        } else if (component instanceof Hinge) {
            hinges.remove(component);
        } else if (component instanceof Pulls) {
            pulls.remove(component);
        } else if (component instanceof Knobs) {
            knobs.remove(component);
        }
    }
}
