package com.tywh.kdt.api.web;

import com.tywh.kdt.api.pojo.Dbd;
import com.tywh.kdt.api.service.DbdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/dbd")
public class DbdController {

    @Autowired
    private DbdService dbdService;

    @RequestMapping("/queryDbdList")
    @ResponseBody
    public List<Dbd> queryDbdList(String fhdbh) {
        try {
            List<Dbd> dbdList = dbdService.queryDbdList(fhdbh);

            Map<String, List<Dbd>> map = new HashMap<>();

            for (int i=0; i<dbdList.size(); i++) {
                if (i == 0) {
//                    map.put(dbdList.get(0).getKwbh())
                }
            }

            return dbdList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
