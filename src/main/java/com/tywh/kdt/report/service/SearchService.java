package com.tywh.kdt.report.service;

import com.tywh.kdt.report.pojo.Book;
import com.tywh.kdt.report.pojo.Search;

import java.util.List;
import java.util.Map;

public interface SearchService {

    List<Search> queryKhmcList(String khmc) throws Exception;

    List<Search> queryTsfljcList(String tsfljc) throws Exception;

    List<Search> queryShumList(String shum) throws Exception;

    List<Search> queryDqjlList(String dqjl) throws Exception;

    List<Search> queryDqList(String dq) throws Exception;
}
