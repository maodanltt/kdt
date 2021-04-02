package com.tywh.kdt.api.service.impl;

import com.tywh.kdt.api.pojo.*;
import com.tywh.kdt.api.service.RkdService;
import com.tywh.kdt.util.DateUtil;
import com.tywh.kdt.util.XmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RkdServiceImpl implements RkdService {

    @Autowired
    private ReceiverInfo receiverInfo;

    @Autowired
    private SenderInfo senderInfo;

    @Value("${orderType.qtrk}")
    private String orderType;

    @Value("${wms.ownerCode}")
    private String ownerCode;

    @Override
    public String createXml(String dh,String warehouseCode,List<Goods> list) throws Exception {

        EntryOrder entryOrder = new EntryOrder();
        entryOrder.setEntryOrderCode(dh);
        entryOrder.setRemark("调整库存差异");
        entryOrder.setOrderType(orderType);
        entryOrder.setOrderCreateTime(DateUtil.format(new Date()));
        entryOrder.setOwnerCode(ownerCode);
        entryOrder.setWarehouseCode(warehouseCode);
        entryOrder.setReceiverInfo(receiverInfo);
        entryOrder.setSenderInfo(senderInfo);

        String entryOrderXml = XmlUtil.objToXml(entryOrder);

        OrderLines orderLines = new OrderLines();
        List<OrderLine> orderLineList = new ArrayList<>();
        int i = 1;
        for (Goods goods : list) {
            OrderLine orderLine = new OrderLine();
            orderLine.setOwnerCode(ownerCode);
            orderLine.setOrderLineNo(i);
            orderLine.setItemCode(goods.getSxh());
            orderLine.setPlanQty(goods.getCs());
            orderLineList.add(orderLine);
            i++;
        }
        orderLines.setOrderLine(orderLineList);
        String orderLinesXml = XmlUtil.objToXml(orderLines);
        return "<request>" + entryOrderXml + orderLinesXml + "</request>";
    }
}
