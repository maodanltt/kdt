package com.tywh.kdt.util;

public class OrderLine {

    private Integer orderLineNo;

    private String ownerCode;

    private String itemCode;

    private Integer planQty;

    public Integer getOrderLineNo() {
        return orderLineNo;
    }

    public void setOrderLineNo(Integer orderLineNo) {
        this.orderLineNo = orderLineNo;
    }

    public String getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Integer getPlanQty() {
        return planQty;
    }

    public void setPlanQty(Integer planQty) {
        this.planQty = planQty;
    }
}
