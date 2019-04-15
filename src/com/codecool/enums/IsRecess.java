package com.codecool.enums;

public enum IsRecess {
    SM("surface mounted"),
    MM("mortice mounted");
    
    private String mount;
    
    IsRecess(String mount) {
        this.mount = mount;
    }
    
    public String getMount() {
        return mount;
    }
}
