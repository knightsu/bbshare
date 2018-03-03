package com.restbox.util;

public class DateFormatConverter {
    public static String convert(String input)
    {
        String year = input.substring(0, 4);
        String month = input.substring(4, 6);
        String day = input.substring(6, 8);
        String hour = input.substring(8, 10);
        String minute = input.substring(10, 12);
        String second = input.substring(12, 14);

        String res = year + "-" + month + "-"+day +" " + hour + ":"+minute+":"+second;
        return res;
    }
}
