package com.tywh.kdt.util;

import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateDiffUtil {

    public static long getDifferenceDays(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    //    public static long betweenDates(Date firstDate, Date secondDate) throws IOException{
//        return ChronoUnit.DAYS.between(firstDate.toInstant(), secondDate.toInstant());
//    }
//    public static void main(String[] args) {
//        long days = getDifferenceDays(DateUtil.format("2021-03-15"), new Date());
//        System.out.println(days);
//    }
}
