package com.tywh.kdt.report.service.impl;

import com.tywh.kdt.report.mapper.ItemMapper;
import com.tywh.kdt.report.pojo.WhcbQueryCondition;
import com.tywh.kdt.report.pojo.Item;
import com.tywh.kdt.report.pojo.WhcbResult;
import com.tywh.kdt.report.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public WhcbResult queryItem(WhcbQueryCondition whcbQueryCondition) {
        String ksqj = whcbQueryCondition.getStartdate().substring(0,7);
        String jsqj = whcbQueryCondition.getEnddate().substring(0,7);
        WhcbResult whcbResult = new WhcbResult();
        Map<String, Integer> kucunMap = new HashMap<>();
        List<Item> itemList = null;
        Integer zxscs = 0;
        Integer zqckc = 0;
        Integer zqmkc = 0;
        String zkczzl = null;

        NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMinimumFractionDigits(2);
        try {
            itemList = itemMapper.queryItemList(whcbQueryCondition);
            List<Item> kucunItemList= itemMapper.queryKucun(whcbQueryCondition);
            for (Item item : kucunItemList) {
                String qckcKey = item.getShum() + "-" + item.getGjdj() + "-" + item.getTsfljc() + "-" + item.getKjqj() + "-qckc";
                String qmkcKey = item.getShum() + "-" + item.getGjdj() + "-" + item.getTsfljc() + "-" + item.getKjqj() + "-qmkc";
                kucunMap.put(qckcKey,item.getQckc());
                kucunMap.put(qmkcKey,item.getQmkc());
            }
            for (Item item : itemList) {
                Integer xscs = item.getXscs() == null ? 0 : item.getXscs();
                zxscs = zxscs + xscs;
            }

            for (Item item : itemList) {
                String qckcKey = item.getKey() + "-" + ksqj + "-qckc";
                String qmkcKey = item.getKey() + "-" + jsqj + "-qmkc";
                Integer qckc = kucunMap.get(qckcKey) == null ? 0 : kucunMap.get(qckcKey);
                Integer qmkc = kucunMap.get(qmkcKey) == null ? 0 : kucunMap.get(qmkcKey);
                Integer xscs = item.getXscs() == null ? 0 : item.getXscs();
                item.setXscs(xscs);
                item.setQckc(qckc);
                item.setQmkc(qmkc);
                zqckc = zqckc + qckc;
                zqmkc = zqmkc + qmkc;

                if (xscs <= 0) {
                    item.setKczzl("0");
                    item.setKcdxl("0");
                } else if (xscs > 0) {
                    double d1 = (xscs.doubleValue() / (qmkc.doubleValue() + xscs.doubleValue()));
                    double d2 = xscs.doubleValue() / zxscs.doubleValue() ;
                    item.setKczzl(nf.format(d1));
                    item.setKcdxl(nf.format(d2));
                } else {
                    item.setKczzl("0");
                    item.setKcdxl("0");
                }
            }

            double value = (zxscs.doubleValue() * 2) / (zqckc + zqmkc) ;
            zkczzl = nf.format(value);

        } catch (Exception e) {
            e.printStackTrace();
        }
        whcbResult.setItemList(itemList);
        whcbResult.setZxscs(zxscs);
        whcbResult.setZkczzl(zkczzl);
        whcbResult.setZqckc(zqckc);
        whcbResult.setZqmkc(zqmkc);
        return whcbResult;
    }

}
