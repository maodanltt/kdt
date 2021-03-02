package com.tywh.kdt.report.web;

import com.tywh.kdt.report.pojo.Search;
import com.tywh.kdt.report.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping("/queryKhmcList")
    @ResponseBody
    public Map<String, List<Search>> queryKhmcList(HttpServletRequest request) throws Exception {
        Map<String, List<Search>> retmap = new HashMap();
        List<Search> khmcList = (List<Search>) request.getSession(true).getAttribute("khmcList");
        if (khmcList == null) {
            khmcList = searchService.queryKhmcList();
            request.getSession(false).setAttribute("khmcList",khmcList);
        }
        retmap.put("list", khmcList);
        return retmap;
    }

    @RequestMapping("/queryTsfljcList")
    @ResponseBody
    public Map<String, List<Search>> queryTsfljcList(HttpServletRequest request) throws Exception {
        Map<String, List<Search>> retmap = new HashMap();
        List<Search> tsfljcList = (List<Search>) request.getSession(true).getAttribute("tsfljcList");
        if (tsfljcList == null) {
            tsfljcList = searchService.queryTsfljcList();
            request.getSession(false).setAttribute("tsfljcList",tsfljcList);
        }
        retmap.put("list", tsfljcList);
        return retmap;
    }

    @RequestMapping("/queryShumList")
    @ResponseBody
    public Map<String, List<Search>> queryShumList(HttpServletRequest request) throws Exception {
        Map<String, List<Search>> retmap = new HashMap();
        List<Search> shumList = (List<Search>) request.getSession(true).getAttribute("shumList");
        if (shumList == null) {
            shumList = searchService.queryShumList();
            request.getSession(false).setAttribute("shumList",shumList);
        }
        retmap.put("list", shumList);
        return retmap;
    }

    @RequestMapping("/queryDqjlList")
    @ResponseBody
    public Map<String, List<Search>> queryDqjlList(HttpServletRequest request) throws Exception {
        Map<String, List<Search>> retmap = new HashMap();
        List<Search> dqjlList = (List<Search>) request.getSession(true).getAttribute("dqjlList");
        if (dqjlList == null) {
            dqjlList = searchService.queryDqjlList();
            request.getSession(true).setAttribute("dqjlList",dqjlList);
        }
        retmap.put("list", dqjlList);
        return retmap;
    }

    @RequestMapping("/queryDqList")
    @ResponseBody
    public Map<String, List<Search>> queryDqList(HttpServletRequest request) throws Exception {
        Map<String, List<Search>> retmap = new HashMap();
        List<Search> dqList = (List<Search>) request.getSession(false).getAttribute("dqList");
        if (dqList == null) {
            dqList = searchService.queryDqList();
            request.getSession(true).setAttribute("dqList",dqList);
        }
        retmap.put("list", dqList);
        return retmap;
    }
}
