package com.tywh.kdt.report.service;

import com.tywh.kdt.report.pojo.QueryConditionWhcb;
import com.tywh.kdt.report.pojo.ResultWhcb;

public interface ItemService {

    ResultWhcb queryItem(QueryConditionWhcb queryConditionWhcb);
}
