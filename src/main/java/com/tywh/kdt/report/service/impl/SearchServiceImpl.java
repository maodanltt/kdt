package com.tywh.kdt.report.service.impl;

import com.tywh.kdt.report.mapper.BookMapper;
import com.tywh.kdt.report.pojo.Book;
import com.tywh.kdt.report.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> queryBookList(String shum) throws Exception{
        
        return bookMapper.queryBookList(shum);
    }
}
