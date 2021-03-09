package com.tywh.kdt.report.mapper;

import com.tywh.kdt.report.pojo.Inventory;
import com.tywh.kdt.report.pojo.RkDetail;
import com.tywh.kdt.report.pojo.Search;
import com.tywh.kdt.report.pojo.Yzd;

import java.util.List;
import java.util.Map;

public interface SearchMapper {
    List<Search> queryKhmcList(Map<String, String> conditionMap) throws Exception;

    List<Search> queryTsfljcList(Map<String, String> conditionMap) throws Exception;

    List<Search> queryShumList(Map<String, String> conditionMap) throws Exception;

    List<Search> queryDqjlList(Map<String, String> conditionMap) throws Exception;

    List<Search> queryDqList() throws Exception;

    List<RkDetail> queryRkDetailList() throws Exception;

    List<Inventory>  queryKucunList(Map<String,String> conditionMap) throws Exception;

    List<Yzd> queryYzdList(Map<String, String> conditionMap) throws Exception;

}
