package com.tywh.kdt.report.service;

import com.tywh.kdt.report.pojo.QueryCondition;
import com.tywh.kdt.report.pojo.Result;
import com.tywh.kdt.report.pojo.SalesDetail;

import java.util.List;

public interface SalesDetailService {

    Result getSalesDetailList(QueryCondition queryCondition) throws Exception;
}
