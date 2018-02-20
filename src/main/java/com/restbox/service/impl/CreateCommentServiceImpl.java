package com.restbox.service.impl;

import com.restbox.jparepository.BbsBlogRepository;
import com.restbox.jparepository.CommentRepository;
import com.restbox.model.BbsBlog;
import com.restbox.model.Comment;
import com.restbox.service.api.CreateCommentService;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateCommentServiceImpl implements CreateCommentService {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    BbsBlogRepository bbsBlogRepository;

    @Override
    public BbsBlog postComment(String commentContent, long blogId, String username) {
        BbsBlog bbsBlog = bbsBlogRepository.findBbsBlogById(blogId);
        Comment comment = new Comment(username,commentContent);
        comment.setBbsBlog(bbsBlog);
        bbsBlog.getComments().add(comment);
        commentRepository.save(comment);
        return bbsBlog;
    }
}
