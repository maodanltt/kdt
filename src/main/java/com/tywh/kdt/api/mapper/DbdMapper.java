package com.tywh.kdt.api.mapper;

import com.tywh.kdt.api.pojo.Dbd;

import java.util.List;

public interface DbdMapper {

    List<Dbd> queryDbdList(String fhdbh) throws Exception;
}
