package com.restbox.service.impl;

import com.restbox.jparepository.BbsBlogRepository;
import com.restbox.model.BbsBlog;
import com.restbox.service.api.CreateBlogService;
import com.restbox.service.api.FetchBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class CreateBlogServiceImpl implements CreateBlogService {

    @Autowired
    BbsBlogRepository bbsBlogRepository;

    @Autowired
    FetchBlogService fetchBlogService;
    @Override
    public Collection<BbsBlog> postBlog(BbsBlog bbsBlog, String username) {
        bbsBlogRepository.save(bbsBlog);
        Map<String, String> map = new HashMap<>();

        return fetchBlogService.getWithUsername(map, username, 1);
    }
}
