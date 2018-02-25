package com.restbox.util;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.restbox.model.BbsBlog;

import java.text.SimpleDateFormat;


public class JTOUtil {
    public static BbsBlog convertToBlog(ObjectNode blogData)
    {
        BbsBlog bbsBlog = new BbsBlog();
        //parse objectnode set fields to bbsblog
        if(blogData.get("username").isValueNode())
        {
            bbsBlog.setUsername(blogData.get("username").asText());
        }
        if (blogData.get("category").isValueNode())
        {
            bbsBlog.setCategory(blogData.get("category").asText());
        }
        if (blogData.get("title").isValueNode())
        {
            bbsBlog.setTitle(blogData.get("title").asText());
        }
        if(blogData.get("serviceType").isValueNode())
        {
            bbsBlog.setServiceType(blogData.get("serviceType").asText());
        }
        if(blogData.get("itemType").isValueNode())
        {
            bbsBlog.setItemType(blogData.get("itemType").asText());
        }
        if(blogData.get("description").isValueNode())
        {
            bbsBlog.setDescription(blogData.get("description").asText());
        }
        if(blogData.get("docType").isValueNode())
        {
            bbsBlog.setDocType(blogData.get("docType").asText());
        }
        if(blogData.get("status").isValueNode())
        {
            bbsBlog.setDocType(blogData.get("status").asText());
        }
        if(blogData.get("charge").isValueNode())
        {
            bbsBlog.setCharge(blogData.get("charge").asInt());
        }
        if(blogData.get("zipcode").isValueNode())
        {
            bbsBlog.setZipcode(blogData.get("zipcode").asText());
        }
        if(blogData.get("createdate").isValueNode())
        {
            String format = blogData.get("createdate").asText();
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy");

        }

        return bbsBlog;
    }
}
