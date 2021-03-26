package com.tywh.kdt.api.service.impl;

import com.tywh.kdt.api.mapper.DbdMapper;
import com.tywh.kdt.api.pojo.Dbd;
import com.tywh.kdt.api.service.DbdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DbdServiceImpl implements DbdService {

    @Autowired
    private DbdMapper dbdMapper;

    @Override
    public Map<String, List<Dbd>> queryDbdList(String fhdbh) throws Exception {
        List<Dbd> dbdList = dbdMapper.queryDbdList(fhdbh);
        Map<String, List<Dbd>> result = new HashMap<>();

        for (int i=0; i<dbdList.size(); i++) {
            if (i == 0) {
                List<Dbd> list = new ArrayList<>();
                list.add(dbdList.get(0));
                result.put(dbdList.get(0).getKwbh(),list);
            }

            if (i > 0 && result.containsKey(dbdList.get(i).getKwbh())) {
                result.get(dbdList.get(i).getKwbh()).add(dbdList.get(i));
            } else if (i > 0 && !result.containsKey(dbdList.get(i).getKwbh())) {
                List<Dbd> list1 = new ArrayList<>();
                list1.add(dbdList.get(i));
                result.put(dbdList.get(i).getKwbh(),list1);
            }
        }
        return result;
    }
}
