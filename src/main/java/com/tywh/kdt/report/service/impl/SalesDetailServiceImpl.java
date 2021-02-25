package com.tywh.kdt.report.service.impl;
import com.tywh.kdt.report.mapper.SalesDetailMapper;
import com.tywh.kdt.report.pojo.QueryCondition;
import com.tywh.kdt.report.pojo.SalesDetail;
import com.tywh.kdt.report.service.SalesDetailService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SalesDetailServiceImpl implements SalesDetailService {

    @Autowired
    private SalesDetailMapper salesDetailMapper;

    @Override
    public List<SalesDetail> getSalesDetailList(QueryCondition queryCondition) throws Exception{

        return salesDetailMapper.querySalesDetailList(queryCondition);
    }
}
