package com.tywh.kdt.api.pojo;

import java.util.List;

public class Fxsd {
//select fhdbh,fhzt,bz,djlx,txrq,shsj,khmc,rydm,jsr,djkwmc,djkwbh,xsbmid from fxsdview where djlx = '调拨'
    private String fhdbh;

    private String djkwbh;

    private String txrq;

    private String orderType;

    private String bz;

    private List<String> receiverInfo;

    private List<Fxsmx> fxsmxList;
}
