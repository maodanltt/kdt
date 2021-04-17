package com.tywh.kdt.api.service.impl;

import com.tywh.kdt.api.mapper.CgrkMapper;
import com.tywh.kdt.api.pojo.*;
import com.tywh.kdt.api.service.RkdService;
import com.tywh.kdt.util.DateUtil;
import com.tywh.kdt.util.XmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Autowired
    private CgrkMapper cgrkMapper;

    @Override
    public String createXml(String dh,String warehouseCode,List<Goods> list) throws Exception {

        EntryOrder entryOrder = new EntryOrder();
        entryOrder.setEntryOrderCode(dh);
        entryOrder.setRemark("科迪通采购入库");
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

    @Override
    public String createCgrkXml(String dh) throws Exception {
        List<Dbd> cgrkList = cgrkMapper.queryCgrkList(dh);

        EntryOrder entryOrder = new EntryOrder();
        entryOrder.setEntryOrderCode(dh);
        entryOrder.setRemark("科迪通采购入库");
        entryOrder.setOrderType(orderType);
        entryOrder.setOrderCreateTime(DateUtil.format(new Date()));
        entryOrder.setOwnerCode(ownerCode);
        entryOrder.setWarehouseCode(cgrkList.get(0).getKwbh());
        entryOrder.setReceiverInfo(receiverInfo);
        entryOrder.setSenderInfo(senderInfo);

        String entryOrderXml = XmlUtil.objToXml(entryOrder);

        OrderLines orderLines = new OrderLines();
        List<OrderLine> orderLineList = new ArrayList<>();
        int i = 1;
        for (Dbd dbd : cgrkList) {
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
        return "<request>" + entryOrderXml + orderLinesXml + "</request>";
    }

}
