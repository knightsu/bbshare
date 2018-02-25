package com.restbox.util;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.restbox.model.BbsBlog;
import com.restbox.model.BbsUser;

import java.text.SimpleDateFormat;


public class JTOUtil {
    public static BbsBlog convertToBlog(ObjectNode blogData)
    {
        BbsBlog bbsBlog = new BbsBlog();
        //parse objectnode set fields to bbsblog
        if (blogData.get("username").isValueNode()) {
            bbsBlog.setUsername(blogData.get("username").asText());
        }
        if (blogData.get("category").isValueNode()) {
            bbsBlog.setCategory(blogData.get("category").asText());
        }
        if (blogData.get("title").isValueNode()) {
            bbsBlog.setTitle(blogData.get("title").asText());
        }
        if (blogData.get("serviceType").isValueNode()) {
            bbsBlog.setServiceType(blogData.get("serviceType").asText());
        }
        if (blogData.get("itemType").isValueNode()) {
            bbsBlog.setItemType(blogData.get("itemType").asText());
        }
        if (blogData.get("description").isValueNode()) {
            bbsBlog.setDescription(blogData.get("description").asText());
        }
        if (blogData.get("docType").isValueNode()) {
            bbsBlog.setDocType(blogData.get("docType").asText());
        }
        if (blogData.get("status").isValueNode()) {
            bbsBlog.setDocType(blogData.get("status").asText());
        }
        if (blogData.get("charge").isValueNode()) {
            bbsBlog.setCharge(blogData.get("charge").asInt());
        }
        if (blogData.get("zipcode").isValueNode()) {
            bbsBlog.setZipcode(blogData.get("zipcode").asText());
        }
        if (blogData.get("create").isValueNode()) {
            bbsBlog.setCreateDate(CalUtil.convertStringtoTime(blogData.get("create").asText()));
        }
        if (blogData.get("start").isValueNode()) {
            bbsBlog.setStartDate(CalUtil.convertStringtoTime(blogData.get("start").asText()));
        }
        if (blogData.get("end").isValueNode()) {
            bbsBlog.setEndDate(CalUtil.convertStringtoTime(blogData.get("end").asText()));
        }
        return bbsBlog;
    }
    public static BbsUser converttoUser(ObjectNode userData)
    {
        BbsUser bbsUser = new BbsUser();
        if(userData.get("username").isValueNode())
        {
            bbsUser.setUsername(userData.get("username").asText());
        }
        if(userData.get("city").isValueNode())
        {
            bbsUser.setCity(userData.get("city").asText());
        }
        if(userData.get("state").isValueNode())
        {
            bbsUser.setState(userData.get("state").asText());
        }
        if(userData.get("address").isValueNode())
        {
            bbsUser.setAddress(userData.get("address").asText());
        }
        if(userData.get("phone").isValueNode())
        {
            bbsUser.setPhone(userData.get("phone").asText());
        }
        if(userData.get("coin").isValueNode())
        {
            bbsUser.setCoins(userData.get("coin").asLong());
        }
        if(userData.get("zipcode").isValueNode())
        {
            bbsUser.setZipcode(userData.get("zipcode").asText());
        }
        if(userData.get("register").isValueNode())
        {
            bbsUser.setRegisterDate(CalUtil.convertStringtoDate(userData.get("register").asText()));
        }
        return bbsUser;
    }

}
