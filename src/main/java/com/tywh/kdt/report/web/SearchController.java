package com.tywh.kdt.report.web;

import com.tywh.kdt.report.pojo.Book;
import com.tywh.kdt.report.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping("/queryBookList")
    @ResponseBody
    public Map<String,List<String>> queryBookList(HttpServletRequest request,String shum) throws Exception{
        Map<String,List<String>> retmap = new HashMap();
        List<String> shumList = new ArrayList<>();
        List<Book> bookList = (List<Book>) request.getSession(false).getServletContext().getAttribute("bookList");
        if (bookList == null) {
            bookList = searchService.queryBookList(shum);
            request.getSession(false).getServletContext().setAttribute("bookList",bookList);
        }
        for (Book b : bookList) {
            if (b.getShum().contains(shum)) {
                shumList.add(b.getShum());
            }
        }
        retmap.put("shumList",shumList);
        return retmap;
    }
}
