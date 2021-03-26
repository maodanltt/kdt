package com.tywh.kdt.api.service.common;

import com.tywh.kdt.util.DateUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;

@Service
public class ApiService {

    @Value("${wms.address}")
    private String address;

    @Value("${wms.sid}")
    private String sid;

    @Value("${wms.appkey}")
    private String appkey;

    @Value("${wms.appsecret}")
    private String appsecret;

    @Value("${wms.sign_method}")
    private String sign_method;

    @Value("${wms.format}")
    private String format;

    private String makeSign(String timestamp,String method, String  xmlBody) {
        StringBuilder toMd5 = new StringBuilder();
        toMd5.append(appsecret);
        toMd5.append("appkey" + appkey);
        toMd5.append("format" + format);
        toMd5.append("method" + method);
        toMd5.append("sid" + sid);
        toMd5.append("sign_method" + sign_method);
        toMd5.append("timestamp" + timestamp);
        toMd5.append(xmlBody);
        toMd5.append(appsecret);
        String sign = DigestUtils.md5DigestAsHex(toMd5.toString().getBytes()).toUpperCase();
        return sign;
    }

    public String makeUrl(String method, String xmlBody ) {
        String timestamp = DateUtil.format(new Date()).replace(" ","");
        StringBuilder url = new StringBuilder(address);
        url.append("method=" + method + "&");
        url.append("sid=" + sid + "&");
        url.append("timestamp=" + timestamp + "&");
        url.append("format=" + format + "&");
        url.append("appkey=" + appkey + "&");
        url.append("sign_method=" + sign_method + "&");
        url.append("sign=" + this.makeSign(timestamp,method,xmlBody));
        return url.toString();
    }
}
