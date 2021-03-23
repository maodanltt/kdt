package com.tywh.kdt.util;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "test")
public class Test {

    private final String actionType = "update";

    private final String warehouseCode = "00HG";

    @JacksonXmlProperty
    private final String ownerCode = "tianyiWMS";

    @JacksonXmlElementWrapper(localName = "orderLines")
    private List<Student> orderLine;

    public String getActionType() {
        return actionType;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public String getOwnerCode() {
        return ownerCode;
    }

    public List<Student> getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(List<Student> orderLine) {
        this.orderLine = orderLine;
    }
}
