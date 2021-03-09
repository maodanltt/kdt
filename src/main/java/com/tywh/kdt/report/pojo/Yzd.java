package com.tywh.kdt.report.pojo;

public class Yzd {

    //印装单记录
    private String txrq;
    private String ywrq;
    private Integer bcys;
    private Integer yscs; //已收货册数
    private String cycmc;
    private String sxh;

    public String getTxrq() {
        return txrq;
    }

    public void setTxrq(String txrq) {
        this.txrq = txrq;
    }

    public String getYwrq() {
        return ywrq;
    }

    public void setYwrq(String ywrq) {
        this.ywrq = ywrq;
    }

    public Integer getBcys() {
        return bcys;
    }

    public void setBcys(Integer bcys) {
        this.bcys = bcys;
    }

    public Integer getYscs() {
        return yscs;
    }

    public void setYscs(Integer yscs) {
        this.yscs = yscs;
    }

    public String getCycmc() {
        return cycmc;
    }

    public void setCycmc(String cycmc) {
        this.cycmc = cycmc;
    }

    public String getSxh() {
        return sxh;
    }

    public void setSxh(String sxh) {
        this.sxh = sxh;
    }
}
