package com.tywh.kdt.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.util.DigestUtils;

public class TestWms {
    public static void main(String[] args) {
//        String md5Str = DigestUtils.md5DigestAsHex("丁若蒙".getBytes());
//        System.out.println(md5Str);

        /*
        <add key="ownerCode" value="tianyiWMS" />
        <add key="orderType" value="CGRK" />
        <add key="warehouseCode" value="00HG" />
        <add key="sid" value="tianyiWMS" />
        <add key="appkey" value="wdt15996474952454" />
        <add key="appsecret" value="312165b5977a9686efdc1411538ece69" />
        <add key="sign_method" value="md5" />
        <add key="format" value="xml" />
        <add key="url" value="https://wmsapi.wdtwms.com/wms_api/wdt_service.php" />

        https://wmsapi.wdtwms.com/wms_api/wdt_service.php?method=WDT_WMS_SINGLEITEM_SYNCHRONIZE&
        timestamp=2021-03-09 16:41:30&format=xml&appkey=wdt15996474952454&sign_method=md5&sid=tianyiWMS
        &sign=43A8D04D5A54AE182D144AFA1C7C4D96
         */

        String time = "2021-03-1017:01:05";
        StringBuilder url = new StringBuilder();
        url.append("https://wmsapi.wdtwms.com/wms_api/wdt_service.php?");
        url.append("method=WDT_WMS_SINGLEITEM_SYNCHRONIZE&");
        url.append("timestamp=" + time + "&");
        url.append("format=xml&");
        url.append("appkey=wdt15996474952454&");
        url.append("sign_method=md5&");
        url.append("sid=tianyiWMS&");
        url.append("sign=" + createMd5(time));
        try {
            invokeInterface(url.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String createMd5(String time) {
        String body = "<request><actionType>add</actionType><warehouseCode>00HG</warehouseCode><ownerCode>tianyiWMS</ownerCode><item>" +
                "<itemCode>19950025</itemCode><itemName>dingruomeng测试商品</itemName><barCode>19950025</barCode><itemType>ZC</itemType></item></request>";
        StringBuilder toMd5 = new StringBuilder();
        toMd5.append("312165b5977a9686efdc1411538ece69");
        toMd5.append("appkeywdt15996474952454");
        toMd5.append("formatxml");
        toMd5.append("methodWDT_WMS_SINGLEITEM_SYNCHRONIZE");
        toMd5.append("sidtianyiWMS");
        toMd5.append("sign_methodmd5");
        toMd5.append("timestamp" + time);
        toMd5.append(body);
        toMd5.append("312165b5977a9686efdc1411538ece69");
        String md5 = DigestUtils.md5DigestAsHex(toMd5.toString().getBytes()).toUpperCase();
        System.out.println(toMd5);
        System.out.println(md5);
        return md5;
    }

    private static void invokeInterface(String url) throws Exception{
        System.out.println(url);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);

        CloseableHttpResponse response = httpClient.execute(httpGet);
        if(response.getStatusLine().getStatusCode()==200){
            HttpEntity entity = response.getEntity();
            //使用工具类EntityUtils，从响应中取出实体表示的内容并转换成字符串
            String string = EntityUtils.toString(entity, "utf-8");
            System.out.println(string);
        }
        //5.关闭资源
        response.close();
        httpClient.close();

    }
}
