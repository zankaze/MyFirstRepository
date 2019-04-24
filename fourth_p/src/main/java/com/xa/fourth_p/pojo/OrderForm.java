package com.xa.fourth_p.pojo;

public class OrderForm {
    int orderid;
    int userid;
    String username;
    String addresses;
    String phonenum;
    String goodsname;
    int goodsprice;
    String goodsphoto;
    int ordernum;

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddresses() {
        return addresses;
    }

    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public int getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(int goodsprice) {
        this.goodsprice = goodsprice;
    }

    public String getGoodsphoto() {
        return goodsphoto;
    }

    public void setGoodsphoto(String goodsphoto) {
        this.goodsphoto = goodsphoto;
    }

    public int getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(int ordernum) {
        this.ordernum = ordernum;
    }

    @Override
    public String toString() {
        return "OrderForm{" +
                "orderid=" + orderid +
                ", userid=" + userid +
                ", username='" + username + '\'' +
                ", addresses='" + addresses + '\'' +
                ", phonenum='" + phonenum + '\'' +
                ", goodsname='" + goodsname + '\'' +
                ", goodsprice=" + goodsprice +
                ", goodsphoto='" + goodsphoto + '\'' +
                ", ordernum=" + ordernum +
                '}';
    }
}
