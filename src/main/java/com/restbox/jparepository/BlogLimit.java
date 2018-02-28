package com.restbox.jparepository;

import com.restbox.model.BbsBlog;

import java.util.Collection;
import java.util.Map;

public interface BlogLimit {
    Collection<BbsBlog> fetchByFieldLimit(int page);
    Collection<BbsBlog> fetchByFieldLimit(String field, String value, int page);
    Collection<BbsBlog> fetchByUsernameFieldLimit(String username, int page);
    Collection<BbsBlog> fetchByUsernameFieldLimit(Map<String, String> map, String username, int page);
    long findTotalBlogs();
    long findTotalBlogs(String username);
    int updateStatus(String status, long blogId);
}
