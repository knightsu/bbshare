package com.restbox.service.api;

import com.restbox.model.BbsBlog;
import com.restbox.model.Comment;

public interface CreateCommentService {
    BbsBlog postComment(String commentContent, long blogId, String username);
}
