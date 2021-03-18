package com.tywh.kdt.report.web;

import com.alibaba.excel.EasyExcel;
import com.tywh.kdt.report.pojo.*;
import com.tywh.kdt.report.service.ItemService;
import com.tywh.kdt.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/report/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/page")
    public String toQueryItem() {
        return "item";
    }

    @RequestMapping("/list")
    @ResponseBody
    public ResultWhcb list(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //获取请求参数
        String bjbmmc = request.getParameter("bjbmmc");
        String xsbmmc = request.getParameter("xsbmmc");
        String tsfljc = request.getParameter("tsfljc");
        String startdate = request.getParameter("startdate");
        String enddate = request.getParameter("enddate");
        //封装查询条件对象
        QueryConditionWhcb queryConditionWhcb = new QueryConditionWhcb();
        queryConditionWhcb.setBjbmmc(bjbmmc);
        queryConditionWhcb.setXsbmmc(xsbmmc);
        queryConditionWhcb.setTsfljc(tsfljc);
        queryConditionWhcb.setStartdate(startdate);
        queryConditionWhcb.setEnddate(enddate);
        //查询条件带回前端页面
//        request.setAttribute("condition", queryConditionWhcb);
        //调用service处理
        ResultWhcb resultWhcb = itemService.queryItem(queryConditionWhcb);
        return resultWhcb;
    }

    @RequestMapping("/export")
    public void export(HttpServletRequest request, HttpServletResponse response) {
        //获取请求参数
        String bjbmmc = request.getParameter("bjbmmc");
        String xsbmmc = request.getParameter("xsbmmc");
        String tsfljc = request.getParameter("tsfljc");
        String startdate = request.getParameter("startdate");
        String enddate = request.getParameter("enddate");
        //封装查询条件对象
        QueryConditionWhcb queryConditionWhcb = new QueryConditionWhcb();
        queryConditionWhcb.setBjbmmc(bjbmmc);
        queryConditionWhcb.setXsbmmc(xsbmmc);
        queryConditionWhcb.setTsfljc(tsfljc);
        queryConditionWhcb.setStartdate(startdate);
        queryConditionWhcb.setEnddate(enddate);
        //调用service处理
        try {
            ResultWhcb resultWhcb = itemService.queryItem(queryConditionWhcb);
            List<Item> itemList = resultWhcb.getItemList();
            String str = DateUtil.format(new Date()).replace(" ", "-").replace(":", "");
            String fileName = "库存周转率报表" + str + ".xlsx";
            response.setContentType("application/vnd.ms-excel; charset=utf-8");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" +  URLEncoder.encode(fileName,"utf-8"));
            EasyExcel.write(response.getOutputStream(), Item.class).sheet("库存周转率报表").doWrite(itemList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

