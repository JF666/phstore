package com.jf.crud.bean;

public class Rearcamera {
    private Integer rcid;

    private String rcname;

    private String rcpixel;

    public Integer getRcid() {
        return rcid;
    }

    public void setRcid(Integer rcid) {
        this.rcid = rcid;
    }

    public String getRcname() {
        return rcname;
    }

    public void setRcname(String rcname) {
        this.rcname = rcname == null ? null : rcname.trim();
    }

    public String getRcpixel() {
        return rcpixel;
    }

    public void setRcpixel(String rcpixel) {
        this.rcpixel = rcpixel == null ? null : rcpixel.trim();
    }

}