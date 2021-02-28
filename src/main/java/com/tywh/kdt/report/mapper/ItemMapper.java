package com.tywh.kdt.report.mapper;

import com.tywh.kdt.report.pojo.QueryConditionWhcb;
import com.tywh.kdt.report.pojo.Item;

import java.util.List;

public interface ItemMapper {

    List<Item> queryItemList(QueryConditionWhcb queryConditionWhcb) throws Exception;

    Integer queryZxscs(QueryConditionWhcb queryConditionWhcb) throws Exception;

//  Map<String, Integer> queryKucun(Condition conditon) throws Exception;
    List<Item> queryKucun(QueryConditionWhcb queryConditionWhcb) throws Exception;

    Item queryItemByName(String name) throws Exception;

}
