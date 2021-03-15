package com.tywh.kdt.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.util.DigestUtils;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestWms {
//    public static void main(String[] args) throws Exception {


//        String time = DateUtil.format(new Date());
//        StringBuilder data = new StringBuilder();
//        data.append("https://wmsapi.wdtwms.com/wms_api/wdt_service.php?");
//        data.append("method=WDT_WMS_SINGLEITEM_SYNCHRONIZE&");
//        data.append("timestamp=" + time + "&");
//        data.append("format=xml&");
//        data.append("appkey=wdt15996474952454&");
//        data.append("sign_method=md5&");
//        data.append("sid=tianyiWMS&");
//        data.append("sign=" + createSign(time.replace(" " , "")));
//        String dataUtf8 = new String(data.toString().getBytes(), "utf-8");
//        String url = "https://wmsapi.wdtwms.com/wms_api/wdt_service.php?" + data.toString();
//        try {
//            invokeHttpGet(url);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        //post请求
//        String timestamp = DateUtil.format(new Date());
//        System.out.println(timestamp);
//        String body = "<request><actionType>update</actionType><warehouseCode>00HG</warehouseCode><item>" +
//                "<itemCode>19950025</itemCode><itemName>drmtest</itemName><barCode>19950025</barCode><itemType>ZC</itemType></item></request>";
//        try {
//            invokeHttpPost(timestamp, createSign(timestamp,body),body);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//    }

    //生成签名
    private static String createSign(String timestamp, String body) {

        StringBuilder toMd5 = new StringBuilder();
        toMd5.append("312165b5977a9686efdc1411538ece69");
        toMd5.append("appkeywdt15996474952454");
        toMd5.append("formatxml");
        toMd5.append("methodWDT_WMS_SINGLEITEM_SYNCHRONIZE");
        toMd5.append("sidtianyiWMS");
        toMd5.append("sign_methodmd5");
        toMd5.append("timestamp" + timestamp.replace(" ", ""));
        toMd5.append(body);
        toMd5.append("312165b5977a9686efdc1411538ece69");
        String sign = DigestUtils.md5DigestAsHex(toMd5.toString().getBytes()).toUpperCase();
        System.out.println(toMd5);
        System.out.println(sign);
        return sign;
    }

    //get请求
    private static void invokeHttpGet(String url) throws Exception{
        System.out.println(url);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        URLEncoder.encode(url, "UTF-8");
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        if(response.getStatusLine().getStatusCode()==200){
            HttpEntity entity = response.getEntity();
            //使用工具类EntityUtils，从响应中取出实体表示的内容并转换成字符串
            String string = EntityUtils.toString(entity, "utf-8");
            System.out.println(string);
        }
        response.close();
        httpClient.close();

    }

    //post请求
    private static void invokeHttpPost(String timestamp, String sign, String body) throws Exception {
        String url = "https://wmsapi.wdtwms.com/wms_api/wdt_service.php?";
        StringBuilder commonParam = new StringBuilder();
        commonParam.append("method=WDT_WMS_SINGLEITEM_SYNCHRONIZE&sid=tianyiWMS&");
        commonParam.append("timestamp=" + timestamp.replace(" ","") + "&");
        commonParam.append("format=xml&appkey=wdt15996474952454&");
        commonParam.append("sign_method=md5&sign=" + sign);

        String address = url + commonParam.toString();
        //1.打开浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //2.声明post请求
        HttpPost httpPost = new HttpPost(address);

        HttpEntity entity = new StringEntity(body);
        httpPost.setEntity(entity);
        //5.发送请求
        CloseableHttpResponse response = httpClient.execute(httpPost);

        if(response.getStatusLine().getStatusCode()==200){
            String string = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(string);
        }
        //6.关闭资源
        response.close();
        httpClient.close();
    }
}
