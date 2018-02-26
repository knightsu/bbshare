package com.restbox.jparepository;

import com.restbox.Constant.Constant;
import com.restbox.model.BbsBlog;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

public class BbsBlogRepositoryImpl implements BlogLimit {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Collection<BbsBlog> fetchByFieldLimit(int page) {
        String sql = "select b from BbsBlog b order by b.createDate desc";
        int first = (page-1) * Constant.BLOGPAGE;
        Collection<BbsBlog> res = entityManager.createQuery(sql).setFirstResult(first).setMaxResults(Constant.BLOGPAGE).getResultList();
        return res;
    }

    @Override
    public Collection<BbsBlog> fetchByFieldLimit(String field, String value, int page) {
        if(field.equals("category"))
        {
            String sql = "select b from BbsBlog b where b.category= ?1 order by b.createDate desc";
            int first = (page-1) * Constant.BLOGPAGE;
            Collection<BbsBlog> res = entityManager.createQuery(sql).setParameter(1, value).setFirstResult(first).setMaxResults(Constant.BLOGPAGE).getResultList();
            return res;
        }

        return null;
    }

    @Override
    public Collection<BbsBlog> fetchByUsernameFieldLimit(String username, int page) {
        return null;
    }

    @Override
    public Collection<BbsBlog> fetchByUsernameFieldLimit(String field, String value, String username, int page) {
        return null;
    }

    @Override
    public int findTotalBlogs() {
        return 0;
    }

    @Override
    public int findTotalBlogs(String username) {
        return 0;
    }
}
