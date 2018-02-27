package com.restbox.service.impl;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.restbox.model.BbsBlog;
import com.restbox.service.api.ConstructBlogService;
import com.restbox.util.JTOUtil;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ConstructBlogServiceImpl implements ConstructBlogService{
    @Override
    public BbsBlog constructBlog(ObjectNode blogData) {
        BbsBlog bbsBlog = JTOUtil.convertToBlog(blogData);
        Date date = new Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        bbsBlog.setCreateDate(sqldate);
        return bbsBlog;
    }
}
