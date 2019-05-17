package com.jf.crud.bean;

public class Frontcamera {
    private Integer fcid;

    private String fcname;

    private String fcpixel;

    public Integer getFcid() {
        return fcid;
    }

    public void setFcid(Integer fcid) {
        this.fcid = fcid;
    }

    public String getFcname() {
        return fcname;
    }

    public void setFcname(String fcname) {
        this.fcname = fcname == null ? null : fcname.trim();
    }

    public String getFcpixel() {
        return fcpixel;
    }

    public void setFcpixel(String fcpixel) {
        this.fcpixel = fcpixel == null ? null : fcpixel.trim();
    }

}