package com.jf.crud.bean;

public class Transaction {
    private Integer tranid;

    private Integer buyerid;

    private Integer sellerid;

    private Integer proid;

    private Integer amount;

    private Integer transts;

    private String createtime;

    private Integer acprice;

    private String color;

    private String pic;

    private Seller seller;

    private Product product;

    public Transaction(Integer transts) {
        this.transts = transts;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    private Buyer buyer;

    public Integer getTranid() {
        return tranid;
    }

    public void setTranid(Integer tranid) {
        this.tranid = tranid;
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

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getTransts() {
        return transts;
    }

    public void setTransts(Integer transts) {
        this.transts = transts;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public Integer getAcprice() {
        return acprice;
    }

    public void setAcprice(Integer acprice) {
        this.acprice = acprice;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }
}