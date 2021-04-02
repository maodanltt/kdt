package com.tywh.kdt.api.service;

import com.tywh.kdt.api.pojo.Goods;

import java.util.List;

public interface RkdService {

    String createXml(String dh, String warehouseCode, List<Goods> list) throws Exception;
}
