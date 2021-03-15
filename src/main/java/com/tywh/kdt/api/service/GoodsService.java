package com.tywh.kdt.api.service;

import com.tywh.kdt.api.pojo.Goods;

import java.util.List;

public interface GoodsService {

    List<Goods> queryGoodsList();

    Goods queryGoodsBySxh(String sxh);
}
