package com.jf.crud.bean;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

public class User {
    private Integer id;
    @Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]{6,12}$", message = "用户名必须是6-12位字母和数字组合")
    private String username;
    @Pattern(regexp = "^[\\w@#$]{6,16}$", message = "密码必须是6-16位字母和数字组合或者@#$符号")
    private String password;

    private Integer authority;

    private Buyer buyer;

    private Seller seller;

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getAuthority() {
        return authority;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
    }
}