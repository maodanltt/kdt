package com.tywh.kdt.report.pojo;

public class QueryCondition {
    private Integer pageNo;
    private Integer pageSize;
    private String khmc;
    private String shum;
    private String tsfljc;
    private String zbh;
    private String bmmc;  //编辑部门名称
    private String djlx;
    private String dqjl;
    private String dq;
    private String startdate; //必须输入
    private String enddate;   //必须输入
    private final String xsbmmc = "成教营销中心";
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

    public String getKhmc() {
        return khmc;
    }

    public void setKhmc(String khmc) {
        this.khmc = khmc;
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

    public String getDjlx() {
        return djlx;
    }

    public void setDjlx(String djlx) {
        this.djlx = djlx;
    }

    public String getDqjl() {
        return dqjl;
    }

    public void setDqjl(String dqjl) {
        this.dqjl = dqjl;
    }

    public String getDq() {
        return dq;
    }

    public void setDq(String dq) {
        this.dq = dq;
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

    public String getXsbmmc() {
        return xsbmmc;
    }

    public Integer getStartno() {
        return pageNo * pageSize - pageSize + 1;
    }

    public Integer getEndno() {
        return pageNo * pageSize;
    }
}
