package com.tywh.kdt.api.service;

import com.tywh.kdt.api.pojo.Dbd;

import java.util.List;
import java.util.Map;

public interface DbdService {

    List<String> createDbckXmlList(String fhdbh) throws Exception;

    String createDbrkXml(String fhdbh) throws Exception;

}
