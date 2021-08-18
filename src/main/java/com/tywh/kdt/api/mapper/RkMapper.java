package com.tywh.kdt.api.mapper;

import com.tywh.kdt.api.pojo.Dbd;

import java.util.List;

public interface RkMapper {

    List<Dbd> queryRkList(String dh) throws Exception;
}
