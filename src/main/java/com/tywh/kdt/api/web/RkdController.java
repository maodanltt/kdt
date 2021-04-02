package com.tywh.kdt.api.web;

import com.tywh.kdt.api.httpclient.HttpClientService;
import com.tywh.kdt.api.pojo.Goods;
import com.tywh.kdt.api.pojo.HttpClientResult;
import com.tywh.kdt.api.service.RkdService;
import com.tywh.kdt.api.service.common.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

/**
 *  其它入库接口，处理调拨入库、采购入库以外的入库，
 */

@Controller
@RequestMapping("/api/rkd")
public class RkdController {

    @Autowired
    private HttpClientService httpClientService;

    @Autowired
    private ApiService apiService;

    @Autowired
    private RkdService rkdService;

    @RequestMapping("/push")
    public void push() {

        String method = "WDT_WMS_ENTRYORDER_CREATE";
        String dh = "RKTZ202104020002";
        String warehouseCode = "00TH";
        List<Goods> list = Arrays.asList(new Goods("20170312",2),
                new Goods("20170364",3),
                new Goods("20170405",3),
                new Goods("20192058",1),
//                new Goods("20200775",31),
//                new Goods("W0001142",31),
//                new Goods("W0001143",31),
                new Goods("20200775",1));

        try {
            String xml = rkdService.createXml(dh,warehouseCode,list);
            String url = apiService.makeUrl(method, xml.replace(" ",""));
            HttpClientResult result = httpClientService.doPost(url, xml);
//            System.out.println(result.getStatusCode());
//            System.out.println(result.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
