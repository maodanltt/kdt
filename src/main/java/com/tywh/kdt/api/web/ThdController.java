package com.tywh.kdt.api.web;

import com.tywh.kdt.api.httpclient.HttpClientService;
import com.tywh.kdt.api.pojo.HttpClientResult;
import com.tywh.kdt.api.service.ThdService;
import com.tywh.kdt.api.service.common.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/thd")
public class ThdController {

    @Autowired
    private ThdService thdService;

    @Autowired
    private ApiService apiService;

    @Autowired
    private HttpClientService httpClientService;

    @RequestMapping("/push")
    public void pushThd(String dh) {

        String method = "WDT_WMS_RETURNORDER_CONFIRM";

        try {
            String xml = thdService.createXml(dh);
            System.out.println(xml);
            String url = apiService.makeUrl(method, xml.replace(" ",""));
            HttpClientResult result = httpClientService.doPost(url, xml);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
