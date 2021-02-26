package com.tywh.kdt.report.pojo;

import java.util.List;

public class WhcbResult {

    private List<Item> itemList;
    private Integer zxscs;
    private String zkczzl;
    private Integer zqckc;
    private Integer zqmkc;

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Integer getZxscs() {
        return zxscs;
    }

    public void setZxscs(Integer zxscs) {
        this.zxscs = zxscs;
    }

    public String getZkczzl() {
        return zkczzl;
    }

    public void setZkczzl(String zkczzl) {
        this.zkczzl = zkczzl;
    }

    public Integer getZqckc() {
        return zqckc;
    }

    public void setZqckc(Integer zqckc) {
        this.zqckc = zqckc;
    }

    public Integer getZqmkc() {
        return zqmkc;
    }

    public void setZqmkc(Integer zqmkc) {
        this.zqmkc = zqmkc;
    }
}
