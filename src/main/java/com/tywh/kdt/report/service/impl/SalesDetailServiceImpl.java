package com.tywh.kdt.report.service.impl;
import com.tywh.kdt.report.mapper.SalesDetailMapper;
import com.tywh.kdt.report.pojo.QueryCondition;
import com.tywh.kdt.report.pojo.Result;
import com.tywh.kdt.report.pojo.SalesDetail;
import com.tywh.kdt.report.service.SalesDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SalesDetailServiceImpl implements SalesDetailService {

    @Autowired
    private SalesDetailMapper salesDetailMapper;

    @Override
    public Result querySalesDetailList(QueryCondition queryCondition) throws Exception{
        List<SalesDetail> salesDetailList = salesDetailMapper.querySalesDetailList(queryCondition);
        if (salesDetailList != null) {
            for (SalesDetail salesDetail : salesDetailList) {
                salesDetail.setYc(salesDetail.getZbh().substring(salesDetail.getZbh().length() -4));
                if (salesDetail.getDqjl() == null && salesDetail.getXsflmc() != null) {
                    salesDetail.setDqjl(salesDetail.getXsflmc().split("-")[0]);
                }  else if (salesDetail.getDqjl() == null && salesDetail.getXsflmc() == null && salesDetail.getDq() == "样书") {
                    salesDetail.setDqjl("未知");
                } else if (salesDetail.getDq() == null) {
                    salesDetail.setDq("未知");
                    salesDetail.setDqjl("未知");
                }
            }
        }

        Result result = new Result();
        Map map = queryTotalRecords(queryCondition);
        result.setTotal((Integer)map.get("total"));
        result.setZcs((Integer) map.get("zcs"));
        result.setZmy((Double) map.get("zmy"));
        result.setPjzk((Double) map.get("pjzk"));
        result.setZsy((Double) map.get("zsy"));

        result.setSalesDetailList(salesDetailList);
        return result;
    }

    @Override
    public Map queryTotalRecords(QueryCondition queryCondition) throws Exception {

        return salesDetailMapper.queryTotalRecords(queryCondition);
    }

}
