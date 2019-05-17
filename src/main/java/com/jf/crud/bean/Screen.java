package com.jf.crud.bean;

public class Screen {
    private Integer screenid;

    private String screenname;

    private String screensize;

    private String resolution;

    private String screenocc;

    private String screenshape;

    public Integer getScreenid() {
        return screenid;
    }

    public void setScreenid(Integer screenid) {
        this.screenid = screenid;
    }

    public String getScreenname() {
        return screenname;
    }

    public void setScreenname(String screenname) {
        this.screenname = screenname == null ? null : screenname.trim();
    }

    public String getScreensize() {
        return screensize;
    }

    public void setScreensize(String screensize) {
        this.screensize = screensize == null ? null : screensize.trim();
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution == null ? null : resolution.trim();
    }

    public String getScreenocc() {
        return screenocc;
    }

    public void setScreenocc(String screenocc) {
        this.screenocc = screenocc == null ? null : screenocc.trim();
    }

    public String getScreenshape() {
        return screenshape;
    }

    public void setScreenshape(String screenshape) {
        this.screenshape = screenshape == null ? null : screenshape.trim();
    }
}