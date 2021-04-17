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

    @RequestMapping("/rktz")
    public void rktz() {

        String method = "WDT_WMS_ENTRYORDER_CREATE";
        String dh = "CGRK20210000016";
        String warehouseCode = "00BF";
        List<Goods> list = Arrays.asList(new Goods("W0000771",300),
                new Goods("W0000772",300),
                new Goods("W0000773",300),
                new Goods("W0000774",300),
                new Goods("W0000775",300),
//                new Goods("20171894",1562),
//                new Goods("20171675",2003),
//                new Goods("20171286",6),
//                new Goods("20202234",3),
//                new Goods("20201968",12),
//                new Goods("20201318",20),
//                new Goods("20201299",11),
//                new Goods("20200804",1),
//                new Goods("20200802",1),
//                new Goods("20200435",137),
//                new Goods("20200433",30),
//                new Goods("20200067",90),
                new Goods("W0000776",300)

        );

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
//            HttpClientResult result = httpClientService.doPost(url, xml);
//            System.out.println(result.getStatusCode());
//            System.out.println(result.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
