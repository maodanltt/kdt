package com.tywh.kdt.api.pojo;

/**
 *  封装商品信息;
 *  推送商品时使用
 *  推送单据时单据明细中使用，用以封装单据明信息
 */

public class Goods {

    private String sxh;

    private String shum;

    private Integer mbcs;

    private String zbh;

    private String shuh;

    private double gjdj;

    private Integer cs;

    public Goods() {
    }

    public Goods(String sxh, Integer cs) {
        this.sxh = sxh;
        this.cs = cs;
    }
    public String getSxh() {
        return sxh;
    }

    public void setSxh(String sxh) {
        this.sxh = sxh;
    }

    public String getShum() {
        return shum;
    }

    public void setShum(String shum) {
        this.shum = shum;
    }

    public Integer getMbcs() {
        return mbcs;
    }

    public void setMbcs(Integer mbcs) {
        this.mbcs = mbcs;
    }

    public String getZbh() {
        return zbh;
    }

    public void setZbh(String zbh) {
        this.zbh = zbh;
    }

    public String getShuh() {
        return shuh;
    }

    public void setShuh(String shuh) {
        this.shuh = shuh;
    }

    public double getGjdj() {
        return gjdj;
    }

    public void setGjdj(double gjdj) {
        this.gjdj = gjdj;
    }

    public Integer getCs() {
        return cs;
    }

    public void setCs(Integer cs) {
        this.cs = cs;
    }
}
