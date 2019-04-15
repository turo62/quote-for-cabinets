package com.codecool.cmd;

import com.codecool.components.*;
import com.codecool.enums.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
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
    private Element root;

    XMLLoader() {
        try {
            InputStream is = new FileInputStream("components.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document d = db.parse(is);
            root = d.getDocumentElement();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    List<Lumber> getLumbers() {
        Node n = root.getElementsByTagName("Lumbers").item(0);
        Element lumbersElement = (Element) n;
        NodeList lumbers = lumbersElement.getElementsByTagName("Lumber");
        List<Lumber> result = new ArrayList<>();
        Element current;
        for (int i = 0; i < lumbers.getLength(); i++) {
            current = (Element) lumbers.item(i);
            result.add(new Lumber(current.getAttribute("name"),
                    current.getAttribute("producer"),
                    Load.valueOf(current.getAttribute("load")),
                    Double.parseDouble(current.getAttribute("value")),
                    AreaToUse.valueOfInt(Integer.parseInt(current.getAttribute("qualified"))),
                    Integer.parseInt(current.getAttribute("length")),
                    Integer.parseInt(current.getAttribute("width")),
                    Integer.parseInt(current.getAttribute("thickness")),
                    current.getAttribute("species")));
        }
        return result;
    }
    
    List<ChipBoard> getChipBoards() {
        Node n = root.getElementsByTagName("ChipBoards").item(0);
        Element chipBoardsElement = (Element) n;
        NodeList chipBoards = chipBoardsElement.getElementsByTagName("Chipboard");
        List<ChipBoard> result = new ArrayList<>();
        Element current;
        for (int i = 0; i < chipBoards.getLength(); i++) {
            current = (Element) chipBoards.item(i);
            result.add(new ChipBoard(current.getAttribute("name"),
                    current.getAttribute("producer"),
                    Load.valueOf(current.getAttribute("load")),
                    Double.parseDouble(current.getAttribute("value")),
                    AreaToUse.valueOfInt(Integer.parseInt(current.getAttribute("qualified"))),
                    Integer.parseInt(current.getAttribute("length")),
                    Integer.parseInt(current.getAttribute("width")),
                    Integer.parseInt(current.getAttribute("thickness"))));
        }
        return result;
    }
    
    List<MDF> getMDFs() {
        Node n = root.getElementsByTagName("MDFs").item(0);
        Element MDFsElement = (Element) n;
        NodeList MDFs = MDFsElement.getElementsByTagName("MDF");
        List<MDF> result = new ArrayList<>();
        Element current;
        for (int i = 0; i < MDFs.getLength(); i++) {
            current = (Element) MDFs.item(i);
            result.add(new MDF(current.getAttribute("name"),
                    current.getAttribute("producer"),
                    Load.valueOf(current.getAttribute("load")),
                    Double.parseDouble(current.getAttribute("value")),
                    AreaToUse.valueOfInt(Integer.parseInt(current.getAttribute("qualified"))),
                    Integer.parseInt(current.getAttribute("length")),
                    Integer.parseInt(current.getAttribute("width")),
                    Integer.parseInt(current.getAttribute("thickness"))));
        }
        return result;
    }
    
    List<PlyWood> getPlyWoods() {
        Node n = root.getElementsByTagName("PlyWoods").item(0);
        Element plyWoodsElement = (Element) n;
        NodeList plyWoods = plyWoodsElement.getElementsByTagName("PlyWood");
        List<PlyWood> result = new ArrayList<>();
        Element current;
        for (int i = 0; i < plyWoods.getLength(); i++) {
            current = (Element) plyWoods.item(i);
            result.add(new PlyWood(current.getAttribute("name"),
                    current.getAttribute("producer"),
                    Load.valueOf(current.getAttribute("load")),
                    Double.parseDouble(current.getAttribute("value")),
                    AreaToUse.valueOfInt(Integer.parseInt(current.getAttribute("qualified"))),
                    Integer.parseInt(current.getAttribute("length")),
                    Integer.parseInt(current.getAttribute("width")),
                    Integer.parseInt(current.getAttribute("thickness"))));
        }
        return result;
    }
    
    List<Glue> getGlues() {
        Node n = root.getElementsByTagName("Glues").item(0);
        Element GluesElement = (Element) n;
        NodeList glues = GluesElement.getElementsByTagName("Glue");
        List<Glue> result = new ArrayList<>();
        Element current;
        for (int i = 0; i < glues.getLength(); i++) {
            current = (Element) glues.item(i);
            result.add(new Glue(current.getAttribute("name"),
                    current.getAttribute("producer"),
                    Double.parseDouble(current.getAttribute("value")),
                    AreaToUse.valueOfInt(Integer.parseInt(current.getAttribute("qualified"))),
                    Integer.parseInt(current.getAttribute("settingTime")),
                    Integer.parseInt(current.getAttribute("appliedVolume")),
                    Boolean.valueOf(current.getAttribute("waterResistance")).booleanValue()));
        }
        return result;
    }
    
    List<Dowel> getDowels() {
        Node n = root.getElementsByTagName("Dowels").item(0);
        Element dowelsElement = (Element) n;
        NodeList dowels = dowelsElement.getElementsByTagName("Dowel");
        List<Dowel> result = new ArrayList<>();
        Element current;
        for (int i = 0; i < dowels.getLength(); i++) {
            current = (Element) dowels.item(i);
            result.add(new Dowel(current.getAttribute("name"),
                    current.getAttribute("producer"),
                    Double.parseDouble(current.getAttribute("value")),
                    AreaToUse.valueOfInt(Integer.parseInt(current.getAttribute("qualified"))),
                    Stuff.valueOf(current.getAttribute("madeBy")),
                    Integer.parseInt(current.getAttribute("length")),
                    Integer.parseInt(current.getAttribute("diameter"))));
        }
        return result;
    }
    
    List<PocketHoleScrew> getPocketHoleScrews() {
        Node n = root.getElementsByTagName("PocketHoleScrews").item(0);
        Element pocketHoleScrewsElement = (Element) n;
        NodeList pocketHoleScrews = pocketHoleScrewsElement.getElementsByTagName("PocketHoleScrew");
        List<PocketHoleScrew> result = new ArrayList<>();
        Element current;
        for (int i = 0; i < pocketHoleScrews.getLength(); i++) {
            current = (Element) pocketHoleScrews.item(i);
            result.add(new PocketHoleScrew(current.getAttribute("name"),
                    current.getAttribute("producer"),
                    Double.parseDouble(current.getAttribute("value")),
                    AreaToUse.valueOfInt(Integer.parseInt(current.getAttribute("qualified"))),
                    Stuff.valueOf(current.getAttribute("madeBy")),
                    Integer.parseInt(current.getAttribute("length")),
                    Integer.parseInt(current.getAttribute("diameter"))));
        }
        return result;
    }
    
    List<WoodScrew> getWoodscrews() {
        Node n = root.getElementsByTagName("WoodScrews").item(0);
        Element woodScrewsElement = (Element) n;
        NodeList woodScrews = woodScrewsElement.getElementsByTagName("WoodScrew");
        List<WoodScrew> result = new ArrayList<>();
        Element current;
        for (int i = 0; i < woodScrews.getLength(); i++) {
            current = (Element) woodScrews.item(i);
            result.add(new WoodScrew(current.getAttribute("name"),
                    current.getAttribute("producer"),
                    Double.parseDouble(current.getAttribute("value")),
                    AreaToUse.valueOfInt(Integer.parseInt(current.getAttribute("qualified"))),
                    Stuff.valueOf(current.getAttribute("madeBy")),
                    Integer.parseInt(current.getAttribute("length")),
                    Integer.parseInt(current.getAttribute("diameter"))));
        }
        return result;
    }
    
    List<Slides> getSlides() {
        Node n = root.getElementsByTagName("Slides").item(0);
        Element slidesElement = (Element) n;
        NodeList slides = slidesElement.getElementsByTagName("Slide");
        List<Slides> result = new ArrayList<>();
        Element current;
        for (int i = 0; i < slides.getLength(); i++) {
            current = (Element) slides.item(i);
            result.add(new Slides(current.getAttribute("name"),
                    current.getAttribute("producer"),
                    Double.parseDouble(current.getAttribute("value")),
                    AreaToUse.valueOfInt(Integer.parseInt(current.getAttribute("qualified"))),
                    Stuff.valueOf(current.getAttribute("madeBy")),
                    Integer.parseInt(current.getAttribute("length")),
                    Integer.parseInt(current.getAttribute("width")),
                    Integer.parseInt(current.getAttribute("depth"))));
        }
        return result;
    }
    
    List<Hinge> getHinges() {
        Node n = root.getElementsByTagName("Hinges").item(0);
        Element hingesElement = (Element) n;
        NodeList hinges = hingesElement.getElementsByTagName("Hinge");
        List<Hinge> result = new ArrayList<>();
        Element current;
        for (int i = 0; i < hinges.getLength(); i++) {
            current = (Element) hinges.item(i);
            result.add(new Hinge(current.getAttribute("name"),
                    current.getAttribute("producer"),
                    Double.parseDouble(current.getAttribute("value")),
                    AreaToUse.valueOfInt(Integer.parseInt(current.getAttribute("qualified"))),
                    Stuff.valueOf(current.getAttribute("madeBy")),
                    Style.valueOf(current.getAttribute("style")),
                    Finish.valueOf(current.getAttribute("color")),
                    AngleToOpen.valueOfInt(Integer.parseInt(current.getAttribute("angle"))),
                    IsRecess.valueOf(current.getAttribute("mount")),
                    Integer.parseInt(current.getAttribute("length")),
                    Integer.parseInt(current.getAttribute("width")),
                    Integer.parseInt(current.getAttribute("thickness"))));
        }
        return result;
    }
    
    List<Pulls> getPulls() {
        Node n = root.getElementsByTagName("Pulls").item(0);
        Element pullsElement = (Element) n;
        NodeList pulls = pullsElement.getElementsByTagName("Pull");
        List<Pulls> result = new ArrayList<>();
        Element current;
        for (int i = 0; i < pulls.getLength(); i++) {
            current = (Element) pulls.item(i);
            result.add(new Pulls(current.getAttribute("name"),
                    current.getAttribute("producer"),
                    Double.parseDouble(current.getAttribute("value")),
                    AreaToUse.valueOfInt(Integer.parseInt(current.getAttribute("qualified"))),
                    Stuff.valueOf(current.getAttribute("madeBy")),
                    Style.valueOf(current.getAttribute("style")),
                    Finish.valueOf(current.getAttribute("color")),
                    Integer.parseInt(current.getAttribute("length")),
                    Integer.parseInt(current.getAttribute("height"))));
        }
        return result;
    }
    
    List<Knobs> getKnobs() {
        Node n = root.getElementsByTagName("Knobs").item(0);
        Element knobsElement = (Element) n;
        NodeList knobs = knobsElement.getElementsByTagName("Knob");
        List<Knobs> result = new ArrayList<>();
        Element current;
        for (int i = 0; i < knobs.getLength(); i++) {
            current = (Element) knobs.item(i);
            result.add(new Knobs(current.getAttribute("name"),
                    current.getAttribute("producer"),
                    Double.parseDouble(current.getAttribute("value")),
                    AreaToUse.valueOfInt(Integer.parseInt(current.getAttribute("qualified"))),
                    Stuff.valueOf(current.getAttribute("madeBy")),
                    Style.valueOf(current.getAttribute("style")),
                    Finish.valueOf(current.getAttribute("color")),
                    Integer.parseInt(current.getAttribute("diameter")),
                    Integer.parseInt(current.getAttribute("height"))));
        }
        return result;
    }
}
