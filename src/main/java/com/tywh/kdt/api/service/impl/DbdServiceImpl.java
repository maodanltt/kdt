package com.tywh.kdt.api.service.impl;

import com.tywh.kdt.api.mapper.DbdMapper;
import com.tywh.kdt.api.pojo.Dbd;
import com.tywh.kdt.api.service.DbdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbdServiceImpl implements DbdService {

    @Autowired
    private DbdMapper dbdMapper;

    @Override
    public List<Dbd> queryDbdList(String fhdbh) throws Exception {
        return dbdMapper.queryDbdList(fhdbh);
    }
}
