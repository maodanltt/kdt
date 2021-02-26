package com.tywh.kdt.report.web;

import com.tywh.kdt.report.pojo.WhcbQueryCondition;
import com.tywh.kdt.report.pojo.WhcbResult;
import com.tywh.kdt.report.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    @ResponseBody
    public WhcbResult queryItemList(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //获取请求参数
        String bjbmmc = request.getParameter("bjbmmc");
        String xsbmmc = request.getParameter("xsbmmc");
        String tsfljc = request.getParameter("tsfljc");
        String startdate = request.getParameter("startdate");
        String enddate = request.getParameter("enddate");
        //封装查询条件对象
        WhcbQueryCondition whcbQueryCondition = new WhcbQueryCondition();
        whcbQueryCondition.setBjbmmc(bjbmmc);
        whcbQueryCondition.setXsbmmc(xsbmmc);
        whcbQueryCondition.setTsfljc(tsfljc);
        whcbQueryCondition.setStartdate(startdate);
        whcbQueryCondition.setEnddate(enddate);
        //查询条件带回前端页面
        request.setAttribute("condition", whcbQueryCondition);
        //调用service处理
        WhcbResult whcbResult = itemService.queryItem(whcbQueryCondition);
        return whcbResult;
    }
}
