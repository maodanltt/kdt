package com.tywh.kdt.report.service;

import com.tywh.kdt.report.pojo.QueryCondition;
import com.tywh.kdt.report.pojo.Result;

import java.util.Map;

public interface SalesDetailService {

    Result querySalesDetailList(QueryCondition queryCondition) throws Exception;

    Map queryTotalRecords(QueryCondition queryCondition) throws Exception;
}
