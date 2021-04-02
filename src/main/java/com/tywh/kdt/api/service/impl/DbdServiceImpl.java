package com.tywh.kdt.api.service.impl;

import com.tywh.kdt.api.mapper.DbdMapper;
import com.tywh.kdt.api.pojo.*;
import com.tywh.kdt.api.service.DbdService;
import com.tywh.kdt.util.DateUtil;
import com.tywh.kdt.util.XmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DbdServiceImpl implements DbdService {

    @Autowired
    private ReceiverInfo receiverInfo;

    @Autowired
    private SenderInfo senderInfo;

    @Autowired
    private DbdMapper dbdMapper;

    @Value("${orderType.dbck}")
    private String dbckOrderType;

    @Value("${orderType.dbrk}")
    private String dbrkOrderType;

    @Value("${wms.ownerCode}")
    private String ownerCode;


    @Override
    public List<String> createDbckXmlList(String fhdbh) throws Exception {
        List<Dbd> list = this.dbdMapper.queryDbckList(fhdbh);
        Map<String, List<Dbd>> map = this.queryDbckMap(list);
        List<String> xmlList = new ArrayList<>();

        for (Map.Entry<String, List<Dbd>> entry : map.entrySet()) {
            String key = entry.getKey();
            String deliveryOrderCode = entry.getValue().get(0).getFhdbh() + "-" + key;

            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setDeliveryOrderCode(deliveryOrderCode);
            deliveryOrder.setOrderType(dbckOrderType);
            deliveryOrder.setWarehouseCode(key);
            deliveryOrder.setCreateTime(DateUtil.format(new Date()));
            deliveryOrder.setOwnerCode(ownerCode);
            deliveryOrder.setRemark(entry.getValue().get(0).getBz().replace("，",",").replace(" ",""));
            deliveryOrder.setReceiverInfo(receiverInfo);
            deliveryOrder.setSenderInfo(senderInfo);
            String deliveryOrderXml = XmlUtil.objToXml(deliveryOrder);

            OrderLines orderLines = new OrderLines();
            List<OrderLine> orderLineList = new ArrayList<>();

            List<Dbd> dbdList = entry.getValue();
            int i = 1;
            for (Dbd dbd : dbdList) {
                OrderLine orderLine = new OrderLine();
                orderLine.setOrderLineNo(i);
                orderLine.setItemCode(dbd.getSxh());
                orderLine.setPlanQty(dbd.getCs());
                orderLineList.add(orderLine);
                i++;
            }
            orderLines.setOrderLine(orderLineList);
            String orderLinesXml = XmlUtil.objToXml(orderLines);

            String xml = "<request>" + deliveryOrderXml + orderLinesXml + "</request>";
            xmlList.add(xml);

        }
        return xmlList;
    }

    @Override
    public String createDbrkXml(String fhdbh) throws Exception {
        List<Dbd> list = this.dbdMapper.queryDbrkList(fhdbh);

        EntryOrder entryOrder = new EntryOrder();
        entryOrder.setEntryOrderCode(list.get(0).getFhdbh());
        entryOrder.setRemark(list.get(0).getBz().replace("，",",").replace(" ",""));
        entryOrder.setOrderType(dbrkOrderType);
        entryOrder.setOrderCreateTime(DateUtil.format(new Date()));
        entryOrder.setOwnerCode(ownerCode);
        entryOrder.setWarehouseCode(list.get(0).getDjkwbh());
        entryOrder.setReceiverInfo(receiverInfo);
        entryOrder.setSenderInfo(senderInfo);

        String  entryOrderXml = XmlUtil.objToXml(entryOrder);

        OrderLines orderLines = new OrderLines();
        List<OrderLine> orderLineList = new ArrayList<>();
        int i = 1;
        for (Dbd dbd : list) {
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

    //查询科迪通调拨单，按出库库位是否相同封装到MAP中
    private Map<String, List<Dbd>> queryDbckMap(List<Dbd> dbdList) throws Exception {
        Map<String, List<Dbd>> result = new HashMap<>();

        for (int i=0; i<dbdList.size(); i++) {
            if (i == 0) {
                List<Dbd> list = new ArrayList<>();
                list.add(dbdList.get(0));
                result.put(dbdList.get(0).getKwbh(),list);
            }

            if (i > 0 && result.containsKey(dbdList.get(i).getKwbh())) {
                result.get(dbdList.get(i).getKwbh()).add(dbdList.get(i));
            } else if (i > 0 && !result.containsKey(dbdList.get(i).getKwbh())) {
                List<Dbd> list1 = new ArrayList<>();
                list1.add(dbdList.get(i));
                result.put(dbdList.get(i).getKwbh(),list1);
            }
        }
        return result;
    }

}
