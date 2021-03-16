package com.tywh.kdt.report.service;

import com.tywh.kdt.report.pojo.QueryConditionStockage;
import com.tywh.kdt.report.pojo.Stockage;

import java.util.List;
import java.util.Map;

public interface StockageService {

    List<Stockage> queryStorkageList(QueryConditionStockage queryConditionStockage) throws Exception;

    Map queryTotalRecords (QueryConditionStockage queryConditionStockage) throws Exception;

    Map<String, Integer> queryRkDetailMap() throws Exception;

    Map<String, Integer> queryPdDetailMap() throws Exception;
}
