package com.tywh.kdt.api.web;

import com.tywh.kdt.api.httpclient.HttpClientService;
import com.tywh.kdt.api.pojo.Goods;
import com.tywh.kdt.api.pojo.HttpClientResult;
import com.tywh.kdt.api.service.GoodsService;
import com.tywh.kdt.api.service.common.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/api/goods")
public class GoodsController {

    @Autowired
    private HttpClientService httpClientService;

    @Autowired
    private ApiService apiService;

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/add")
    public void add(String sxh) throws IOException {

        Goods goods = goodsService.queryGoodsBySxh(sxh);
        String shuh = "";
        if (goods.getShuh().contains("ISBN") || goods.getShuh().contains("978")) {
            shuh = goods.getShuh().replace("ISBN","").replace(" ","").replace("-","");
        }
        String method = "WDT_WMS_SINGLEITEM_SYNCHRONIZE";
        String xml = "<request><actionType>add</actionType><ownerCode>tianyiWMS</ownerCode><warehouseCode>00HG</warehouseCode>" +
                "<item>" +
                "<itemCode>" + sxh + "</itemCode>" +
                "<itemName>" + goods.getShum().replace(" ","") + "</itemName>" +
                "<skuProperty>" + goods.getZbh().replace(" ","") + "</skuProperty>" +
                "<pcs>" + goods.getMbcs() + "</pcs>" +
                "<tagPrice_x0020_>" + goods.getGjdj() + "</tagPrice_x0020_>" +
                "<retailPrice>" + goods.getGjdj()  + "</retailPrice>" +
                "<costPrice_x0020_>" + goods.getGjdj()  + "</costPrice_x0020_>" +
                "<purchasePrice_x0020_>" + goods.getGjdj()  + "</purchasePrice_x0020_>" +
                "<barCode>" + sxh + "</barCode>" +
                "<itemType>ZC</itemType>" +
                "<extendProps>" +
                "<spec_property>" + goods.getMbcs() + "</spec_property>" +
                "<goodsprop2>" + shuh + "</goodsprop2>" +
                "<specprop2>" + shuh + "</specprop2>" +  //单品的自定义属性2
                "</extendProps>" +
                "</item>" +
                "</request>";
        String url = apiService.makeUrl(method, xml);
        HttpClientResult result = httpClientService.doPost(url, xml);
//        System.out.println(result.getStatusCode());
//        System.out.println(result.getBody());
    }

    @RequestMapping("/update")
    public void update(String sxh) throws IOException {

        Goods goods = goodsService.queryGoodsBySxh(sxh);
        String shuh = "";
        if (goods.getShuh().contains("ISBN") || goods.getShuh().contains("978")) {
            shuh = goods.getShuh().replace("ISBN","").replace(" ","").replace("-","");
        }
        String method = "WDT_WMS_SINGLEITEM_SYNCHRONIZE";
        String xml = "<request><actionType>update</actionType><ownerCode>tianyiWMS</ownerCode><warehouseCode>00HG</warehouseCode>" +
                "<item>" +
                "<itemCode>" + sxh + "</itemCode>" +
                "<itemName>" + goods.getShum().replace(" ","") + "</itemName>" +
                "<skuProperty>" + goods.getZbh().replace(" ","") + "</skuProperty>" +
                "<pcs>" + goods.getMbcs() + "</pcs>" +
                "<tagPrice_x0020_>" + goods.getGjdj() + "</tagPrice_x0020_>" +
                "<retailPrice>" + goods.getGjdj()  + "</retailPrice>" +
                "<costPrice_x0020_>" + goods.getGjdj()  + "</costPrice_x0020_>" +
                "<purchasePrice_x0020_>" + goods.getGjdj()  + "</purchasePrice_x0020_>" +
                "<barCode>" + sxh + "</barCode>" +
                "<itemType>ZC</itemType>" +
                "<extendProps>" +
                "<spec_property>" + goods.getMbcs() + "</spec_property>" +
                "<goodsprop2>" + shuh + "</goodsprop2>" +
                "<specprop2>" + shuh + "</specprop2>" +  //单品的自定义属性2
                "</extendProps>" +
                "</item>" +
                "</request>";
        String url = apiService.makeUrl(method, xml);
        HttpClientResult result = httpClientService.doPost(url, xml);
        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());
    }

    @RequestMapping("/test")
    public void test(HttpServletResponse response,String mc) throws IOException {

        response.getOutputStream().print("java:" + mc);

    }
}
