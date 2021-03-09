package com.tywh.kdt.report.service.impl;

import com.tywh.kdt.report.mapper.SearchMapper;
import com.tywh.kdt.report.pojo.Inventory;
import com.tywh.kdt.report.pojo.RkDetail;
import com.tywh.kdt.report.pojo.Search;
import com.tywh.kdt.report.pojo.Yzd;
import com.tywh.kdt.report.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchMapper searchMapper;

    @Override
    public List<Search> queryKhmcList() throws Exception {
        Map<String, String> conditionMap = new HashMap<>();
        conditionMap.put("bmmc","成教营销中心");
        conditionMap.put("tybz","0");
        return searchMapper.queryKhmcList(conditionMap);
    }

    @Override
    public List<Search> queryTsfljcList() throws Exception {
        Map<String, String> conditionMap = new HashMap<>();
        conditionMap.put("cg","采购");
        conditionMap.put("zx","中学");
        conditionMap.put("wh","文化");
        conditionMap.put("sjdm","||");
        return searchMapper.queryTsfljcList(conditionMap);
    }

    @Override
    public List<Search> queryShumList() throws Exception {
        Map<String, String> conditionMap = new HashMap<>();
        conditionMap.put("sxh","W");
        conditionMap.put("tsfljc","中学");
        conditionMap.put("cbzx","出版中心");
        conditionMap.put("whcb","文化出版编辑部");
        return searchMapper.queryShumList(conditionMap);
    }

    @Override
    public List<Search> queryDqjlList() throws Exception {
        Map<String, String> conditionMap = new HashMap<>();
        conditionMap.put("sjdm","01");
        return searchMapper.queryDqjlList(conditionMap);
    }

    @Override
    public List<Search> queryDqList() throws Exception {
        return searchMapper.queryDqList();
    }

    @Override
    public List<RkDetail> queryRkDetailList() throws Exception {
        return searchMapper.queryRkDetailList();
    }

    @Override
    public List<Inventory> queryKucunList() throws Exception {
        Map<String, String> conditionMap = new HashMap<>();
        conditionMap.put("kwbh","00HG");
        return searchMapper.queryKucunList(conditionMap);
    }

    @Override
    public List<Yzd> queryYzdList() throws Exception {
        Map<String, String> conditionMap = new HashMap<>();
        conditionMap.put("txrq","2020-01-01");
        conditionMap.put("bzfs","送货");
        conditionMap.put("tsfljc","中学");
        List<Yzd> yzdList = searchMapper.queryYzdList(conditionMap);
        return null;
    }

}
