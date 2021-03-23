package com.tywh.kdt.util;

public class XmlUtil {

    public static String removeNameSpace(String xml) {
        String newXml = xml.replace(" xmlns=\"\"", "");
        return newXml;
    }
}
