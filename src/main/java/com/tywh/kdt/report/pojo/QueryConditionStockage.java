package com.tywh.kdt.report.pojo;

public class QueryConditionStockage {
    private Integer pageNo;
    private Integer pageSize;
    private String shum;
    private String tsfljc;
    private String zbh;
    private String bmmc;  //编辑部门名称
    private final String  kwbh = "00HG";
    private final String sxhRemove = "W%";
    private final Integer qmkcRemove = 0;
    private Integer startno;
    private Integer endno;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

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

    public Integer getStartno() {
        return pageNo * pageSize - pageSize + 1;
    }

    public Integer getEndno() {
        return pageNo * pageSize;
    }
}
