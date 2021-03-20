package com.tywh.kdt.report.service.impl;
import com.tywh.kdt.report.mapper.SalesDetailMapper;
import com.tywh.kdt.report.pojo.Inventory;
import com.tywh.kdt.report.pojo.QueryCondition;
import com.tywh.kdt.report.pojo.Result;
import com.tywh.kdt.report.pojo.SalesDetail;
import com.tywh.kdt.report.service.SalesDetailService;
import com.tywh.kdt.report.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SalesDetailServiceImpl implements SalesDetailService {

    @Autowired
    private SalesDetailMapper salesDetailMapper;

    @Autowired
    private SearchService searchService;

    @Override
    public Result querySalesDetailList(QueryCondition queryCondition) throws Exception{
        List<SalesDetail> salesDetailList = salesDetailMapper.querySalesDetailList(queryCondition);
        List<Inventory> kucunList = searchService.queryKucunList();
        if (salesDetailList != null) {
            for (SalesDetail salesDetail : salesDetailList) {
                if (salesDetail.getZbh() != null && salesDetail.getZbh().length() >= 12) {
                    salesDetail.setYc(salesDetail.getZbh().substring(salesDetail.getZbh().length() -5));
                } else {
                    salesDetail.setYc("");
                }

                if (salesDetail.getDqjl() == null && salesDetail.getXsflmc() != null) {
                    salesDetail.setDqjl(salesDetail.getXsflmc().split("-")[0]);
                }  else if (salesDetail.getDqjl() == null && salesDetail.getXsflmc() == null && salesDetail.getDq() == "样书") {
                    salesDetail.setDqjl("未知");
                } else if (salesDetail.getDq() == null) {
                    salesDetail.setDq("未知");
                    salesDetail.setDqjl("未知");
                }

                for (Inventory inventory : kucunList) {
                    if (salesDetail.getSxh().equals(inventory.getSxh())) {
                        salesDetail.setQmkc(inventory.getQmkc());
                    }
                }
            }
        }

        Result result = new Result();
        Map map = queryTotalRecords(queryCondition);
        result.setTotal((Integer)map.get("total"));
        if ((Integer)map.get("total") > 0) {
            result.setZcs(Integer.parseInt(map.get("zcs").toString()));
            result.setZmy(Double.parseDouble(map.get("zmy").toString()));
            result.setPjzk(Double.parseDouble(map.get("pjzk").toString()));
            result.setZsy(Double.parseDouble(map.get("zsy").toString()));
        }

        result.setSalesDetailList(salesDetailList);
        return result;
    }

    @Override
    public Map queryTotalRecords(QueryCondition queryCondition) throws Exception {

        return salesDetailMapper.queryTotalRecords(queryCondition);
    }

}
