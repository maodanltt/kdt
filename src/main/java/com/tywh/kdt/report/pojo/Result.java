package com.tywh.kdt.report.pojo;

import java.util.List;

public class Result {

    private Integer total;

    private List<SalesDetail> salesDetailList;

    private Integer zcs;

    private double zmy;

    private double pjzk;

    private double zsy;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<SalesDetail> getSalesDetailList() {
        return salesDetailList;
    }

    public void setSalesDetailList(List<SalesDetail> salesDetailList) {
        this.salesDetailList = salesDetailList;
    }

    public Integer getZcs() {
        return zcs;
    }

    public void setZcs(Integer zcs) {
        this.zcs = zcs;
    }

    public double getZmy() {
        return zmy;
    }

    public void setZmy(double zmy) {
        this.zmy = zmy;
    }

    public double getPjzk() {
        return pjzk;
    }

    public void setPjzk(double pjzk) {
        this.pjzk = pjzk;
    }

    public double getZsy() {
        return zsy;
    }

    public void setZsy(double zsy) {
        this.zsy = zsy;
    }
}
