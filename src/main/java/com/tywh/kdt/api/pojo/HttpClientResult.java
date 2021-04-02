package com.tywh.kdt.api.pojo;

/**
 * httpClient 请求响应体
 */
public class HttpClientResult {

    private String body;

    private Integer statusCode;

    public HttpClientResult() {

    }

    public HttpClientResult(String body, Integer statusCode) {
        this.body = body;
        this.statusCode = statusCode;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
