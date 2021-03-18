package com.tywh.kdt.report.web;

import com.alibaba.excel.EasyExcel;
import com.tywh.kdt.report.pojo.*;
import com.tywh.kdt.report.service.StockageService;
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
import java.util.Map;

@Controller
@RequestMapping("/report/stockage")
public class StockageController {

    @Autowired
    private StockageService stockageService;

    @RequestMapping("/page")
    public String page(HttpServletRequest request) {
        //不从OA链接进去，session不为空， 在此显式声明获取一下试试后面能不能拿到同一个session
//        request.getSession(true);
        return "stockage";
    }

    @RequestMapping("/list")
    @ResponseBody
    public ResultStockage list(HttpServletRequest request,QueryConditionStockage queryConditionStockage) {
        Map<String, Integer> rkDetailMap = (Map<String, Integer>) request.getSession(false).getAttribute("rkDetailMap");
        Map<String, Integer> pdDetailMap = (Map<String, Integer>) request.getSession(false).getAttribute("pdDetailMap");
        List<Stockage> stockageList = null;
        ResultStockage resultStockage = new ResultStockage();
        try {
            if (rkDetailMap == null) {
                rkDetailMap = stockageService.queryRkDetailMap();
                request.getSession(false).setAttribute("rkDetailMap",rkDetailMap);
            }

            if (pdDetailMap == null) {
                pdDetailMap = stockageService.queryPdDetailMap();
                request.getSession(false).setAttribute("pdDetailMap",pdDetailMap);
            }
            stockageList = stockageService.queryStorkageList(queryConditionStockage,rkDetailMap,pdDetailMap);
            resultStockage.setStockageList(stockageList);
            Map map = stockageService.queryTotalRecords(queryConditionStockage);
            resultStockage.setTotal((Integer) map.get("total"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultStockage;
    }

    @RequestMapping("/export")
    public void export(HttpServletRequest request, QueryConditionStockage queryConditionStockage, HttpServletResponse response) {
        Map<String, Integer> rkDetailMap = (Map<String, Integer>) request.getSession(false).getAttribute("rkDetailMap");
        Map<String, Integer> pdDetailMap = (Map<String, Integer>) request.getSession(false).getAttribute("pdDetailMap");
        List<Stockage> exportList = null;
        try {
            exportList = stockageService.queryAll(queryConditionStockage,rkDetailMap,pdDetailMap);
            String str = DateUtil.format(new Date()).replace(" ","-").replace(":","");
            String fileName = "库龄分析报表" + str + ".xlsx";
            response.setContentType("application/vnd.ms-excel; charset=utf-8");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" +  URLEncoder.encode(fileName,"utf-8"));
            EasyExcel.write(response.getOutputStream(),Stockage.class).sheet("库龄分析报表").doWrite(exportList);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
