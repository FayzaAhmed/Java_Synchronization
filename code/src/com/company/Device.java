package com.company;

public class Device {
    public String name;
    public String type;

    public Device(){
        this.name = "";
        this.type = "";
    }
    public Device(String name, String type){
        this.name = name;
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
}
