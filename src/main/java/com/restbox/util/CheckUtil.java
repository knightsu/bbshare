package com.restbox.util;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CheckUtil {

    public static boolean checkFieldGet(Map<String, String> map){
        Set<String> temp = new HashSet<String>();
        temp.add("category");
        temp.add("serviceType");
        temp.add("docType");
        temp.add("itemType");
        temp.add("status");
        temp.add("page");
        for(String s : map.keySet())
        {
            if(!temp.contains(s))
                return false;
        }
        return true;
    }

    public static boolean checkFeildUpdate(Map<String, String> map) {
        Set<String> temp = new HashSet<String>();
        temp.add("charge");
        temp.add("title");
        temp.add("description");
        temp.add("status");
        temp.add("startDate"); temp.add("endDate");

        for(String s : map.keySet())
        {
            if(!temp.contains(s))
                return false;
        }
        return true;
    }

}
