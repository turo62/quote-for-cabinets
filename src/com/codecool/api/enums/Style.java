package com.codecool.api.enums;

public enum Style {
    MODERN("MO"),
    CLASSICAL("CL");
    
    private final String style;
    
    Style(String style) {
        this.style = style;
    }
    
    public String getStyle() {
        return style;
    }
}
