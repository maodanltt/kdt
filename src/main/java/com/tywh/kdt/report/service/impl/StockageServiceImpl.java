package com.tywh.kdt.report.service.impl;

import com.tywh.kdt.report.mapper.StockageMapper;
import com.tywh.kdt.report.pojo.PdDetail;
import com.tywh.kdt.report.pojo.QueryConditionStockage;
import com.tywh.kdt.report.pojo.RkDetail;
import com.tywh.kdt.report.pojo.Stockage;
import com.tywh.kdt.report.service.StockageService;
import com.tywh.kdt.util.DateDiffUtil;
import com.tywh.kdt.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StockageServiceImpl implements StockageService {

    @Autowired
    private StockageMapper stockageMapper;

    @Override
    public List<Stockage> queryStorkageList(QueryConditionStockage queryConditionStockage,Map<String, Integer> rkDetailMap,Map<String, Integer> pdDetailMap) throws Exception {
        List<Stockage> stockageList = stockageMapper.queryStorkageList(queryConditionStockage);
        for (Stockage stockage : stockageList) {
            if (stockage.getZbh() != null && stockage.getZbh().length() >= 12) {
                stockage.setYc(stockage.getZbh().substring(stockage.getZbh().length() -4));
            } else {
                stockage.setZbh("");
            }
            computeStockAge(stockage,1,rkDetailMap,pdDetailMap);
        }
        return stockageList;
    }

    @Override
    public Map queryTotalRecords(QueryConditionStockage queryConditionStockage) throws Exception {
        return stockageMapper.queryTotalRecords(queryConditionStockage);
    }

    @Override
    public Map<String, Integer> queryRkDetailMap() throws Exception {
        List<RkDetail> rkDetailList = stockageMapper.queryRkDetailList();
        Map<String, Integer> rkDetailMap = new HashMap<>();
        for (RkDetail rkDetail : rkDetailList) {
            long differenceDays = DateDiffUtil.getDifferenceDays(DateUtil.format(rkDetail.getTxrq()), new Date());
            if (differenceDays >= 0 && differenceDays <= 30) {
                rkDetail.setLabel("term1");
            } else if (differenceDays >= 31 && differenceDays <= 60) {
                rkDetail.setLabel("term2");
            } else if (differenceDays >= 61 && differenceDays <= 180) {
                rkDetail.setLabel("term3");
            } else if (differenceDays >= 181 && differenceDays <= 365) {
                rkDetail.setLabel("term4");
            } else if (differenceDays >= 366 && differenceDays <= 730) {
                rkDetail.setLabel("term5");
            } else if (differenceDays >= 731 && differenceDays <= 1095) {
                rkDetail.setLabel("term6");
            } else if (differenceDays >= 1096) {
                rkDetail.setLabel("term7");
            }
            rkDetailMap.put(rkDetail.getKey(), rkDetail.getCs());
        }
        return rkDetailMap;
    }

    @Override
    public Map<String, Integer> queryPdDetailMap() throws Exception {
        List<PdDetail> pdDetailList = stockageMapper.queryPdDetailList();
        Map<String, Integer> pdDetailMap = new HashMap<>();
        for (PdDetail pdDetail : pdDetailList) {
            long differenceDays = DateDiffUtil.getDifferenceDays(DateUtil.format(pdDetail.getTxrq()), new Date());
            if (differenceDays >= 0 && differenceDays <= 30) {
                pdDetail.setLabel("term1");
            } else if (differenceDays >= 31 && differenceDays <= 60) {
                pdDetail.setLabel("term2");
            } else if (differenceDays >= 61 && differenceDays <= 180) {
                pdDetail.setLabel("term3");
            } else if (differenceDays >= 181 && differenceDays <= 365) {
                pdDetail.setLabel("term4");
            } else if (differenceDays >= 366 && differenceDays <= 730) {
                pdDetail.setLabel("term5");
            } else if (differenceDays >= 731 && differenceDays <= 1095) {
                pdDetail.setLabel("term6");
            } else if (differenceDays >= 1096) {
                pdDetail.setLabel("term7");
            }
            pdDetailMap.put(pdDetail.getKey(), pdDetail.getCs());
        }
        return pdDetailMap;
    }

    @Override
    public List<Stockage> queryAll(QueryConditionStockage queryConditionStockage,Map<String, Integer> rkDetailMap,Map<String, Integer> pdDetailMap) throws Exception {
        List<Stockage> list = stockageMapper.queryAll(queryConditionStockage);
        for (Stockage stockage : list) {
            if (stockage.getZbh() != null && stockage.getZbh().length() >= 12) {
                stockage.setYc(stockage.getZbh().substring(stockage.getZbh().length() -4));
            } else {
                stockage.setZbh("");
            }
            computeStockAge(stockage,1,rkDetailMap,pdDetailMap);
        }
        return list;
    }

    //计算库龄 count=1为当前周期
    private Stockage computeStockAge(Stockage stockage, Integer count, Map<String, Integer> rkDetailMap, Map<String, Integer> pdDetailMap) {
        Integer qmkc = stockage.getQmkc();
        //此时count=1
        Integer sum1 = sum(stockage, count, rkDetailMap, pdDetailMap);
        if (qmkc <= sum1) {
            stockage.setTerm1(stockage.getQmkc());
            return stockage;
        }
        stockage.setTerm1(sum1);
        count++;  //此时count=2

        Integer sum2 = sum(stockage, count, rkDetailMap, pdDetailMap);
        if (qmkc <= (sum1 + sum2)) {
            stockage.setTerm2(qmkc - sum1);
            return stockage;
        }
        stockage.setTerm2(sum2);
        count++;  //此时count=3

        Integer sum3 = sum(stockage, count, rkDetailMap, pdDetailMap);
        if (qmkc <= (sum1 + sum2 + sum3)) {
            stockage.setTerm3(qmkc - sum1 - sum2);
            return stockage;
        }
        stockage.setTerm3(sum3);
        count++;  //此时count=4

        Integer sum4 = sum(stockage, count, rkDetailMap, pdDetailMap);
        if (qmkc <= (sum1 + sum2 + sum3 + sum4)) {
            stockage.setTerm4(qmkc - sum1 - sum2 -sum3);
            return stockage;
        }

        stockage.setTerm4(sum4);
        count++;  //此时count=5

        Integer sum5 = sum(stockage, count, rkDetailMap, pdDetailMap);
        if (qmkc <= (sum1 + sum2 + sum3 + sum4 + sum5)) {
            stockage.setTerm5(qmkc - sum1 - sum2 -sum3 - sum4);
            return stockage;
        }

        stockage.setTerm5(sum5);
        count++;  //此时count=6

        Integer sum6 = sum(stockage, count, rkDetailMap, pdDetailMap);
        if (qmkc <= (sum1 + sum2 + sum3 + sum4 + sum5 + sum6)) {
            stockage.setTerm6(qmkc - sum1 - sum2 -sum3 - sum4 - sum5);
            return stockage;
        }

        stockage.setTerm6(sum6);
        count++;  //此时count=7

        Integer sum7 = sum(stockage, count, rkDetailMap, pdDetailMap);
        if (qmkc <= (sum1 + sum2 + sum3 + sum4 + sum5 + sum6 + sum7)) {
            stockage.setTerm7(qmkc - sum1 - sum2 -sum3 - sum4 - sum5 - sum6);
            return stockage;
        }
        stockage.setTerm7(qmkc - sum1 - sum2 -sum3 - sum4 - sum5 - sum6);
        return stockage;
    }

    //计算同一期间入库 盘点的和
    private Integer sum(Stockage stockage, Integer count, Map<String, Integer> rkDetailMap, Map<String, Integer> pdDetailMap) {
        Integer rkcs = rkDetailMap.get(stockage.getSxh() + "-" + "term" + count) == null ? 0 : rkDetailMap.get(stockage.getSxh() + "-" + "term" + count);
        Integer pdcs = pdDetailMap.get(stockage.getSxh() + "-" + "term" + count) == null ? 0 : pdDetailMap.get(stockage.getSxh() + "-" + "term" + count);
        return rkcs + pdcs;
    }


}
