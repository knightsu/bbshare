package com.restbox.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class DateFormatConverterTest {
    @Test
    public void convert() throws Exception {
        String input = "20170423133000";
        String res = DateFormatConverter.convert(input);
        assertEquals("2017-04-23 13:30:00", res);
    }

}