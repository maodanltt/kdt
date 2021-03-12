package com.tywh.kdt.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
    日期格式化工具类
 */
public class DateUtil {

    public static String format(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result = sdf.format(date);
        return result;
    }
}
