package com.tywh.kdt.util;


import com.tywh.kdt.api.httpclient.HttpClientService;
import org.apache.http.client.config.RequestConfig;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class HttpClientTest {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-httpClient.xml");
        HttpClientService service = (HttpClientService) beanFactory.getBean("httpClientService");
//        RequestConfig.Builder requestConfigBuilder = (RequestConfig.Builder) beanFactory.getBean("requestConfigBuilder");
//        RequestConfig requestConfig = (RequestConfig) beanFactory.getBean("requestConfig");
//        System.out.println("requestConfigBuilder");
        try {
            String str = service.doGet("http://www.baidu.com");
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
