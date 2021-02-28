package com.tywh.kdt.report.service.impl;
import com.tywh.kdt.report.mapper.SalesDetailMapper;
import com.tywh.kdt.report.pojo.QueryCondition;
import com.tywh.kdt.report.pojo.Result;
import com.tywh.kdt.report.pojo.SalesDetail;
import com.tywh.kdt.report.service.SalesDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesDetailServiceImpl implements SalesDetailService {

    @Autowired
    private SalesDetailMapper salesDetailMapper;

    @Override
    public Result getSalesDetailList(QueryCondition queryCondition) throws Exception{
        List<SalesDetail> salesDetailList = salesDetailMapper.querySalesDetailList(queryCondition);
        Result result = new Result();
        result.setSalesDetailList(salesDetailList);
        return result;
    }
}
