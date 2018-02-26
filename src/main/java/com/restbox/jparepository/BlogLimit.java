package com.restbox.jparepository;

import com.restbox.model.BbsBlog;

import java.util.Collection;

public interface BlogLimit {
    Collection<BbsBlog> fetchByFieldLimit(int page);
    Collection<BbsBlog> fetchByFieldLimit(String field, String value, int page);
    Collection<BbsBlog> fetchByUsernameFieldLimit(String username, int page);
    Collection<BbsBlog> fetchByUsernameFieldLimit(String field, String value, String username, int page);
    int findTotalBlogs();
    int findTotalBlogs(String username);
}
