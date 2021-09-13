package com.tywh.kdt.report.service.impl;

import com.tywh.kdt.report.mapper.SearchMapper;
import com.tywh.kdt.report.mapper.YzdMapper;
import com.tywh.kdt.report.pojo.*;
import com.tywh.kdt.report.service.SearchService;
import com.tywh.kdt.report.service.YzdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class YzdServiceImpl implements YzdService {

    @Autowired
    private YzdMapper yzdMapper;

    @Override
    public List<Yzd> queryYzdList(QueryConditionYzd queryConditionYzd) throws Exception {

        return yzdMapper.queryYzdList(queryConditionYzd);
    }

    @Override
    public Map<String, Integer> queryTotalRecords(QueryConditionYzd queryConditionYzd) throws Exception {
        return yzdMapper.queryTotalRecords(queryConditionYzd);
    }


}
