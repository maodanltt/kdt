package com.tywh.kdt.report.web;

import com.tywh.kdt.report.pojo.Condition;
import com.tywh.kdt.report.pojo.Item;
import com.tywh.kdt.report.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/toQueryItem")
    public String toQueryItem() {
        return "item";
    }

    @RequestMapping("/queryItemList")
    public String queryItemList(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //获取请求参数
        String bjbmmc = request.getParameter("bjbmmc");
        String xsbmmc = request.getParameter("xsbmmc");
        String tsfljc = request.getParameter("tsfljc");
        String startdate = request.getParameter("startdate");
        String enddate = request.getParameter("enddate");
        //封装查询条件对象
        Condition condition = new Condition();
        condition.setBjbmmc(bjbmmc);
        condition.setXsbmmc(xsbmmc);
        condition.setTsfljc(tsfljc);
        condition.setStartdate(startdate);
        condition.setEnddate(enddate);
        //查询条件带回前端页面
        request.setAttribute("condition",condition);
        //调用service处理
        Map<String,Object> retMap = itemService.queryItem(condition);
        List<Item> itemList = (List<Item>) retMap.get("itemList");
        //处理返回结果
        Integer zxscs = (Integer) retMap.get("zxscs");
        String zkczzl = (String) retMap.get("zkczzl");
        Integer zqckc = (Integer) retMap.get("zqckc");
        Integer zqmkc = (Integer) retMap.get("zqmkc");
        //设置到request ，转向页面
        request.setAttribute("itemList", itemList);
        request.setAttribute("zxscs", zxscs);
        request.setAttribute("zkczzl", zkczzl);
        request.setAttribute("zqckc", zqckc);
        request.setAttribute("zqmkc", zqmkc);
        return "item";
    }
}
