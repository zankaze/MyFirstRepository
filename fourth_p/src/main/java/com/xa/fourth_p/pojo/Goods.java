package com.xa.fourth_p.pojo;

public class Goods {
    int goodsid ;
    String goodsname ;
    int goodsprice ;
    String goodsphoto;
    int goodsnum;
    String goodsintro;
    String goodsstatus = "true";

    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
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

    public int getGoodsnum() {
        return goodsnum;
    }

    public void setGoodsnum(int goodsnum) {
        this.goodsnum = goodsnum;
    }

    public String getGoodsintro() {
        return goodsintro;
    }

    public void setGoodsintro(String goodsintro) {
        this.goodsintro = goodsintro;
    }

    public String getGoodsstatus() {
        return goodsstatus;
    }

    public void setGoodsstatus(String goodsstatus) {
        this.goodsstatus = goodsstatus;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsid=" + goodsid +
                ", goodsname='" + goodsname + '\'' +
                ", goodsprice=" + goodsprice +
                ", goodsphoto='" + goodsphoto + '\'' +
                ", goodsnum=" + goodsnum +
                ", goodsintro='" + goodsintro + '\'' +
                ", goodsstatus='" + goodsstatus + '\'' +
                '}';
    }
}
