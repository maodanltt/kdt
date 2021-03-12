package com.tywh.kdt.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
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
    public static void main(String[] args) throws Exception {
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
        timestamp=2021-03-0916:41:30&format=xml&appkey=wdt15996474952454&sign_method=md5&sid=tianyiWMS
        &sign=43A8D04D5A54AE182D144AFA1C7C4D96
         */

        String time = DateUtil.format(new Date());
        StringBuilder data = new StringBuilder();
//        url.append("https://wmsapi.wdtwms.com/wms_api/wdt_service.php?");
        data.append("method=WDT_WMS_SINGLEITEM_SYNCHRONIZE&");
        data.append("timestamp=" + URLEncoder.encode(time,"utf-8") + "&");
        data.append("format=xml&");
        data.append("appkey=wdt15996474952454&");
        data.append("sign_method=md5&");
        data.append("sid=tianyiWMS&");
//        String body = "<request><actionType>add</actionType><warehouseCode>00HG</warehouseCode><item>" +
//                "<itemCode>19950025</itemCode><itemName>drmtest</itemName><barCode>19950025</barCode><itemType>ZC</itemType></item></request>";
        String body = "{\"actionType\":\"add\",\"warehouseCode\":\"00HG\",\"item\":{\"itemCode\":\"19950025\",\"itemName\":\"drmtest\",\"barCode\":\"19950025\",\"itemType\":\"ZC\"}}";
//        data.append("body="+URLEncoder.encode(body,"utf-8")+"&");
        data.append("sign=" + createSign(time.replace(" " , "")));
//        String dataUtf8 = new String(data.toString().getBytes(), "utf-8");
        String url = "https://wmsapi.wdtwms.com/wms_api/wdt_service.php?" + data.toString();
        try {
            invokeHttpGet(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String timestamp = DateUtil.format(new Date());
        System.out.println(timestamp);
//        try {
//            invokeHttpPost(timestamp, createSign(timestamp.replace(" " , "")));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }

    //生成签名
    private static String createSign(String time) {
//        //<ownerCode>tianyiWMS</ownerCode>
//        String body = "<request><actionType>add</actionType><warehouseCode>00HG</warehouseCode><item>" +
//                "<itemCode>19950025</itemCode><itemName>drmtest</itemName><barCode>19950025</barCode><itemType>ZC</itemType></item></request>";
        String body = "{\"actionType\":\"add\",\"warehouseCode\":\"00HG\",\"item\":{\"itemCode\":\"19950025\",\"itemName\":\"drmtest\",\"barCode\":\"19950025\",\"itemType\":\"ZC\"}}";
        StringBuilder toMd5 = new StringBuilder();
        toMd5.append("312165b5977a9686efdc1411538ece69");
        toMd5.append("appkeywdt15996474952454");
        toMd5.append("appsecret312165b5977a9686efdc1411538ece69");
        toMd5.append("formatxml");
        toMd5.append("methodWDT_WMS_SINGLEITEM_SYNCHRONIZE");
        toMd5.append("sidtianyiWMS");
        toMd5.append("sign_methodmd5");
        toMd5.append("timestamp" + time);
//        toMd5.append(body);
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
    private static void invokeHttpPost(String timestamp, String sign) throws Exception {
        //1.打开浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //2.声明get请求
        HttpPost httpPost = new HttpPost("https://wmsapi.wdtwms.com/wms_api/wdt_service.php");
        //3.开源中国为了安全，防止恶意攻击，在post请求中都限制了浏览器才能访问
//        httpPost.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");

//        httpPost.setHeader("content-type","application/x-www-form-urlencoded;charset=utf-8");
        //4.判断状态码
        List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
        parameters.add(new BasicNameValuePair("method", "WDT_WMS_SINGLEITEM_SYNCHRONIZE"));
        parameters.add(new BasicNameValuePair("sid", "tianyiWMS"));
        parameters.add(new BasicNameValuePair("timestamp", timestamp));
        parameters.add(new BasicNameValuePair("format", "xml"));
        parameters.add(new BasicNameValuePair("appkey", "wdt15996474952454"));
        parameters.add(new BasicNameValuePair("sign_method", "md5"));
        parameters.add(new BasicNameValuePair("sign", sign));

        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters,"UTF-8");

        URLEncoder.encode("", "utf-8");

        httpPost.setEntity(formEntity);
        //5.发送请求
        CloseableHttpResponse response = httpClient.execute(httpPost);

        if(response.getStatusLine().getStatusCode()==200){
            HttpEntity entity = response.getEntity();
            String string = EntityUtils.toString(entity, "utf-8");
            System.out.println(string);
        }
        //6.关闭资源
        response.close();
        httpClient.close();
    }
}
