package com.tywh.kdt.report.pojo;

public class QueryConditionStockage {

    private String shum;
    private String tsfljc;
    private String zbh;
    private String bmmc;  //编辑部门名称
    private final String  kwbh = "00HG";
    private final String sxhRemove = "W%";
    private final Integer qmkcRemove = 0;

    public String getShum() {
        return shum;
    }

    public void setShum(String shum) {
        this.shum = shum;
    }

    public String getTsfljc() {
        return tsfljc;
    }

    public void setTsfljc(String tsfljc) {
        this.tsfljc = tsfljc;
    }

    public String getZbh() {
        return zbh;
    }

    public void setZbh(String zbh) {
        this.zbh = zbh;
    }

    public String getBmmc() {
        return bmmc;
    }

    public void setBmmc(String bmmc) {
        this.bmmc = bmmc;
    }

    public String getKwbh() {
        return kwbh;
    }

    public String getSxhRemove() {
        return sxhRemove;
    }

    public Integer getQmkcRemove() {
        return qmkcRemove;
    }
}
