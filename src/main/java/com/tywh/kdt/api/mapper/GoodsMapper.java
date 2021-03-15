package com.tywh.kdt.api.mapper;

import com.tywh.kdt.api.pojo.Goods;

import java.util.List;

public interface GoodsMapper {

    List<Goods> queryGoodsList();

    Goods queryGoodsBySxh(String sxh);
}
