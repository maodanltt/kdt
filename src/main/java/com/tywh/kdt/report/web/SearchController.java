package com.tywh.kdt.report.web;

import com.tywh.kdt.report.pojo.Inventory;
import com.tywh.kdt.report.pojo.RkDetail;
import com.tywh.kdt.report.pojo.Search;
import com.tywh.kdt.report.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
        HttpSession session = request.getSession(false);
        Map<String, List<Search>> retmap = new HashMap();
        List<Search> khmcList = (List<Search>) session.getAttribute("khmcList");
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
        List<Search> tsfljcList = (List<Search>) request.getSession(false).getAttribute("tsfljcList");
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
        List<Search> shumList = (List<Search>) request.getSession(false).getAttribute("shumList");
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
        List<Search> dqjlList = (List<Search>) request.getSession(false).getAttribute("dqjlList");
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

    @RequestMapping("/queryRkDetailList")
    public String queryRkDetailList(HttpServletRequest request, String sxh) throws Exception {
        List<RkDetail> rkDetailList = (List<RkDetail>) request.getSession(false).getAttribute("rkDetailList");
        if (rkDetailList == null) {
            rkDetailList = searchService.queryRkDetailList();
            request.getSession(false).setAttribute("rkDetailList",rkDetailList);
        }

        List<RkDetail> resultList = new ArrayList<>();
        Integer rkzs = 0;
        if (rkDetailList != null) {
            for (RkDetail rkDetail : rkDetailList) {
                if (rkDetail.getSxh().equals(sxh)) {
                    rkzs += rkDetail.getCs();
                    resultList.add(rkDetail);
                }
            }
        }


        List<Inventory> kucunList = (List<Inventory>) request.getSession(false).getAttribute("kucunList");
        if (kucunList == null) {
            kucunList = searchService.queryKucunList();
            request.getSession(false).setAttribute("kucunList",kucunList);
        }
        for (Inventory inventory : kucunList) {
            if (inventory.getSxh().equals(sxh)) {
                request.setAttribute("qmkc",inventory.getQmkc());
            }
        }
        request.setAttribute("rkzs",rkzs);
        request.setAttribute("resultList", resultList);
        return "rkDetail";
    }


}
