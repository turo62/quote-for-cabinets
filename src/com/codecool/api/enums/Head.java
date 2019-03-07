package com.codecool.api.enums;

public enum Head {
    WASHERHEAD("WH"),
    COUNTERSUNK("CS");
    
    
    private final String head;
    
    Head(String head) {
        this.head = head;
    }
    
    public String getHead() {
        return head;
    }
}
