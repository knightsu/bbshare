package com.restbox.service.impl;

import com.restbox.jparepository.BbsBlogRepository;
import com.restbox.model.BbsBlog;
import com.restbox.service.api.FetchOtherBlogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class FetchOtherBlogServiceImpl implements FetchOtherBlogService {

    @Autowired
    BbsBlogRepository bbsBlogRepository;

    @Override
    public Collection<BbsBlog> getAllBlogs(int page) {
        return null;
    }

    @Override
    public Collection<BbsBlog> getByCategory(String category, int page) {
        return null;
    }

    @Override
    public Collection<BbsBlog> getByServiceType(String serviceType, int page) {
        return null;
    }

    @Override
    public Collection<BbsBlog> getByItemType(String itemType, int page) {
        return null;
    }

    @Override
    public Collection<BbsBlog> getByDocType(String docType, int page) {
        return null;
    }

    @Override
    public Collection<BbsBlog> getByStatus(String status) {
        return null;
    }
}
