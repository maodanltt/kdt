package com.tywh.kdt.report.pojo;

public class QueryConditionYzd {

    private Integer pageno;

    private Integer pagesize;

    private String startdate;

    private String enddate;

    private String shum;

    private String tsflmc;

    private String sxh;

    private Integer startno;

    private Integer endno;

    public Integer getPageno() {
        return pageno;
    }

    public void setPageno(Integer pageno) {
        this.pageno = pageno;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
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

    public String getShum() {
        return shum;
    }

    public void setShum(String shum) {
        this.shum = shum;
    }

    public String getTsflmc() {
        return tsflmc;
    }

    public void setTsflmc(String tsflmc) {
        this.tsflmc = tsflmc;
    }

    public String getSxh() {
        return sxh;
    }

    public void setSxh(String sxh) {
        this.sxh = sxh;
    }

    public Integer getStartno() {
        return pageno * pagesize - pagesize + 1;
    }

    public Integer getEndno() {
        return pageno * pagesize;
    }
}
