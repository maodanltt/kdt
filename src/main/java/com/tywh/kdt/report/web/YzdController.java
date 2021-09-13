package com.tywh.kdt.report.web;

import com.alibaba.excel.EasyExcel;
import com.tywh.kdt.report.pojo.*;
import com.tywh.kdt.report.service.StockageService;
import com.tywh.kdt.report.service.YzdService;
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
@RequestMapping("/report/yzd")
public class YzdController {

    @Autowired
    private YzdService yzdService;

    @RequestMapping("/page")
    public String page(HttpServletRequest request) {

        return "yzd";
    }

    @RequestMapping("/list")
    @ResponseBody
    public ResultYzd list(QueryConditionYzd queryConditionYzd) throws Exception{

        List<Yzd> list = yzdService.queryYzdList(queryConditionYzd);
        ResultYzd resultYzd = new ResultYzd();
        resultYzd.setList(list);

        Map<String, Integer> map = yzdService.queryTotalRecords(queryConditionYzd);
        resultYzd.setTotal(map.get("total"));
        return resultYzd;
    }

}
