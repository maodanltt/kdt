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

    @RequestMapping("/cytz")
    public void rktz(String dh, String sxh, Integer cs,String warehouseCode) {

        String method = "WDT_WMS_ENTRYORDER_CREATE";
        List<Goods> list = Arrays.asList(new Goods(sxh,cs));

        try {
            String bz = "调整差异";
            String xml = rkdService.createXml(dh,warehouseCode,list,bz);
            String url = apiService.makeUrl(method, xml.replace(" ",""));
            HttpClientResult result = httpClientService.doPost(url, xml);
//            System.out.println(result.getStatusCode());
//            System.out.println(result.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("/cytzlist")
    public void rktzlist() {

        String method = "WDT_WMS_ENTRYORDER_CREATE";
        List<Goods> list = Arrays.asList(
                new Goods("20170000",0)

        );

        try {
            String dh = "";
            String warehouseCode = "";
            String bz = "调整差异";
            String xml = rkdService.createXml(dh,warehouseCode,list,bz);
            String url = apiService.makeUrl(method, xml.replace(" ",""));
            HttpClientResult result = httpClientService.doPost(url, xml);
//            System.out.println(result.getStatusCode());
//            System.out.println(result.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 处理科迪通采购入库单
     * @param dh
     */

    @RequestMapping("/cgrk")
    public void cgrk(String dh) {

        String method = "WDT_WMS_ENTRYORDER_CREATE";

        try {
            String xml = rkdService.createCgrkXml(dh);
            String url = apiService.makeUrl(method, xml.replace(" ",""));
            HttpClientResult result = httpClientService.doPost(url, xml);
//            System.out.println(result.getStatusCode());
//            System.out.println(result.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/shrk")
    public void shrk(String dh) {

        String method = "WDT_WMS_ENTRYORDER_CREATE";

        try {
            String xml = rkdService.createShrkXml(dh);
            String url = apiService.makeUrl(method, xml.replace(" ",""));
            HttpClientResult result = httpClientService.doPost(url, xml);
//            System.out.println(result.getStatusCode());
//            System.out.println(result.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
