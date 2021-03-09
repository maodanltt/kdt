package com.tywh.kdt.report.service;

import com.tywh.kdt.report.pojo.Inventory;
import com.tywh.kdt.report.pojo.RkDetail;
import com.tywh.kdt.report.pojo.Search;
import com.tywh.kdt.report.pojo.Yzd;

import java.util.List;
import java.util.Map;

public interface SearchService {

    List<Search> queryKhmcList() throws Exception;

    List<Search> queryTsfljcList() throws Exception;

    List<Search> queryShumList() throws Exception;

    List<Search> queryDqjlList() throws Exception;

    List<Search> queryDqList() throws Exception;

    List<RkDetail> queryRkDetailList() throws Exception;

    List<Inventory> queryKucunList() throws Exception;

    List<Yzd> queryYzdList() throws Exception;
}
