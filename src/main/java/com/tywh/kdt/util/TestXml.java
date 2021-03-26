package com.tywh.kdt.util;

import com.tywh.kdt.api.pojo.*;

import java.util.ArrayList;
import java.util.List;

public class TestXml {
    public static void main(String[] args) throws Exception{

        DeliveryOrder deliveryOrder = new DeliveryOrder();
        deliveryOrder.setCreateTime("2021-03-24");
        deliveryOrder.setReceiverInfo(new ReceiverInfo());
        deliveryOrder.setSenderInfo(new SenderInfo());

        OrderLines orderLines = new OrderLines();
        List<OrderLine> orderLineList = new ArrayList<>();
        OrderLine orderLine1 = new OrderLine();
        orderLine1.setOrderLineNo(1);
        orderLine1.setOwnerCode("tianyiWMS");
        orderLine1.setItemCode("20210001");
        orderLine1.setPlanQty(10);

        OrderLine orderLine2 = new OrderLine();
        orderLine2.setOrderLineNo(2);
        orderLine2.setOwnerCode("tianyiWMS");
        orderLine2.setItemCode("20210002");
        orderLine2.setPlanQty(20);
        orderLineList.add(orderLine1);
        orderLineList.add(orderLine2);
        orderLines.setOrderLine(orderLineList);

        String deliveryOrderXml = XmlUtil.objToXml(deliveryOrder);
        String orderLinesXml = XmlUtil.objToXml(orderLines);


        System.out.println("<request>" + deliveryOrderXml + orderLinesXml + "</request>");
    }

}
