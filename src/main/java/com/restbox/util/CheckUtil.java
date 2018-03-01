package com.restbox.util;

import com.restbox.datatype.*;

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


        return true;
    }

    public static boolean checkDateString(String input)
    {
        return true;
    }

}
