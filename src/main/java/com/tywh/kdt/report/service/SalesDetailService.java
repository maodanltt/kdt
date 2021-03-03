package com.tywh.kdt.report.service;

import com.tywh.kdt.report.pojo.QueryCondition;
import com.tywh.kdt.report.pojo.Result;

public interface SalesDetailService {

    Result getSalesDetailList(QueryCondition queryCondition) throws Exception;
}
