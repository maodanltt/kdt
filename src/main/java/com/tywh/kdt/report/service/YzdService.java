package com.tywh.kdt.report.service;

import com.tywh.kdt.report.pojo.*;

import java.util.List;
import java.util.Map;

public interface YzdService {

    List<Yzd> queryYzdList(QueryConditionYzd queryConditionYzd) throws Exception;

    Map<String, Integer> queryTotalRecords(QueryConditionYzd queryConditionYzd) throws Exception;

}
