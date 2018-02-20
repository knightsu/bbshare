package com.restbox.service.api;

import com.restbox.model.BbsBlog;

import java.util.Collection;

public interface CreateBlogService {

    Collection<BbsBlog> postBlog(BbsBlog bbsBlog, String username);
}
