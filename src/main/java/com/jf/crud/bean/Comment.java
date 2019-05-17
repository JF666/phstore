package com.jf.crud.bean;

public class Comment {
    private Integer commid;

    private Integer buyerid;

    private Integer sellerid;

    private String comminfo;

    private String apply;

    private Integer commsts;

    private Integer proid;

    public Integer getCommid() {
        return commid;
    }

    public void setCommid(Integer commid) {
        this.commid = commid;
    }

    public Integer getBuyerid() {
        return buyerid;
    }

    public void setBuyerid(Integer buyerid) {
        this.buyerid = buyerid;
    }

    public Integer getSellerid() {
        return sellerid;
    }

    public void setSellerid(Integer sellerid) {
        this.sellerid = sellerid;
    }

    public String getComminfo() {
        return comminfo;
    }

    public void setComminfo(String comminfo) {
        this.comminfo = comminfo == null ? null : comminfo.trim();
    }

    public String getApply() {
        return apply;
    }

    public void setApply(String apply) {
        this.apply = apply == null ? null : apply.trim();
    }

    public Integer getCommsts() {
        return commsts;
    }

    public void setCommsts(Integer commsts) {
        this.commsts = commsts;
    }

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }
}