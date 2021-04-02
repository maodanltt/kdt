package com.tywh.kdt.api.web;

import com.tywh.kdt.api.httpclient.HttpClientService;
import com.tywh.kdt.api.pojo.HttpClientResult;
import com.tywh.kdt.api.service.DbdService;
import com.tywh.kdt.api.service.common.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/api/dbd")
public class DbdController {

    @Autowired
    private DbdService dbdService;

    @Autowired
    private ApiService apiService;

    @Autowired
    private HttpClientService httpClientService;


    @RequestMapping("/push")
    public void pushDbd(String fhdbh) {
        try {
            String dbckMethod = "WDT_WMS_STOCKOUT_CREATE";
            List<String> dbckXmlList = dbdService.createDbckXmlList(fhdbh);
            for (String dbckXml : dbckXmlList) {
                String dbckXmlWithoutSpace = dbckXml.replace(" ","");
                //单据中的日期 必须有空格
                String dbckUrl = apiService.makeUrl(dbckMethod, dbckXmlWithoutSpace);
                HttpClientResult result = httpClientService.doPost(dbckUrl, dbckXml);
//                System.out.println("调拨出库----------------------------------------------》");
//                System.out.println(result.getStatusCode());
//                System.out.println(result.getBody());

            }

            String dbrkMethod = "WDT_WMS_ENTRYORDER_CREATE";
            String dbrkXml = dbdService.createDbrkXml(fhdbh);
            String dbrkXmlWithoutSpace = dbrkXml.replace(" ","");
            String dbrkUrl = apiService.makeUrl(dbrkMethod, dbrkXmlWithoutSpace);
            HttpClientResult result1 = httpClientService.doPost(dbrkUrl, dbrkXml);
//            System.out.println("调拨入库----------------------------------------------》");
//            System.out.println(result1.getStatusCode());
//            System.out.println(result1.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
