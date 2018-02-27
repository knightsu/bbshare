package com.restbox.service.impl;

import com.restbox.jparepository.BbsBlogRepository;
import com.restbox.service.api.DeleteBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteBlogServiceImpl implements DeleteBlogService {

    @Autowired
    BbsBlogRepository bbsBlogRepository;

    @Override
    public void deleteBlogbyBlogId(long blogId) {
        bbsBlogRepository.delete(blogId);
    }
}
