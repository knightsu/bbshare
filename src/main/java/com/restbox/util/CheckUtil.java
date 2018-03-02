package com.restbox.util;

import com.restbox.datatype.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CheckUtil {

    public static boolean checkGet(Map<String, String> map){
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
        if(map.containsKey("category"))
        {
            Category category = Category.getCategory(map.get("category"));
            if(category==Category.OTHER && !map.get("category").equals("other")) return false;
        }
        if(map.containsKey("serviceType"))
        {
            ServiceType serviceType = ServiceType.getServiceType(map.get("serviceType"));
            if(serviceType==ServiceType.RENT && !map.get("serviceType").equals("rent")) return false;
        }
        if(map.containsKey("itemType"))
        {
            ItemType itemType = ItemType.getItemType(map.get("itemType"));
            if(itemType==ItemType.VERTUAL && !map.get("itemType").equals("account")) return false;
        }
        if(map.containsKey("docType"))
        {
            DocType docType = DocType.getDocType(map.get("docType"));
            if(docType==DocType.CONSUME && !map.get("docType").equals("consume")) return false;
        }
        if(map.containsKey("status"))
        {
            Status status = Status.getStatusvalue(map.get("status"));
            if(status==Status.DISCARD && !map.get("status").equals("old")) return false;
        }
        return true;
    }

    public static boolean checkUpdate(Map<String, String> map) {
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
        if(map.containsKey("startDate"))
        {
            if(!checkTimeString(map.get("startDate"))) return false;
        }
        if(map.containsKey("endDate"))
        {
            if(!checkTimeString(map.get("endDate"))) return false;
        }
        return true;
    }

    public static boolean checkDateString(String input)
    {
        if(input.length()!=8) return false;
        if(!checkDigits(input)) return false;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 31); map.put(2,28); map.put(3,31); map.put(4,30); map.put(5, 31);map.put(6, 30);
        map.put(7, 31); map.put(8, 31); map.put(9, 30); map.put(10, 31); map.put(11, 30); map.put(12, 31);
        int year = Integer.parseInt(input.substring(4));
        int month = Integer.parseInt(input.substring(4, 6));
        int day = Integer.parseInt(input.substring(6, 8));
        if (month < 1 || month > 12) return false;
        if(month!=2 && day>map.get(month)) return false;
        if(month==2)
        {
            if(year%4==0 || (year%100==0 && year%400==0) && day>map.get(2)+1) return false;
            else if(year%4!=0 || (year%100==0 && year%400!=0) && day>map.get(2)) return false;
        }
        return true;
    }

    public static boolean checkTimeString(String input)
    {
        if(input.length()!=14) return false;
        if(!checkDigits(input)) return false;
        if(!checkDateString(input)) return false;
        int hour = Integer.parseInt(input.substring(8, 10));
        int minute = Integer.parseInt(input.substring(10, 12));
        int seconde = Integer.parseInt(input.substring(12, 14));
        if(hour>23) return false;
        if(minute>59) return false;
        if(seconde>59) return false;
        return true;
    }

    private static boolean checkDigits(String input)
    {
        for(char c : input.toCharArray())
        {
            if(!Character.isDigit(c)) return false;
        }
        return true;
    }
}
