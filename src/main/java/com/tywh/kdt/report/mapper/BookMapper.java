package com.tywh.kdt.report.mapper;

import com.tywh.kdt.report.pojo.Book;

import java.util.List;

public interface BookMapper {

    List<Book> queryBookList(String shum) throws Exception;

}
