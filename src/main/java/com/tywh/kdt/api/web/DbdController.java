package com.tywh.kdt.api.web;

import com.tywh.kdt.api.httpclient.HttpClientService;
import com.tywh.kdt.api.pojo.Dbd;
import com.tywh.kdt.api.pojo.DeliveryOrder;
import com.tywh.kdt.api.pojo.ReceiverInfo;
import com.tywh.kdt.api.pojo.SenderInfo;
import com.tywh.kdt.api.service.DbdService;
import com.tywh.kdt.api.service.common.ApiService;
import com.tywh.kdt.util.DateUtil;
import com.tywh.kdt.util.XmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/dbd")
public class DbdController {

    @Autowired
    private DbdService dbdService;

    @Autowired
    private ApiService apiService;

    @Autowired
    private HttpClientService httpClientService;

    @Value("${orderType.dbck}")
    private String dbckOrderType;

    @Value("${orderType.dbrk}")
    private String dbrkOrderType;

    @Value("${commonInfo.name}")
    private String name;

    @Value("${commonInfo.mobile}")
    private String mobile;

    @Value("${commonInfo.province}")
    private String province;

    @Value("${commonInfo.city}")
    private String city;

    @Value("${commonInfo.detailAddress}")
    private String detailAddress;

    @Value("${wms.ownerCode}")
    private String ownerCode;

    @RequestMapping("/pushDbd")
    public void pushDbd(String fhdbh) {
        try {
            Map<String, List<Dbd>> result = dbdService.queryDbdList(fhdbh);

            String dbck_method = "WDT_WMS_STOCKOUT_CREATE";
            for (Map.Entry<String,List<Dbd>> entry : result.entrySet()) {
                String key = entry.getKey();
                String deliveryOrderCode = entry.getValue().get(0).getFhdbh() + "-" + key;

                DeliveryOrder deliveryOrder = new DeliveryOrder();
                deliveryOrder.setDeliveryOrderCode(deliveryOrderCode);
                deliveryOrder.setOrderType(dbckOrderType);
                deliveryOrder.setWarehouseCode(key);
                deliveryOrder.setCreateTime(DateUtil.format(new Date()));
                deliveryOrder.setOwnerCode(ownerCode);
                deliveryOrder.setRemark(entry.getValue().get(0).getBz());

                ReceiverInfo receiverInfo = new ReceiverInfo(name, mobile, province, city, detailAddress);
                deliveryOrder.setReceiverInfo(receiverInfo);
                SenderInfo senderInfo = new SenderInfo(name, mobile, province, city, detailAddress);
                deliveryOrder.setSenderInfo(senderInfo);
                String deliveryOrderXml = XmlUtil.objToXml(deliveryOrder);



                String xmlBody = "";
                String url = apiService.makeUrl(dbck_method, xmlBody);
                httpClientService.doPost(url, xmlBody);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
