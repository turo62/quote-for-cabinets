package com.codecool.enums;

public enum IsRecess {
    SURFACEMOUNT("SM"),
    MORTICEMOUNT("MM");
    
    private String mount;
    
    IsRecess(String mount) {
        this.mount = mount;
    }
    
    public String getMount() {
        return mount;
    }
}
