package com.tywh.kdt.report.service;

import com.tywh.kdt.report.pojo.Condition;

import java.util.Map;

public interface ItemService {

    Map<String,Object> queryItem(Condition condition);
}
