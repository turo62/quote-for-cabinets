package com.codecool.enums;

public enum Style {
    MO("modern"),
    CL("classical");
    
    private final String style;
    
    Style(String style) {
        this.style = style;
    }
    
    public String getStyle() {
        return style;
    }
}
