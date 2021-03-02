package com.tywh.kdt.report.service;

import com.tywh.kdt.report.pojo.Search;

import java.util.List;

public interface SearchService {

    List<Search> queryKhmcList() throws Exception;

    List<Search> queryTsfljcList() throws Exception;

    List<Search> queryShumList() throws Exception;

    List<Search> queryDqjlList() throws Exception;

    List<Search> queryDqList() throws Exception;
}
