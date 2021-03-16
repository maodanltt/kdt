package com.tywh.kdt.report.mapper;

import com.tywh.kdt.report.pojo.PdDetail;
import com.tywh.kdt.report.pojo.QueryConditionStockage;
import com.tywh.kdt.report.pojo.RkDetail;
import com.tywh.kdt.report.pojo.Stockage;
import java.util.List;
import java.util.Map;

public interface StockageMapper {

    List<Stockage> queryStorkageList(QueryConditionStockage queryConditionStockage) throws Exception;

    List<RkDetail> queryRkDetailList() throws Exception;

    List<PdDetail> queryPdDetailList() throws Exception;

    Map queryTotalRecords (QueryConditionStockage queryConditionStockage) throws Exception;

}
