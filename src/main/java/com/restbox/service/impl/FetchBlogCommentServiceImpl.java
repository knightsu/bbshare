package com.restbox.service.impl;

import com.restbox.model.Comment;
import com.restbox.service.api.FetchBlogCommentService;

import java.util.Collection;
import java.util.Date;

public class FetchBlogCommentServiceImpl implements FetchBlogCommentService {
    @Override
    public Collection<Comment> getBlogDetails(long blogId, int page) {
        return null;
    }

    @Override
    public Collection<Comment> getByTime(Date start, Date end, int page) {
        return null;
    }
}
