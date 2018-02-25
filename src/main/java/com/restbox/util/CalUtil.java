package com.restbox.util;

import org.slf4j.Logger;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CalUtil {
    public static Date convertStringtoTime(String s)
    {
        java.util.Date date;
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd hhmmss");
        try {
            date = format.parse(s);
            Date sqldate = new Date(date.getTime());
            return sqldate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public static Date convertStringtoDate(String s)
    {
        java.util.Date date;
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        try {
            date = format.parse(s);
            Date sqlDate = new Date(date.getTime());
            return sqlDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
