package com.tywh.kdt.api.service;

import com.tywh.kdt.api.pojo.Dbd;

import java.util.List;
import java.util.Map;

public interface DbdService {

    List<String> createDbckXmlBodyList(String fhdbh) throws Exception;

    String createDbrkXmlBody(String fhdbh) throws Exception;

}
