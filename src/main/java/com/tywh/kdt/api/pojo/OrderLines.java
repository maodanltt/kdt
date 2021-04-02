package com.tywh.kdt.api.pojo;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * 封装WMS订单行
 */
@XmlRootElement(name = "orderLines")
public class OrderLines {

    private List<OrderLine> orderLine;

    public List<OrderLine> getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(List<OrderLine> orderLine) {
        this.orderLine = orderLine;
    }
}
