package com.tywh.kdt.api.service;

import com.tywh.kdt.api.pojo.Goods;

import java.util.List;

public interface RkdService {
    /**
     * 手工调整入库使用
     * @param dh
     * @param warehouseCode
     * @param list
     * @return
     * @throws Exception
     */
    String createXml(String dh, String warehouseCode, List<Goods> list,String bz) throws Exception;

    /**
     * 科迪通采购入库单
     * @param dh
     * @return
     * @throws Exception
     */
    String createCgrkXml(String dh) throws Exception;

    /**
     * 科迪通损耗入库
     * @param dh
     * @return
     * @throws Exception
     */
    String createShrkXml(String dh) throws Exception;
}
