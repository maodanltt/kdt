package com.tywh.kdt.report.mapper;

import com.tywh.kdt.report.pojo.QueryConditionStockage;
import com.tywh.kdt.report.pojo.Stockage;
import java.util.List;

public interface StockageMapper {

    List<Stockage> queryStorkageList(QueryConditionStockage queryConditionStockage) throws Exception;


}
