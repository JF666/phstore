package com.jf.crud.bean;

public class Product {
    private Integer proId;

    private String pic;

    private String proIntro;

    private Integer sellerId;

    private String version;

    private Integer stock;

    private Integer discount;

    private String proName;

    private String price;

    private String color;

    public Integer getproId() {
        return proId;
    }

    public void setproId(Integer proId) {
        this.proId = proId;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getproIntro() {
        return proIntro;
    }

    public void setproIntro(String proIntro) {
        this.proIntro = proIntro == null ? null : proIntro.trim();
    }

    public Integer getSellerid() {
        return sellerId;
    }

    public void setSellerid(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getProname() {
        return proName;
    }

    public void setProname(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }
}