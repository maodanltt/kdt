package com.tywh.kdt.api.service;

import com.tywh.kdt.api.pojo.Dbd;

import java.util.List;
import java.util.Map;

public interface DbdService {

    //查询科迪通调拨单，按出库库位是否相同封装到MAP中
    Map<String,List<Dbd>> queryDbdList(String fhdbh) throws Exception;
}
