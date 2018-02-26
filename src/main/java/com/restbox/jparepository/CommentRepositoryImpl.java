package com.restbox.jparepository;

import com.restbox.Constant.Constant;
import com.restbox.model.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Date;
import java.util.Collection;

public class CommentRepositoryImpl implements CommentLimit {
    @PersistenceContext
    private EntityManager entityManager;

   // public static final int PAGESIZE = 20;

    @Override
    public Collection<Comment> findByBbsBlogIdAndPagenum(long blogId, int page) {
        String sql = "SELECT c FROM Comment c WHERE c.bbsBlog.id =  ?1 ORDER BY c.updateDate desc";

        int firstResult = (page -1) * Constant.COMMENT;
        Collection<Comment> result =  entityManager.createQuery(sql).setParameter(1, blogId)
                                        .setFirstResult(firstResult)
                                        .setMaxResults(Constant.COMMENT)
                                        .getResultList();

        return result;
    }

    @Override
    public long findTotalCommentsForeachBlog(long blogId) {
        String sql = "select count(c.id) from Comment c where c.bbsBlog.id = ?1 order by c.updateDate desc";
        Query query = entityManager.createQuery(sql).setParameter(1, blogId);
        long total = (Long)query.getSingleResult();
        return total;
    }

    @Override
    public Collection<Comment> findByDatePeriodAndPage(long blogId, Date start, Date end, int page) {
        String sql = "select c from Comment c where c.updateDate between ?1 and ?2 and c.bbsBlog.id = ?3 order by c.updateDate desc";
        Query query = entityManager.createQuery(sql).setParameter(1, start).setParameter(2, end).setParameter(3, blogId);
        int first = (page -1) * Constant.COMMENT;
        Collection<Comment> result = query.setFirstResult(first).setMaxResults(Constant.COMMENT).getResultList();
        return result;
    }
}
