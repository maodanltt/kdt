package com.tywh.kdt.api.web;

import com.tywh.kdt.api.httpclient.HttpClientService;
import com.tywh.kdt.api.pojo.Dbd;
import com.tywh.kdt.api.pojo.HttpClientResult;
import com.tywh.kdt.api.service.DbdService;
import com.tywh.kdt.api.service.common.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


    @RequestMapping("/pushDbd")
    public void pushDbd(String fhdbh) {
        try {
            String dbck_method = "WDT_WMS_STOCKOUT_CREATE";
            List<String> dbckXmlList = dbdService.createDbckXmlBodyList(fhdbh);
            for (String dbckXmlStr : dbckXmlList) {
                String xmlBody = dbckXmlStr.replace(" ","");
                //单据中的日期 必须有空格
                String dbckUrl = apiService.makeUrl(dbck_method, xmlBody);
                HttpClientResult result = httpClientService.doPost(dbckUrl, dbckXmlStr);
                System.out.println("调拨出库----------------------------------------------》");
                System.out.println(result.getStatusCode());
                System.out.println(result.getBody());

            }

            String dbrk_method = "WDT_WMS_ENTRYORDER_CREATE";
            String dbrkXmlStr = dbdService.createDbrkXmlBody(fhdbh);
            String xmlBody = dbrkXmlStr.replace(" ","");
            String dbrkUrl = apiService.makeUrl(dbrk_method, xmlBody);
            HttpClientResult result1 = httpClientService.doPost(dbrkUrl, dbrkXmlStr);
            System.out.println("调拨入库----------------------------------------------》");
            System.out.println(result1.getStatusCode());
            System.out.println(result1.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/queryDbckXmlList")
    @ResponseBody
    public List<String> queryDbckXmlList(String fhdbh) {
        try {
            List<String> dbckXmlList = dbdService.createDbckXmlBodyList(fhdbh);
            return dbckXmlList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @RequestMapping("/queryDbrkXml")
    @ResponseBody
    public String queryDbrkXml(String fhdbh) {
        try {
            String dbrkXmlBody = dbdService.createDbrkXmlBody(fhdbh);
            System.out.println(dbrkXmlBody);
            return dbrkXmlBody;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
