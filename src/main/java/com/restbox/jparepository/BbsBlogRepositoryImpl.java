package com.restbox.jparepository;

import com.restbox.Constant.Constant;
import com.restbox.model.BbsBlog;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.*;

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
    public Collection<BbsBlog> fetchByFieldLimit(Map<String, String> map, int page) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<BbsBlog> query = criteriaBuilder.createQuery(BbsBlog.class);
        Root<BbsBlog> b = query.from(BbsBlog.class);
        query.select(b);
        //service side check map valid
        List<Predicate> predicates = new ArrayList<Predicate>();
        map.keySet().forEach((p)->predicates.add(criteriaBuilder.equal(b.get(p), map.get(p))));
//        for(String s : map.keySet())
//        {
//            predicates.add(criteriaBuilder.equal(b.get(s), map.get(s)));
//        }
        query.where(predicates.toArray(new Predicate[]{}));
        query.orderBy(criteriaBuilder.desc(b.get("createDate")));
        int first = (page-1) * Constant.BLOGPAGE;
        Collection<BbsBlog> res = entityManager.createQuery(query).setFirstResult(first).setMaxResults(Constant.BLOGPAGE).getResultList();
        return res;
    }

    @Override
    public Collection<BbsBlog> fetchByUsernameFieldLimit(String username, int page) {
        String sql = "select b from BbsBlog b where b.username = ?1 order by b.createDate desc";
        int first = (page-1) * Constant.BLOGPAGE;
        Collection<BbsBlog> res = entityManager.createQuery(sql).setParameter(1, username).setFirstResult(first).setMaxResults(Constant.BLOGPAGE).getResultList();
        return res;
    }

    @Override
    public Collection<BbsBlog> fetchByUsernameFieldLimit(Map<String, String> map, String username, int page) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<BbsBlog> query = criteriaBuilder.createQuery(BbsBlog.class);
        Root<BbsBlog> b = query.from(BbsBlog.class);
        query.select(b);
        //service side check map valid
        List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(criteriaBuilder.equal(b.get("username"), username));
        map.keySet().forEach((p)->predicates.add(criteriaBuilder.equal(b.get(p), map.get(p))));
//        for(String s : map.keySet())
//        {
//            predicates.add(criteriaBuilder.equal(b.get(s), map.get(s)));
//        }
        query.where(predicates.toArray(new Predicate[]{}));
        query.orderBy(criteriaBuilder.desc(b.get("createDate")));
        int first = (page-1) * Constant.BLOGPAGE;
        Collection<BbsBlog> res = entityManager.createQuery(query).setFirstResult(first).setMaxResults(Constant.BLOGPAGE).getResultList();
        return res;
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

    @Override
    @Transactional
    public int updateByFieldMap(Map<String, String> map, String username, long blogId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<BbsBlog> update = criteriaBuilder.createCriteriaUpdate(BbsBlog.class);
        Root<BbsBlog> b = update.from(BbsBlog.class);
        map.keySet().forEach((p) -> update.set(p, map.get(p)));
        Date date = new Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        update.set("createDate", sqldate);
        update.where(criteriaBuilder.equal(b.get("username"), username), criteriaBuilder.equal(b.get("id"), blogId));
        return entityManager.createQuery(update).executeUpdate();

    }
}
