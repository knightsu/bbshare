package com.restbox.service.impl;

import com.restbox.jparepository.BbsBlogRepository;
import com.restbox.jparepository.CommentRepository;
import com.restbox.model.BbsBlog;
import com.restbox.model.Comment;
import com.restbox.service.api.CreateCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CreateCommentServiceImpl implements CreateCommentService {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    BbsBlogRepository bbsBlogRepository;

    @Override
    public BbsBlog postComment(String commentContent, long blogId, String username) {
        BbsBlog bbsBlog = bbsBlogRepository.findBbsBlogById(blogId);
        Comment comment = new Comment();
        comment.setUsername(username);
        comment.setContent(commentContent);
        Date date = new Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        comment.setUpdateDate(sqldate);
        comment.setBbsBlog(bbsBlog);
        bbsBlog.getComments().add(comment);
        commentRepository.save(comment);
        return bbsBlog;
    }
}
