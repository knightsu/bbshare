package com.restbox.service.impl;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.restbox.model.BbsBlog;
import com.restbox.service.api.ConstructBlogService;
import com.restbox.util.JTOUtil;

import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;

public class ConstructBlogServiceImpl implements ConstructBlogService{
    @Override
    public BbsBlog constructBlog(ObjectNode blogData) {
        return JTOUtil.convertToBlog(blogData);
    }
}
