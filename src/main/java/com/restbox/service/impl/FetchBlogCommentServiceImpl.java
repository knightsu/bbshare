package com.restbox.service.impl;

import com.restbox.jparepository.CommentRepository;
import com.restbox.model.Comment;
import com.restbox.service.api.FetchBlogCommentService;
import com.restbox.service.api.FetchTotalAmountCommentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Date;

public class FetchBlogCommentServiceImpl implements FetchBlogCommentService {

    @Autowired
    CommentRepository commentRepository;



    private int total;

    @Override
    public Collection<Comment> getBlogDetails(long blogId, int page) {
        int row = page*20+1;
        return null;
    }

    @Override
    public Collection<Comment> getByTime(Date start, Date end, int page) {
        return null;
    }
}
