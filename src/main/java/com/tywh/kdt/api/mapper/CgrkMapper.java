package com.tywh.kdt.api.mapper;

import com.tywh.kdt.api.pojo.Dbd;

import java.util.List;

public interface CgrkMapper {

    List<Dbd> queryCgrkList(String dh) throws Exception;
}
