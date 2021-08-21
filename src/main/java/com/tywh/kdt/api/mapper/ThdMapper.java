package com.tywh.kdt.api.mapper;

import com.tywh.kdt.api.pojo.Dbd;

import java.util.List;

public interface ThdMapper {

    List<Dbd> queryThdList(String dh) throws Exception;
}
