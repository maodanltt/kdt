package com.tywh.kdt.api.service.impl;

import com.tywh.kdt.api.mapper.RkMapper;
import com.tywh.kdt.api.mapper.ThdMapper;
import com.tywh.kdt.api.pojo.*;
import com.tywh.kdt.api.service.ThdService;
import com.tywh.kdt.util.DateUtil;
import com.tywh.kdt.util.XmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThdServiceImpl implements ThdService {

    @Autowired
    private ReceiverInfo receiverInfo;

    @Autowired
    private SenderInfo senderInfo;

    @Value("${orderType.thrk}")
    private String orderType;

    @Value("${wms.ownerCode}")
    private String ownerCode;

    @Autowired
    private ThdMapper thdMapper;

    @Override
    public String createXml(String dh) throws Exception {
        List<Dbd> thdList = thdMapper.queryThdList(dh);

        ReturnOrder returnOrder = new ReturnOrder();
        returnOrder.setReturnOrderCode(dh);
        returnOrder.setOwnerCode(ownerCode);
        returnOrder.setOrderType(orderType);
        returnOrder.setWarehouseCode(thdList.get(0).getKwbh());
        returnOrder.setLogisticsCode("OTHER");
        returnOrder.setRemark(thdList.get(0).getBz());
        returnOrder.setReceiverInfo(receiverInfo);
        returnOrder.setSenderInfo(senderInfo);

        String returnOrderXml = XmlUtil.objToXml(returnOrder);

        OrderLines orderLines = new OrderLines();
        List<OrderLine> orderLineList = new ArrayList<>();
        int i = 1;
        for (Dbd dbd : thdList) {
            OrderLine orderLine = new OrderLine();
            orderLine.setOwnerCode(ownerCode);
            orderLine.setOrderLineNo(i);
            orderLine.setItemCode(dbd.getSxh());
            orderLine.setPlanQty(dbd.getCs());
            orderLineList.add(orderLine);
            i++;
        }
        orderLines.setOrderLine(orderLineList);
        String orderLinesXml = XmlUtil.objToXml(orderLines);
        return "<request>" + returnOrderXml + orderLinesXml + "</request>";
    }
}
