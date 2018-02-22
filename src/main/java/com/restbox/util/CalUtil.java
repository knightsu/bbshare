package com.restbox.util;

import java.sql.Timestamp;

public class CalUtil {
    public static Timestamp convertStringtoTime(String s)
    {
        Timestamp ts = Timestamp.valueOf(s);
        return ts;
    }

}
