package com.codecool.cmd;

import com.codecool.components.*;
import com.codecool.enums.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

class XMLLoader {
    private Element components;
    private Document d;
    
    XMLLoader() {
        try {
            InputStream is = new FileInputStream("components.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            this.d = db.parse(is);
            this.d.getDocumentElement().normalize();
            components = (Element) d.getElementsByTagName("Components").item(0);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    List<Lumber> getLumbers() {
        Element lumbersElement = (Element) components.getElementsByTagName("Lumbers").item(0);
        NodeList lumbers = lumbersElement.getElementsByTagName("Lumber");
        List<Lumber> result = new ArrayList<>();
        Element current;
        for (int i = 0; i < lumbers.getLength(); i++) {
            current = (Element) lumbers.item(i);
            result.add(new Lumber(current.getAttribute("name"),
                    current.getAttribute("producer"),
                    Load.valueOf(current.getAttribute("load")),
                    Integer.parseInt(current.getAttribute("value")),
                    AreaToUse.valueOf(current.getAttribute("qualified")),
                    Integer.parseInt(current.getAttribute("length")),
                    Integer.parseInt(current.getAttribute("width")),
                    Integer.parseInt(current.getAttribute("thickness")),
                    current.getAttribute("species")));
        }
        return result;
    }
    
    List<ChipBoard> getChipBoards() {
        Element chipBoardsElement = (Element) components.getElementsByTagName("ChipBoards").item(0);
        NodeList chipboards = chipBoardsElement.getElementsByTagName("Chipboard");
        List<ChipBoard> result = new ArrayList<>();
        Element current;
        for (int i = 0; i < chipboards.getLength(); i++) {
            current = (Element) chipboards.item(i);
            result.add(new ChipBoard(current.getAttribute("name"),
                    current.getAttribute("producer"),
                    Load.valueOf(current.getAttribute("load")),
                    Integer.parseInt(current.getAttribute("value")),
                    AreaToUse.valueOf(current.getAttribute("qualified")),
                    Integer.parseInt(current.getAttribute("length")),
                    Integer.parseInt(current.getAttribute("width")),
                    Integer.parseInt(current.getAttribute("thickness"))));
        }
        return result;
    }
    
    List<MDF> getMDFs() {
        Element MDFsElement = (Element) components.getElementsByTagName("MDFs").item(0);
        NodeList MDFs = MDFsElement.getElementsByTagName("MDF");
        List<MDF> result = new ArrayList<>();
        Element current;
        for (int i = 0; i < MDFs.getLength(); i++) {
            current = (Element) MDFs.item(i);
            result.add(new MDF(current.getAttribute("name"),
                    current.getAttribute("producer"),
                    Load.valueOf(current.getAttribute("load")),
                    Integer.parseInt(current.getAttribute("value")),
                    AreaToUse.valueOf(current.getAttribute("qualified")),
                    Integer.parseInt(current.getAttribute("length")),
                    Integer.parseInt(current.getAttribute("width")),
                    Integer.parseInt(current.getAttribute("thickness"))));
        }
        return result;
    }
    
    List<PlyWood> getPlyWoods() {
        Element plyWoodsElement = (Element) components.getElementsByTagName("PlyWoods").item(0);
        NodeList plyWoods = plyWoodsElement.getElementsByTagName("PlyWood");
        List<PlyWood> result = new ArrayList<>();
        Element current;
        for (int i = 0; i < plyWoods.getLength(); i++) {
            current = (Element) plyWoods.item(i);
            result.add(new PlyWood(current.getAttribute("name"),
                    current.getAttribute("producer"),
                    Load.valueOf(current.getAttribute("load")),
                    Integer.parseInt(current.getAttribute("value")),
                    AreaToUse.valueOf(current.getAttribute("qualified")),
                    Integer.parseInt(current.getAttribute("length")),
                    Integer.parseInt(current.getAttribute("width")),
                    Integer.parseInt(current.getAttribute("thickness"))));
        }
        return result;
    }
    
    List<Glue> getGlues() {
        Element GluesElement = (Element) components.getElementsByTagName("Glues").item(0);
        NodeList glues = GluesElement.getElementsByTagName("Glue");
        List<Glue> result = new ArrayList<>();
        Element current;
        for (int i = 0; i < glues.getLength(); i++) {
            current = (Element) glues.item(i);
            result.add(new Glue(current.getAttribute("name"),
                    current.getAttribute("producer"),
                    Integer.parseInt(current.getAttribute("value")),
                    AreaToUse.valueOf(current.getAttribute("qualified")),
                    Integer.parseInt(current.getAttribute("settingTime")),
                    Integer.parseInt(current.getAttribute("appliedVolume")),
                    Boolean.valueOf(current.getAttribute("waterResistance")).booleanValue()));
        }
        return result;
    }
    
    List<Dowel> getDowels() {
        Element dowelsElement = (Element) components.getElementsByTagName("Dowels").item(0);
        NodeList dowels = dowelsElement.getElementsByTagName("Dowel");
        List<Dowel> result = new ArrayList<>();
        Element current;
        for (int i = 0; i < dowels.getLength(); i++) {
            current = (Element) dowels.item(i);
            result.add(new Dowel(current.getAttribute("name"),
                    current.getAttribute("producer"),
                    Integer.parseInt(current.getAttribute("value")),
                    AreaToUse.valueOf(current.getAttribute("qualified")),
                    Stuff.valueOf(current.getAttribute("madeBy")),
                    Integer.parseInt(current.getAttribute("length")),
                    Integer.parseInt(current.getAttribute("diameter"))));
        }
        return result;
    }
    
    List<PocketHoleScrew> getPocketHoleScrews() {
        Element pocketHoleScrewsElement = (Element) components.getElementsByTagName("PocketHoleScrews").item(0);
        NodeList pocketHoleScrews = pocketHoleScrewsElement.getElementsByTagName("PocketHoleScrew");
        List<PocketHoleScrew> result = new ArrayList<>();
        Element current;
        for (int i = 0; i < pocketHoleScrews.getLength(); i++) {
            current = (Element) pocketHoleScrews.item(i);
            result.add(new PocketHoleScrew(current.getAttribute("name"),
                    current.getAttribute("producer"),
                    Integer.parseInt(current.getAttribute("value")),
                    AreaToUse.valueOf(current.getAttribute("qualified")),
                    Stuff.valueOf(current.getAttribute("madeBy")),
                    Integer.parseInt(current.getAttribute("length")),
                    Integer.parseInt(current.getAttribute("diameter"))));
        }
        return result;
    }
    
    List<WoodScrew> getWoodscrews() {
        Element woodScrewsElement = (Element) components.getElementsByTagName("WoodScrews").item(0);
        NodeList woodScrews = woodScrewsElement.getElementsByTagName("WoodScrew");
        List<WoodScrew> result = new ArrayList<>();
        Element current;
        for (int i = 0; i < woodScrews.getLength(); i++) {
            current = (Element) woodScrews.item(i);
            result.add(new WoodScrew(current.getAttribute("name"),
                    current.getAttribute("producer"),
                    Integer.parseInt(current.getAttribute("value")),
                    AreaToUse.valueOf(current.getAttribute("qualified")),
                    Stuff.valueOf(current.getAttribute("madeBy")),
                    Integer.parseInt(current.getAttribute("length")),
                    Integer.parseInt(current.getAttribute("diameter"))));
        }
        return result;
    }
    
    List<Slides> getSlides() {
        Element slidesElement = (Element) components.getElementsByTagName("Slides").item(0);
        NodeList slides = slidesElement.getElementsByTagName("Slide");
        List<Slides> result = new ArrayList<>();
        Element current;
        for (int i = 0; i < slides.getLength(); i++) {
            current = (Element) slides.item(i);
            result.add(new Slides(current.getAttribute("name"),
                    current.getAttribute("producer"),
                    Integer.parseInt(current.getAttribute("value")),
                    AreaToUse.valueOf(current.getAttribute("qualified")),
                    Stuff.valueOf(current.getAttribute("madeBy")),
                    Integer.parseInt(current.getAttribute("length")),
                    Integer.parseInt(current.getAttribute("width")),
                    Integer.parseInt(current.getAttribute("depth"))));
        }
        return result;
    }
    
    List<Hinge> getHinges() {
        Element hingesElement = (Element) components.getElementsByTagName("Hinges").item(0);
        NodeList hinges = hingesElement.getElementsByTagName("Hinge");
        List<Hinge> result = new ArrayList<>();
        Element current;
        for (int i = 0; i < hinges.getLength(); i++) {
            current = (Element) hinges.item(i);
            result.add(new Hinge(current.getAttribute("name"),
                    current.getAttribute("producer"),
                    Integer.parseInt(current.getAttribute("value")),
                    AreaToUse.valueOf(current.getAttribute("qualified")),
                    Stuff.valueOf(current.getAttribute("madeBy")),
                    Style.valueOf(current.getAttribute("style")),
                    Finish.valueOf(current.getAttribute("color")),
                    AngleToOpen.valueOf(current.getAttribute("angle")),
                    IsRecess.valueOf(current.getAttribute("mount")),
                    Integer.parseInt(current.getAttribute("length")),
                    Integer.parseInt(current.getAttribute("width")),
                    Integer.parseInt(current.getAttribute("thickness"))));
        }
        return result;
    }
    
    List<Pulls> getPulls() {
        Element pullsElement = (Element) components.getElementsByTagName("Pulls").item(0);
        NodeList pulls = pullsElement.getElementsByTagName("Pull");
        List<Pulls> result = new ArrayList<>();
        Element current;
        for (int i = 0; i < pulls.getLength(); i++) {
            current = (Element) pulls.item(i);
            result.add(new Pulls(current.getAttribute("name"),
                    current.getAttribute("producer"),
                    Integer.parseInt(current.getAttribute("value")),
                    AreaToUse.valueOf(current.getAttribute("qualified")),
                    Stuff.valueOf(current.getAttribute("madeBy")),
                    Style.valueOf(current.getAttribute("style")),
                    Finish.valueOf(current.getAttribute("color")),
                    Integer.parseInt(current.getAttribute("length")),
                    Integer.parseInt(current.getAttribute("height"))));
        }
        return result;
    }
    
    List<Knobs> getKnobs() {
        Element knobsElement = (Element) components.getElementsByTagName("Knobs").item(0);
        NodeList knobs = knobsElement.getElementsByTagName("Knob");
        List<Knobs> result = new ArrayList<>();
        Element current;
        for (int i = 0; i < knobs.getLength(); i++) {
            current = (Element) knobs.item(i);
            result.add(new Knobs(current.getAttribute("name"),
                    current.getAttribute("producer"),
                    Integer.parseInt(current.getAttribute("value")),
                    AreaToUse.valueOf(current.getAttribute("qualified")),
                    Stuff.valueOf(current.getAttribute("madeBy")),
                    Style.valueOf(current.getAttribute("style")),
                    Finish.valueOf(current.getAttribute("color")),
                    Integer.parseInt(current.getAttribute("diameter")),
                    Integer.parseInt(current.getAttribute("height"))));
        }
        return result;
    }
}
