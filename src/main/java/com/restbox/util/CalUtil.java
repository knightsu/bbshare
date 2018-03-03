package com.restbox.util;

import org.slf4j.Logger;


import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
