package com.tywh.kdt.util;

import com.alibaba.excel.EasyExcel;
import com.tywh.kdt.report.pojo.Book;

import java.util.ArrayList;
import java.util.List;

public class TestExcel {
    public static void main(String[] args) {
        String filename = "F:\\test\\shum.xlsx";
        List<Book> bookList = new ArrayList<>();
        Book b1 = new Book();
        Book b2 = new Book();
        b1.setSxh("20210101");
        b1.setShum("book1");
        b2.setSxh("19860923");
        b2.setShum("book2");
        bookList.add(b1);
        bookList.add(b2);
        EasyExcel.write(filename,Book.class).sheet("图书列表").doWrite(bookList);
    }

}
