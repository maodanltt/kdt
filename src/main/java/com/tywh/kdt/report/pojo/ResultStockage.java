package com.tywh.kdt.report.pojo;

import java.util.List;

public class ResultStockage {

    private Integer total;

    private List<Stockage> stockageList;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Stockage> getStockageList() {
        return stockageList;
    }

    public void setStockageList(List<Stockage> stockageList) {
        this.stockageList = stockageList;
    }
}
