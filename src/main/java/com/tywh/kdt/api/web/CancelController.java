package com.tywh.kdt.api.web;

import com.tywh.kdt.api.httpclient.HttpClientService;
import com.tywh.kdt.api.pojo.HttpClientResult;
import com.tywh.kdt.api.service.common.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 请求旺店通取消已推送的单据，设置单据状态为已取消
 */
@Controller
@RequestMapping("/api")
public class CancelController {

    @Autowired
    private ApiService apiService;

    @Autowired
    private HttpClientService httpClientService;

    @RequestMapping("/cancel")
    public void cancel(String orderCode, String warehouseCode) {

        String method = "WDT_WMS_ORDER_CANCEL";
        StringBuilder builder = new StringBuilder();
        builder.append("<request>");
        builder.append("<warehouseCode>");
        builder.append(warehouseCode);
        builder.append("</warehouseCode>");
        builder.append("<orderCode>");
        builder.append(orderCode);
        builder.append("</orderCode>");
        builder.append("<orderType>JYCK</orderType>");
        builder.append("</request>");
        String xml = builder.toString();
        String url = apiService.makeUrl(method, xml);
        try {
            HttpClientResult result = httpClientService.doPost(url, xml);
//            System.out.println("接口取消服务----------------------------------------------》");
//            System.out.println(result.getStatusCode());
//            System.out.println(result.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
