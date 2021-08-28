package com.tywh.kdt.report.pojo;

public class QueryConditionCandidate {

    private Integer pageno;

    private Integer pagesize;

    private String startdate;

    private String enddate;

    private String username;

    private String candidate;

    private String jobtitle;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public Integer getStartno() {
        return pageno * pagesize - pagesize + 1;
    }

    public Integer getEndno() {
        return pageno * pagesize;
    }
}
