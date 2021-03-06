package com.restbox.service.impl;

import com.restbox.jparepository.CommentRepository;
import com.restbox.service.api.DeleteCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCommentServiceImpl implements DeleteCommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public void deleteCommentByCommentId(long commentId) {
        commentRepository.delete(commentId);
    }
}
