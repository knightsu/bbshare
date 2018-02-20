package com.restbox.service.impl;

import com.restbox.jparepository.BbsBlogRepository;
import com.restbox.model.BbsBlog;
import com.restbox.service.api.CreateBlogService;
import com.restbox.service.api.FetchUserBlogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class CreateBlogServiceImpl implements CreateBlogService {

    @Autowired
    BbsBlogRepository bbsBlogRepository;

    @Autowired
    FetchUserBlogService fetchUserBlogService;
    @Override
    public Collection<BbsBlog> postBlog(BbsBlog bbsBlog, String username) {
        bbsBlogRepository.save(bbsBlog);
        return fetchUserBlogService.getAllBlogs(username, 1);
    }
}
