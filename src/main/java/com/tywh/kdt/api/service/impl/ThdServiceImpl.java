package com.tywh.kdt.api.service.impl;

import com.tywh.kdt.api.mapper.ThdMapper;
import com.tywh.kdt.api.pojo.*;
import com.tywh.kdt.api.service.ThdService;
import com.tywh.kdt.util.XmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ThdServiceImpl implements ThdService {

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
        //退货人信息
        SenderInfo senderInfo = new SenderInfo();
        senderInfo.setName(thdList.get(0).getKhmc());
        senderInfo.setMobile("0371-65791837");
        senderInfo.setProvince(".");
        senderInfo.setCity(".");
        senderInfo.setDetailAddress(thdList.get(0).getShdz());
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
