package com.restbox.service.impl;

import com.restbox.jparepository.CommentRepository;
import com.restbox.model.Comment;
import com.restbox.service.api.FetchBlogCommentService;
import com.restbox.service.api.FetchTotalAmountCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

@Service
public class FetchBlogCommentServiceImpl implements FetchBlogCommentService {

    @Autowired
    CommentRepository commentRepository;



    private int total;

    @Override
    public Collection<Comment> getBlogDetails(long blogId, int page) {
        return commentRepository.findByBbsBlogIdAndPagenum(blogId, page);
    }

    @Override
    public Collection<Comment> getByTime(long blogId, Date start, Date end, int page) {

        java.sql.Date sqlstart = new java.sql.Date(start.getTime());
        java.sql.Date sqlend = new java.sql.Date(end.getTime());

        return commentRepository.findByDatePeriodAndPage(blogId, sqlstart, sqlend, page);
    }
}
