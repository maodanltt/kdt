package com.tywh.kdt.report.mapper;

import com.tywh.kdt.report.pojo.*;

import java.util.List;
import java.util.Map;

public interface YzdMapper {

    List<Yzd> queryYzdList(QueryConditionYzd queryConditionYzd) throws Exception;

    Map<String, Integer> queryTotalRecords(QueryConditionYzd queryConditionYzd);

}
