package com.restbox.service.api;

import com.restbox.model.BbsBlog;
import com.restbox.model.Comment;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

public interface FetchBlogService {

    Collection<BbsBlog> getWOUsername(Map<String, String> map, int page);
    Collection<BbsBlog> getWithUsername(Map<String, String> map, String username, int page);



}
