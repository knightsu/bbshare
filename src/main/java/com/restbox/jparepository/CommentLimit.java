package com.restbox.jparepository;

import com.restbox.model.Comment;

import java.sql.Date;
import java.util.Collection;

public interface CommentLimit {
    Collection<Comment> findByBbsBlogIdAndPagenum(long blogId, int page);
    long findTotalCommentsForeachBlog(long blogId);
    Collection<Comment> findByDatePeriodAndPage(long blogId, Date start, Date end, int page);
}
