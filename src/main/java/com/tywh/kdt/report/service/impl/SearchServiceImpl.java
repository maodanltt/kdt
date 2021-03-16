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
        return searchMapper.queryKhmcList();
    }

    @Override
    public List<Search> queryTsfljcList() throws Exception {
        return searchMapper.queryTsfljcList();
    }

    @Override
    public List<Search> queryShumList() throws Exception {
        return searchMapper.queryShumList();
    }

    @Override
    public List<Search> queryDqjlList() throws Exception {
        return searchMapper.queryDqjlList();
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
        return searchMapper.queryKucunList();
    }

    @Override
    public List<Yzd> queryYzdList() throws Exception {
        Map<String, String> conditionMap = new HashMap<>();
        conditionMap.put("txrq","2020-01-01");
        conditionMap.put("bzfs","送货");
        conditionMap.put("tsfljc","中学");
        List<Yzd> yzdList = searchMapper.queryYzdList();
        return null;
    }

}
