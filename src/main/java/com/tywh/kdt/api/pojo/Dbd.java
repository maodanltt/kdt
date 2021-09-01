package com.tywh.kdt.api.pojo;

/**
 * 封装科迪通数据库查询出的调拨单信息
 */
public class Dbd {

    private String fhdbh;
    private String djkwbh;
    private String sxh;
    private String kwbh;
    private Integer cs;
    private String bz;
    private String khmc;
    private String shdz;

    public String getFhdbh() {
        return fhdbh;
    }

    public void setFhdbh(String fhdbh) {
        this.fhdbh = fhdbh;
    }

    public String getDjkwbh() {
        return djkwbh;
    }

    public void setDjkwbh(String djkwbh) {
        this.djkwbh = djkwbh;
    }

    public String getSxh() {
        return sxh;
    }

    public void setSxh(String sxh) {
        this.sxh = sxh;
    }

    public String getKwbh() {
        return kwbh;
    }

    public void setKwbh(String kwbh) {
        this.kwbh = kwbh;
    }

    public Integer getCs() {
        return cs;
    }

    public void setCs(Integer cs) {
        this.cs = cs;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getKhmc() {
        return khmc;
    }

    public void setKhmc(String khmc) {
        this.khmc = khmc;
    }

    public String getShdz() {
        return shdz;
    }

    public void setShdz(String shdz) {
        this.shdz = shdz;
    }
}
