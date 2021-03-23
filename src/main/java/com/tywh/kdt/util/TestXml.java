package com.tywh.kdt.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.util.ArrayList;
import java.util.List;

public class TestXml {
    public static void main(String[] args) {
        Test request = new Test();
        Student student1 = new Student(1,"ruomeng1",1.78,false);
        Student student2 = new Student(2,"ruomeng2",1.81,true);
        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        request.setOrderLine(list);
//        Student student = new Student();
//        student.setId(1);
        XmlMapper xmlMapper = new XmlMapper();
        String xml = null;
        try {
            xml = XmlUtil.removeNameSpace(xmlMapper.writeValueAsString(request));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(xml);

    }

}
