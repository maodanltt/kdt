package com.tywh.kdt.report.pojo;

import java.util.List;

public class Result {

    private Integer total;

    private List<SalesDetail> salesDetailList;

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
}
