package com.restbox.jparepository;

import com.restbox.Constant.Constant;
import com.restbox.model.BbsBlog;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
        if (field.equals("category")) {
            String sql = "select b from BbsBlog b where b.category= ?1 order by b.createDate desc";
            int first = (page - 1) * Constant.BLOGPAGE;
            Collection<BbsBlog> res = entityManager.createQuery(sql).setParameter(1, value).setFirstResult(first).setMaxResults(Constant.BLOGPAGE).getResultList();
            return res;
        } else if (field.equals("service")) {
            String sql = "select b from BbsBlog b where b.serviceType = ?1 order by b.createDate desc";
            int first = (page - 1) * Constant.BLOGPAGE;
            Collection<BbsBlog> res = entityManager.createQuery(sql).setParameter(1, value).setFirstResult(first).setMaxResults(Constant.BLOGPAGE).getResultList();
            return res;
        } else if (field.equals("item")) {
            String sql = "select b from BbsBlog b where b.itemType = ?1 order by b.createDate desc";
            int first = (page - 1) * Constant.BLOGPAGE;
            Collection<BbsBlog> res = entityManager.createQuery(sql).setParameter(1, value).setFirstResult(first).setMaxResults(Constant.BLOGPAGE).getResultList();
            return res;
        } else if (field.equals("doc")) {
            String sql = "select b from BbsBlog b where b.docType = ?1 order by b.createDate desc";
            int first = (page - 1) * Constant.BLOGPAGE;
            Collection<BbsBlog> res = entityManager.createQuery(sql).setParameter(1, value).setFirstResult(first).setMaxResults(Constant.BLOGPAGE).getResultList();
            return res;
        } else if (field.equals("status")) {
            String sql = "select b from BbsBlog b where b.status = ?1 order by b.createDate desc, b.startDate";
            int first = (page - 1) * Constant.BLOGPAGE;
            Collection<BbsBlog> res = entityManager.createQuery(sql).setParameter(1, value).setFirstResult(first).setMaxResults(Constant.BLOGPAGE).getResultList();
            return res;
        } else return null;
    }

    @Override
    public Collection<BbsBlog> fetchByUsernameFieldLimit(String username, int page) {
        String sql = "select b from BbsBlog b where b.username = ?1 order by b.createDate desc";
        int first = (page-1) * Constant.BLOGPAGE;
        Collection<BbsBlog> res = entityManager.createQuery(sql).setParameter(1, username).setFirstResult(first).setMaxResults(Constant.BLOGPAGE).getResultList();
        return res;
    }

    @Override
    public Collection<BbsBlog> fetchByUsernameFieldLimit(String field, String value, String username, int page) {
        if(field.equals("category"))
        {
            String sql = "select b from BbsBlog b where b.category= ?1 and b.username = ?2 order by b.createDate desc";
            int first = (page-1) * Constant.BLOGPAGE;
            Collection<BbsBlog> res = entityManager.createQuery(sql).setParameter(1, value).setParameter(2, username).setFirstResult(first).setMaxResults(Constant.BLOGPAGE).getResultList();
            return res;
        } else if(field.equals("service"))
        {
            String sql = "select b from BbsBlog b where b.serviceType = ?1 and b.username = ?2 order by b.createDate desc";
            int first = (page-1) * Constant.BLOGPAGE;
            Collection<BbsBlog> res = entityManager.createQuery(sql).setParameter(1, value).setParameter(2, username).setFirstResult(first).setMaxResults(Constant.BLOGPAGE).getResultList();
            return res;
        } else if(field.equals("item"))
        {
            String sql = "select b from BbsBlog b where b.itemType = ?1 and b.username = ?2 order by b.createDate desc";
            int first = (page-1) * Constant.BLOGPAGE;
            Collection<BbsBlog> res = entityManager.createQuery(sql).setParameter(1, value).setParameter(2, username).setFirstResult(first).setMaxResults(Constant.BLOGPAGE).getResultList();
            return res;
        } else if(field.equals("doc"))
        {
            String sql = "select b from BbsBlog b where b.docType = ?1 and b.username = ?2 order by b.createDate desc";
            int first = (page-1) * Constant.BLOGPAGE;
            Collection<BbsBlog> res = entityManager.createQuery(sql).setParameter(1, value).setParameter(2, username).setFirstResult(first).setMaxResults(Constant.BLOGPAGE).getResultList();
            return res;
        } else if(field.equals("status"))
        {
            String sql = "select b from BbsBlog b where b.status = ?1 and b.username = ?2 order by b.createDate desc, b.startDate";
            int first = (page-1) * Constant.BLOGPAGE;
            Collection<BbsBlog> res = entityManager.createQuery(sql).setParameter(1, value).setParameter(2, username).setFirstResult(first).setMaxResults(Constant.BLOGPAGE).getResultList();
            return res;
        } else return null;
    }

    @Override
    public long findTotalBlogs() {
        String sql = "select count(distinct b.id) from BbsBlog b";
        Query query = entityManager.createQuery(sql);
        long total = (Long)query.getSingleResult();
        return total;
    }

    @Override
    public long findTotalBlogs(String username) {
        String sql = "select count(distinct b.id) from BbsBlog b where b.username = ?1";
        Query query = entityManager.createQuery(sql).setParameter(1, username);
        long total = (Long)query.getSingleResult();
        return total;
    }
}
