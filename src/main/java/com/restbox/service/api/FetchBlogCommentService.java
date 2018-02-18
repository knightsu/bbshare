package com.restbox.service.api;

import com.restbox.model.Comment;

import java.util.Collection;
import java.util.Date;

public interface FetchBlogCommentService {
    Collection<Comment> getBlogDetails(long blogId, int page);
    Collection<Comment> getByTime(Date start, Date end, int page);
}
