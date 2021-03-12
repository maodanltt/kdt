package com.tywh.kdt.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.util.DigestUtils;

public class HttpClientTest {

    public static void main(String[] args) throws Exception{
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpGet httpGet = new HttpGet("http://www.baidu.com");
//
//        CloseableHttpResponse response = httpClient.execute(httpGet);
//        if(response.getStatusLine().getStatusCode()==200){
//            HttpEntity entity = response.getEntity();
//            //使用工具类EntityUtils，从响应中取出实体表示的内容并转换成字符串
//            String string = EntityUtils.toString(entity, "utf-8");
//            System.out.println(string);
//        }
//        //5.关闭资源
//        response.close();
//        httpClient.close();
        String sign1 = DigestUtils.md5DigestAsHex("xyzappkeytestformatjsonmethodtrade.weightsidwms_testsign_methodmd5timestamp2017-07-26 00:00:07{\"logistics_no\":\"tongdao1\",\"weight\":337}xyz".getBytes()).toUpperCase();
        System.out.println(sign1);
        String sign2 = DigestUtils.md5DigestAsHex("xyzappkeytestformatjsonmethodtrade.weightsidwms_testsign_methodmd5timestamp2017-07-2600:00:07{\"logistics_no\":\"tongdao1\",\"weight\":337}xyz".getBytes()).toUpperCase();
        System.out.println(sign2);
    }

}
