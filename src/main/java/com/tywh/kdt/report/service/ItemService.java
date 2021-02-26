package com.tywh.kdt.report.service;

import com.tywh.kdt.report.pojo.WhcbQueryCondition;
import com.tywh.kdt.report.pojo.WhcbResult;

public interface ItemService {

    WhcbResult queryItem(WhcbQueryCondition whcbQueryCondition);
}
