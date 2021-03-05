package com.tywh.kdt.report.mapper;

import com.tywh.kdt.report.pojo.QueryCondition;
import com.tywh.kdt.report.pojo.SalesDetail;

import java.util.List;
import java.util.Map;

public interface SalesDetailMapper {

    List<SalesDetail> querySalesDetailList(QueryCondition queryCondition) throws Exception;

    Map queryTotalRecords(QueryCondition queryCondition) throws Exception;
    
}
