package com.tywh.kdt.report.pojo;

public class QueryCondition {

    private String khmc;
    private String xsbmmc;
    private String djlx;
    private String startDate; //必须输入
    private String endDate;   //必须输入
    private String sxh;
    private String shum;
    private String bmmc;  //编辑部门名称
    private String tsfljc;
    private String zbh;
    private String flmc;
    private String dqjc;
    private final String tsfljcRemove = "%联考%";
    private final String scopeDate = "2020-01-01";

    public String getKhmc() {
        return khmc;
    }

    public void setKhmc(String khmc) {
        this.khmc = khmc;
    }

    public String getXsbmmc() {
        return xsbmmc;
    }

    public void setXsbmmc(String xsbmmc) {
        this.xsbmmc = xsbmmc;
    }

    public String getDjlx() {
        return djlx;
    }

    public void setDjlx(String djlx) {
        this.djlx = djlx;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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

    public String getBmmc() {
        return bmmc;
    }

    public void setBmmc(String bmmc) {
        this.bmmc = bmmc;
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

    public String getFlmc() {
        return flmc;
    }

    public void setFlmc(String flmc) {
        this.flmc = flmc;
    }

    public String getDqjc() {
        return dqjc;
    }

    public void setDqjc(String dqjc) {
        this.dqjc = dqjc;
    }

    public String getTsfljcRemove() {
        return tsfljcRemove;
    }

    public String getScopeDate() {
        return scopeDate;
    }


}
