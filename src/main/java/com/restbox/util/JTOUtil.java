package com.restbox.util;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.restbox.error.Error;
import com.restbox.error.InputFormatIllegalException;
import com.restbox.model.BbsBlog;
import com.restbox.model.BbsUser;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

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
//        if (blogData.get("create").isValueNode()) {
//            bbsBlog.setCreateDate(CalUtil.convertStringtoTime(blogData.get("create").asText()));
//        }
        if (blogData.get("start").isValueNode()) {
            if(CheckUtil.checkTimeString(blogData.get("start").asText())) throw new InputFormatIllegalException();
            bbsBlog.setStartDate(CalUtil.convertStringtoTime(blogData.get("start").asText()));
        }
        if (blogData.get("end").isValueNode()) {
            if(CheckUtil.checkTimeString(blogData.get("end").asText())) throw new InputFormatIllegalException();
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
        if(userData.get("zipcode").isValueNode())
        {
            bbsUser.setZipcode(userData.get("zipcode").asText());
        }
        return bbsUser;
    }

    @ExceptionHandler(InputFormatIllegalException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error inputFormatIllegal(InputFormatIllegalException e)
    {
        Error error = new Error(4, "check your input date format should be yyyyMMddhhmmss");
        return error;
    }

}
