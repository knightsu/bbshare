package com.restbox.jparepository;

import com.restbox.model.BbsBlog;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

public class BbsBlogRepositoryImpl implements BlogLimit {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Collection<BbsBlog> fetchByFieldLimit(int page) {
        return null;
    }

    @Override
    public Collection<BbsBlog> fetchByFieldLimit(String field, int page) {
        return null;
    }

    @Override
    public Collection<BbsBlog> fetchByUsernameFieldLimit(int page) {
        return null;
    }

    @Override
    public Collection<BbsBlog> fetchByUsernameFieldLimit(String field, int page) {
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
