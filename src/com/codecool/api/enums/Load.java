package com.codecool.api.enums;

public enum Load {
    HIGH("H"),
    MEDIUM("M"),
    LOW("L");
    
    private String load;
    
    Load(String load) {
        this.load = load;
    }
    
    public String getLoad() {
        return load;
    }
    
    public void setLoad(String load) {
        this.load = load;
    }
}
