package com.restbox.jparepository;

import com.restbox.model.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

public class CommentRepositoryImpl implements CommentLimit {
    @PersistenceContext
    private EntityManager entityManager;

    public static final int PAGESIZE = 20;

    @Override
    public Collection<Comment> findByBbsBlogIdAndPagenum(long blogId, int page) {
        String sql = "SELECT c FROM Comment c WHERE c.BLOG_ID=  ?1 ORDER BY c.updateDate desc";

        int firstResult = (page -1) * PAGESIZE;
        Collection<Comment> result =  entityManager.createQuery(sql).setParameter(1, blogId)
                                        .setFirstResult(firstResult)
                                        .setMaxResults(PAGESIZE)
                                        .getResultList();

        return result;
    }

    @Override
    public int findTotalCommentsForeachBlog(long blogId) {
        return 0;
    }
}
