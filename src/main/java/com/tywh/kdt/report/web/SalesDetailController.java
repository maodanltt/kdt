package com.tywh.kdt.report.web;

import com.tywh.kdt.report.pojo.QueryCondition;
import com.tywh.kdt.report.pojo.Result;
import com.tywh.kdt.report.service.SalesDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/report/salesdetail")
public class SalesDetailController {

    @Autowired
    private SalesDetailService salesDetailService;

    @RequestMapping("/page")
    public String toSalesDetail(HttpServletRequest request) {
        //不从OA链接进去，session不为空， 在此显式声明获取一下试试后面能不能拿到同一个session
//        request.getSession(true);
        return "salesDetail";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Result querySalesDetailList(QueryCondition queryCondition) throws Exception{

        return salesDetailService.querySalesDetailList(queryCondition);
    }
}
