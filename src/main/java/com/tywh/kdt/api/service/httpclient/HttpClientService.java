package com.tywh.kdt.api.service.httpclient;

import com.tywh.kdt.api.pojo.HttpClientResult;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

@Service
public class HttpClientService implements BeanFactoryAware {

    @Autowired
    private RequestConfig requestConfig;

    //因httpClient对象是多例，印次只能从工厂中拿，不能自动注入
    private BeanFactory beanFactory;


    //无参get请求
    public String doGet(String url) throws IOException {
        CloseableHttpClient httpClient = (CloseableHttpClient) this.beanFactory.getBean("httpClient");
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                return EntityUtils.toString(response.getEntity(), "utf-8");
            }
        } finally {
            if (response != null) {
                response.close();
            }
        }

        return null;
    }

    //有参get请求
    public String doGet(String url, Map<String, String> params) throws IOException, URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder(url);
        for (Map.Entry<String, String> entry : params.entrySet()) {
            uriBuilder.setParameter(entry.getKey(), entry.getValue());
        }
        return this.doGet(uriBuilder.build().toString());
    }

    //post请求  表单参数
    public HttpClientResult doPost(String url, Map<String, String> params) throws IOException {
        CloseableHttpClient httpClient = (CloseableHttpClient) this.beanFactory.getBean("httpClient");
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return new HttpClientResult(EntityUtils.toString(response.getEntity(), "utf-8"), response.getStatusLine().getStatusCode());
    }

    //post请求， xml参数
    public HttpClientResult doPost(String url, String xmlBody) throws IOException {
        CloseableHttpClient httpClient = (CloseableHttpClient) this.beanFactory.getBean("httpClient");
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            httpPost.setEntity(new StringEntity(xmlBody));
            response = httpClient.execute(httpPost);
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return new HttpClientResult(EntityUtils.toString(response.getEntity(), "utf-8"), response.getStatusLine().getStatusCode());
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }


}
