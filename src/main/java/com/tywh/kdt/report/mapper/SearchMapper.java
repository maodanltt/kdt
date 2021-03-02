package com.tywh.kdt.report.mapper;

import com.tywh.kdt.report.pojo.Search;

import java.util.List;
import java.util.Map;

public interface SearchMapper {
    List<Search> queryKhmcList(Map<String, String> conditionMap);

    List<Search> queryTsfljcList(Map<String, String> conditionMap) throws Exception;

    List<Search> queryShumList(Map<String, String> conditionMap) throws Exception;

    List<Search> queryDqjlList(Map<String, String> conditionMap) throws Exception;

    List<Search> queryDqList(Map<String, String> conditionMap) throws Exception;
}
