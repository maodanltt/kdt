package com.tywh.kdt.report.service;

import com.tywh.kdt.report.pojo.QueryCondition;
import com.tywh.kdt.report.pojo.Result;

public interface SalesDetailService {

    Result querySalesDetailList(QueryCondition queryCondition) throws Exception;

    Integer queryTotalRecords(QueryCondition queryCondition) throws Exception;
}
