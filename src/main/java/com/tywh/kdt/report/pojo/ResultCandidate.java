package com.tywh.kdt.report.pojo;

import java.util.List;

public class ResultCandidate {

    private List<Candidate> list;

    private Integer total;

    public List<Candidate> getList() {
        return list;
    }

    public void setList(List<Candidate> list) {
        this.list = list;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
