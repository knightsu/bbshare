package com.restbox.service.api;

import com.restbox.model.BbsBlog;
import com.restbox.model.Comment;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

public interface FetchUserBlogService {

    Collection<BbsBlog> getAllBlogs(String username, int page);
    Collection<BbsBlog> getByFieldname(Map<String, String> map, String username);



}
