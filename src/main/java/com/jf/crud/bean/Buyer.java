package com.jf.crud.bean;

public class Buyer {
    private Integer buyerid;

    private Integer userid;

    private String nickname;

    private String balance;

    private String receiveadd;

    private String phonenum;

    private String realname;

    public Buyer(Integer buyerid, Integer userid, String nickname, String balance, String receiveadd, String phonenum, String realname) {
        this.buyerid = buyerid;
        this.userid = userid;
        this.nickname = nickname;
        this.balance = balance;
        this.receiveadd = receiveadd;
        this.phonenum = phonenum;
        this.realname = realname;
    }

    public Integer getBuyerid() {
        return buyerid;
    }

    public void setBuyerid(Integer buyerid) {
        this.buyerid = buyerid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance == null ? null : balance.trim();
    }

    public String getReceiveadd() {
        return receiveadd;
    }

    public void setReceiveadd(String receiveadd) {
        this.receiveadd = receiveadd == null ? null : receiveadd.trim();
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum == null ? null : phonenum.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }
}