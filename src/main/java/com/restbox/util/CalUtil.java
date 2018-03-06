package com.restbox.util;

import org.slf4j.Logger;


import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalUtil {
    public static Timestamp convertStringtoTime(String s)
    {
        Date date;
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            date = format.parse(s);
            Timestamp sqltime = new Timestamp(date.getTime());
            return sqltime;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  null;
    }
    public static boolean compareTwoDate(Date dbdate)
    {
        Date current = new Date();
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(dbdate);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(current);
        boolean flag = (cal1.get(Calendar.YEAR)==cal2.get(Calendar.YEAR) && cal1.get(Calendar.DAY_OF_YEAR)==cal2.get(Calendar.DAY_OF_YEAR));
        return flag;
    }
//    public static Date convertStringtoDate(String s)
//    {
//        java.util.Date date;
//        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
//        try {
//            date = format.parse(s);
//            Date sqlDate = new Date(date.getTime());
//            return sqlDate;
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
