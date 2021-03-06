package com.tywh.kdt.report.pojo;

public class RkDetail {

    private String rkdbh;
    private String txrq;
    private String sxh;
    private Integer cs;
    private String gysmc;
    private String label; //term1(0-30天),term2(31-60天)......

    public String getKey() {
        return this.sxh + "-" + this.label;
    }

    public String getRkdbh() {
        return rkdbh;
    }

    public void setRkdbh(String rkdbh) {
        this.rkdbh = rkdbh;
    }

    public String getTxrq() {
        return txrq;
    }

    public void setTxrq(String txrq) {
        this.txrq = txrq;
    }

    public String getSxh() {
        return sxh;
    }

    public void setSxh(String sxh) {
        this.sxh = sxh;
    }

    public Integer getCs() {
        return cs;
    }

    public void setCs(Integer cs) {
        this.cs = cs;
    }

    public String getGysmc() {
        return gysmc;
    }

    public void setGysmc(String gysmc) {
        this.gysmc = gysmc;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
