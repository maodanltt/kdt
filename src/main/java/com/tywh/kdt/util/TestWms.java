package com.tywh.kdt.util;

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
        String body = "<request><actionType>add</actionType><warehouseCode>00HG</warehouseCode><ownerCode>tianyiWMS</ownerCode><item>" +
                "<itemCode>19950025</itemCode><itemName>dingruomeng测试商品</itemName><barCode>19950025</barCode><itemType>ZC</itemType></item></request>";
        StringBuilder toMd5 = new StringBuilder();
        toMd5.append("312165b5977a9686efdc1411538ece69");
        toMd5.append("appkeywdt15996474952454");
        toMd5.append("formatxml");
        toMd5.append("methodWDT_WMS_SINGLEITEM_SYNCHRONIZE");
        toMd5.append("sidtianyiWMS");
        toMd5.append("sign_methodmd5");
        toMd5.append("timestamp2021-03-0916:41:30");
        toMd5.append(body);
        toMd5.append("312165b5977a9686efdc1411538ece69");
        String md5 = DigestUtils.md5DigestAsHex(toMd5.toString().getBytes()).toUpperCase();
        System.out.println(toMd5);
        System.out.println(md5);



    }
}
