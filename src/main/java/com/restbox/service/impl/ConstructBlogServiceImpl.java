package com.restbox.service.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restbox.model.BbsBlog;
import com.restbox.service.api.ConstructBlogService;

import java.sql.Timestamp;
import java.util.Date;

public class ConstructBlogServiceImpl implements ConstructBlogService{
    @Override
    public BbsBlog constructBlog(BbsBlog blogData) {
        blogData.setCreateDate(new Timestamp(System.currentTimeMillis()));
        return blogData;
    }
}
