package com.tywh.kdt.report.service.impl;

import com.tywh.kdt.report.mapper.SearchMapper;
import com.tywh.kdt.report.pojo.*;
import com.tywh.kdt.report.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchMapper searchMapper;

    @Override
    public List<Search> queryKhmcList() throws Exception {
        return searchMapper.queryKhmcList();
    }

    @Override
    public List<Search> queryTsfljcList() throws Exception {
        return searchMapper.queryTsfljcList();
    }

    @Override
    public List<Search> queryShumList() throws Exception {
        return searchMapper.queryShumList();
    }

    @Override
    public List<Search> queryDqjlList() throws Exception {
        return searchMapper.queryDqjlList();
    }

    @Override
    public List<Search> queryDqList() throws Exception {
        return searchMapper.queryDqList();
    }

    @Override
    public List<RkDetail> queryRkDetailList() throws Exception {
        return searchMapper.queryRkDetailList();
    }

    @Override
    public List<Inventory> queryKucunList() throws Exception {
        return searchMapper.queryKucunList();
    }

    @Override
    public List<Yzd> queryYzdList() throws Exception {
        List<Yzd> yzdList = searchMapper.queryYzdList();
        List<Yzd> newYzdList = new ArrayList<>();
        for (Yzd yzd : yzdList) {

            if (yzd.getZbh() != null && yzd.getZbh().length() >= 12) {
                yzd.setYc(yzd.getZbh().substring(yzd.getZbh().length() -5));
            } else {
                yzd.setYc("");
            }

            Integer yscs = Integer.parseInt(yzd.getYscs());
            if (yscs == null || yscs == 0) {
                yzd.setYscs("0");
                newYzdList.add(yzd);
            } else if (yscs != null && yscs > 0 && ( yscs.doubleValue() / yscs.doubleValue()) < 0.9) {
                newYzdList.add(yzd);
            }
        }
        return newYzdList;
    }

    @Override
    public List<Book> queryBookList() throws Exception {
        return searchMapper.queryBookList();
    }

}
