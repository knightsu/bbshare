package com.restbox.jparepository;

import com.restbox.model.BbsBlog;

import java.util.Collection;

public interface BlogLimit {
    Collection<BbsBlog> fetchByFieldLimit(int page);
    Collection<BbsBlog> fetchByFieldLimit(String field, int page);
    Collection<BbsBlog> fetchByUsernameFieldLimit(int page);
    Collection<BbsBlog> fetchByUsernameFieldLimit(String field, int page);
    int findTotalBlogs();
    int findTotalBlogs(String username);
}
