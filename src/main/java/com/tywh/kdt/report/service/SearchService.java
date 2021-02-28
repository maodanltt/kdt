package com.tywh.kdt.report.service;

import com.tywh.kdt.report.pojo.Book;

import java.util.List;

public interface SearchService {

    List<Book> queryBookList(String shum) throws Exception;
}
