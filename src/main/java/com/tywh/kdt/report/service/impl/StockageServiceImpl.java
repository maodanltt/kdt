package com.tywh.kdt.report.service.impl;

import com.tywh.kdt.report.mapper.StockageMapper;
import com.tywh.kdt.report.pojo.QueryConditionStockage;
import com.tywh.kdt.report.pojo.Stockage;
import com.tywh.kdt.report.service.StockageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StockageServiceImpl implements StockageService {

    @Autowired
    private StockageMapper stockageMapper;

    @Override
    public List<Stockage> queryStorkageList(QueryConditionStockage queryConditionStockage) throws Exception{
        List<Stockage> stockageList = stockageMapper.queryStorkageList(queryConditionStockage);
        return null;
    }
}
