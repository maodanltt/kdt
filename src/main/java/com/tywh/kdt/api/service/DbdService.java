package com.tywh.kdt.api.service;

import com.tywh.kdt.api.pojo.Dbd;

import java.util.List;

public interface DbdService {

    List<Dbd> queryDbdList(String fhdbh) throws Exception;
}
