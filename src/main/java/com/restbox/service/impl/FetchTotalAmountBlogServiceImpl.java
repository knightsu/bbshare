package com.restbox.service.impl;

import com.restbox.jparepository.BbsBlogRepository;
import com.restbox.service.api.FetchTotalAmountBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FetchTotalAmountBlogServiceImpl implements FetchTotalAmountBlogService {
    @Autowired
    BbsBlogRepository bbsBlogRepository;

    @Override
    public long fetchTotalAmountBlogByUsername(String username) {
        return bbsBlogRepository.findTotalBlogs(username);
    }

    @Override
    public long fetchTotalAmountBlog() {
        return bbsBlogRepository.findTotalBlogs();
    }
}
