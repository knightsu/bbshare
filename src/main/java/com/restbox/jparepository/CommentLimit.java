package com.restbox.jparepository;

import com.restbox.model.Comment;

import java.util.Collection;

public interface CommentLimit {
    Collection<Comment> findByBbsBlogIdAndPagenum(long blogId, int start);
    int findTotalCommentsForeachBlog(long blogId);
}
