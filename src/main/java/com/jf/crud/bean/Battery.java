package com.jf.crud.bean;

public class Battery {
    private Integer charbattid;

    private String capacity;

    private String charinter;

    private String charpower;

    public Integer getCharbattid() {
        return charbattid;
    }

    public void setCharbattid(Integer charbattid) {
        this.charbattid = charbattid;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity == null ? null : capacity.trim();
    }

    public String getCharinter() {
        return charinter;
    }

    public void setCharinter(String charinter) {
        this.charinter = charinter == null ? null : charinter.trim();
    }

    public String getCharpower() {
        return charpower;
    }

    public void setCharpower(String charpower) {
        this.charpower = charpower == null ? null : charpower.trim();
    }
}