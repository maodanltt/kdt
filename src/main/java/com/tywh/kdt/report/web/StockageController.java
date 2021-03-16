package com.tywh.kdt.report.web;

import com.tywh.kdt.report.pojo.QueryConditionStockage;
import com.tywh.kdt.report.pojo.ResultStockage;
import com.tywh.kdt.report.pojo.Stockage;
import com.tywh.kdt.report.service.StockageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/report")
public class StockageController {

    @Autowired
    private StockageService stockageService;

    @RequestMapping("/toStockage")
    public String toStockage(HttpServletRequest request) {
        //不从OA链接进去，session不为空， 在此显式声明获取一下试试后面能不能拿到同一个session
//        request.getSession(true);
        return "stockage";
    }

    @RequestMapping("/stockage")
    @ResponseBody
    public ResultStockage stockage(HttpServletRequest request,QueryConditionStockage queryConditionStockage) {
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
}