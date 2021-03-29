package com.tywh.kdt.api.mapper;

import com.tywh.kdt.api.pojo.Dbd;

import java.util.List;

public interface DbdMapper {

    List<Dbd> queryDbckList(String fhdbh) throws Exception;

    List<Dbd> queryDbrkList(String fhdbh) throws Exception;
}
