package com.tywh.kdt.report.mapper;

import com.tywh.kdt.report.pojo.WhcbQueryCondition;
import com.tywh.kdt.report.pojo.Item;

import java.util.List;

public interface ItemMapper {

    List<Item> queryItemList(WhcbQueryCondition whcbQueryCondition) throws Exception;

    Integer queryZxscs(WhcbQueryCondition whcbQueryCondition) throws Exception;

//  Map<String, Integer> queryKucun(Condition conditon) throws Exception;
    List<Item> queryKucun(WhcbQueryCondition whcbQueryCondition) throws Exception;

    Item queryItemByName(String name) throws Exception;

}
