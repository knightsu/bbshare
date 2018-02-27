package com.restbox.service.impl;

import com.restbox.jparepository.BbsBlogRepository;
import com.restbox.model.BbsBlog;
import com.restbox.service.api.FetchOtherBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FetchOtherBlogServiceImpl implements FetchOtherBlogService {

    @Autowired
    BbsBlogRepository bbsBlogRepository;

    @Override
    public Collection<BbsBlog> getAllBlogs(int page) {
        return bbsBlogRepository.fetchByFieldLimit(page);
    }

    @Override
    public Collection<BbsBlog> getByCategory(String category, int page) {
        return bbsBlogRepository.fetchByFieldLimit("category", category, page);
    }

    @Override
    public Collection<BbsBlog> getByServiceType(String serviceType, int page) {
        return bbsBlogRepository.fetchByFieldLimit("service", serviceType, page);
    }

    @Override
    public Collection<BbsBlog> getByItemType(String itemType, int page) {
        return bbsBlogRepository.fetchByFieldLimit("item", itemType, page);
    }

    @Override
    public Collection<BbsBlog> getByDocType(String docType, int page) {
        return bbsBlogRepository.fetchByFieldLimit("doc", docType, page);
    }

    @Override
    public Collection<BbsBlog> getByStatus(String status, int page) {
        return bbsBlogRepository.fetchByFieldLimit("status", status, page);
    }
}
