package com.tywh.kdt.api.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tywh.kdt.api.httpclient.HttpClientService;
import com.tywh.kdt.api.pojo.Goods;
import com.tywh.kdt.api.pojo.HttpClientResult;
import com.tywh.kdt.api.service.GoodsService;
import com.tywh.kdt.api.service.common.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/api/goods")
public class GoodsController {

    @Autowired
    private HttpClientService httpClientService;

    @Autowired
    private ApiService apiService;

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/updateGoods")
    public void updateGoods() throws IOException {

        Goods goods = goodsService.queryGoodsBySxh("19950025");
        String method = "WDT_WMS_SINGLEITEM_SYNCHRONIZE";
        String xmlBody = "<request><actionType>update</actionType><warehouseCode>00HG</warehouseCode><item>" +
                "<itemCode>19950025</itemCode><itemName>drmtest0315</itemName><barCode>19950025</barCode><itemType>ZC</itemType></item></request>";
        String url = apiService.makeUrl(method, xmlBody);
        HttpClientResult result = httpClientService.doPost(url, xmlBody);
        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());
    }
}