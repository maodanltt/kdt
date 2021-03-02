package com.tywh.kdt.report.service.impl;

import com.tywh.kdt.report.mapper.BookMapper;
import com.tywh.kdt.report.mapper.SearchMapper;
import com.tywh.kdt.report.pojo.Book;
import com.tywh.kdt.report.pojo.Search;
import com.tywh.kdt.report.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchMapper searchMapper;

    @Override
    public List<Search> queryKhmcList(String khmc) throws Exception {
        Map<String, String> conditionMap = new HashMap<>();
        conditionMap.put("bmmc","成教营销中心");
        conditionMap.put("tybz","0");
        conditionMap.put("khmc",khmc);
        return searchMapper.queryKhmcList(conditionMap);
    }

    @Override
    public List<Search> queryTsfljcList(String tsfljc) throws Exception {
        Map<String, String> conditionMap = new HashMap<>();
        conditionMap.put("cg","采购");
        conditionMap.put("zx","中学");
        conditionMap.put("wh","文化");
        conditionMap.put("sjdm","||");
        conditionMap.put("tsfljc",tsfljc);
        return searchMapper.queryTsfljcList(conditionMap);
    }

    @Override
    public List<Search> queryShumList(String shum) throws Exception {
        Map<String, String> conditionMap = new HashMap<>();
        conditionMap.put("sxh","W");
        conditionMap.put("tsfljc","中学");
        conditionMap.put("cbzx","出版中心");
        conditionMap.put("whcb","文化出版编辑部");
        conditionMap.put("shum",shum);
        return searchMapper.queryShumList(conditionMap);
    }

    @Override
    public List<Search> queryDqjlList(String dqjl) throws Exception {
        Map<String, String> conditionMap = new HashMap<>();
        conditionMap.put("sjdm","01");
        conditionMap.put("dqjl",dqjl);
        return searchMapper.queryDqjlList(conditionMap);
    }

    @Override
    public List<Search> queryDqList(String dq) throws Exception {
        Map<String, String> conditionMap = new HashMap<>();
        conditionMap.put("dq",dq);
        return searchMapper.queryDqList(conditionMap);
    }

}
