package com.tywh.kdt.report.web;

import com.tywh.kdt.report.pojo.QueryCondition;
import com.tywh.kdt.report.pojo.Result;
import com.tywh.kdt.report.service.SalesDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/report")
public class SalesDetailController {

    @Autowired
    private SalesDetailService salesDetailService;

    @RequestMapping("/toSalesDetail")
    public String toSalesDetail() {
        return "salesDetail";
    }

    @RequestMapping("/toRkDetail")
    public String toRkDetail() {
        return "rkDetail";
    }

    @RequestMapping("/querySalesDetailList")
    @ResponseBody
    public Result querySalesDetailList(QueryCondition queryCondition) throws Exception{

        return salesDetailService.getSalesDetailList(queryCondition);
    }
}
