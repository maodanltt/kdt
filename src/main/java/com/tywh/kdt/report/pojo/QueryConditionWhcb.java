package com.tywh.kdt.report.pojo;

import java.util.Arrays;
import java.util.List;

public class QueryConditionWhcb {

    private String bjbmmc;

    private String xsbmmc;

    private String tsfljc;

    private String startdate;

    private String enddate;

    private List<String> fhzts = Arrays.asList("待发","已发");

    private List<String> tsfljcRemove = Arrays.asList("%联考%","日历%","赠品%","宣传品%");

    private String khbhRemove = "2000000747";

    private String sxhRemove = "W%";

    private String kwbh = "00HG";

    private String kjqj = "2020-01";

    public String getBjbmmc() {
        return bjbmmc;
    }

    public void setBjbmmc(String bjbmmc) {
        this.bjbmmc = bjbmmc;
    }

    public String getXsbmmc() {
        return xsbmmc;
    }

    public void setXsbmmc(String xsbmmc) {
        this.xsbmmc = xsbmmc;
    }

    public String getTsfljc() {
        return tsfljc;
    }

    public void setTsfljc(String tsfljc) {
        this.tsfljc = tsfljc;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public List<String> getFhzts() {
        return fhzts;
    }

    public void setFhzts(List<String> fhzts) {
        this.fhzts = fhzts;
    }

    public List<String> getTsfljcRemove() {
        return tsfljcRemove;
    }

    public void setTsfljcRemove(List<String> tsfljcRemove) {
        this.tsfljcRemove = tsfljcRemove;
    }

    public String getKhbhRemove() {
        return khbhRemove;
    }

    public void setKhbhRemove(String khbhRemove) {
        this.khbhRemove = khbhRemove;
    }

    public String getSxhRemove() {
        return sxhRemove;
    }

    public void setSxhRemove(String sxhRemove) {
        this.sxhRemove = sxhRemove;
    }

    public String getKwbh() {
        return kwbh;
    }

    public void setKwbh(String kwbh) {
        this.kwbh = kwbh;
    }

    public String getKjqj() {
        return kjqj;
    }

    public void setKjqj(String kjqj) {
        this.kjqj = kjqj;
    }

}
