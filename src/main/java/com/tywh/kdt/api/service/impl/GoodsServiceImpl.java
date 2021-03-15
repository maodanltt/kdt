package com.tywh.kdt.api.service.impl;

import com.tywh.kdt.api.mapper.GoodsMapper;
import com.tywh.kdt.api.pojo.Goods;
import com.tywh.kdt.api.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> queryGoodsList() {
        return null;
    }

    @Override
    public Goods queryGoodsBySxh(String sxh) {
        return goodsMapper.queryGoodsBySxh(sxh);
    }
}
