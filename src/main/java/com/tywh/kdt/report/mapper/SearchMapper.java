package com.tywh.kdt.report.mapper;

import com.tywh.kdt.report.pojo.*;

import java.util.List;
import java.util.Map;

public interface SearchMapper {
    List<Search> queryKhmcList() throws Exception;

    List<Search> queryTsfljcList() throws Exception;

    List<Search> queryShumList() throws Exception;

    List<Search> queryDqjlList() throws Exception;

    List<Search> queryDqList() throws Exception;

    List<RkDetail> queryRkDetailList() throws Exception;

    List<Inventory>  queryKucunList() throws Exception;

    List<Yzd> queryYzdList() throws Exception;

    List<Book> queryBookList() throws Exception;
}
