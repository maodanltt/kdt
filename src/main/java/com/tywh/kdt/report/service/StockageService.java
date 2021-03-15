package com.tywh.kdt.report.service;

import com.tywh.kdt.report.pojo.QueryConditionStockage;
import com.tywh.kdt.report.pojo.Stockage;

import java.util.List;

public interface StockageService {

    List<Stockage> queryStorkageList(QueryConditionStockage queryConditionStockage) throws Exception;
}
