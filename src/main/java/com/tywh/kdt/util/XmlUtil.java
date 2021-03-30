package com.tywh.kdt.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class XmlUtil {

    public static String objToXml(Object obj) throws Exception{
        // 创建输出流
        StringWriter sw = new StringWriter();

        // 利用jdk中自带的转换类实现
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();

//        // 格式化xml输出的格式
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
//                Boolean.TRUE);

        // 将对象转换成输出流形式的xml
        marshaller.marshal(obj, sw);

        return sw.toString().replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>","");
    }
}
