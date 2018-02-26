package com.restbox.service.impl;

import com.restbox.jparepository.BbsBlogRepository;
import com.restbox.model.BbsBlog;
import com.restbox.service.api.FetchUserBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class FetchUserBlogServiceImpl implements FetchUserBlogService {
    @Autowired
    BbsBlogRepository bbsBlogRepository;

    @Override
    public Collection<BbsBlog> getAllBlogs(String username, int page) {
        return bbsBlogRepository.fetchByUsernameFieldLimit(username, page);
    }

    @Override
    public Collection<BbsBlog> getByCategory(String username, String category, int page) {
        return bbsBlogRepository.fetchByUsernameFieldLimit("category", category, username, page);
    }

    @Override
    public Collection<BbsBlog> getByServiceType(String username, String serviceType, int page) {
        return bbsBlogRepository.fetchByUsernameFieldLimit("service", serviceType, username, page);
    }

    @Override
    public Collection<BbsBlog> getByItemType(String username, String itemType, int page) {
        return bbsBlogRepository.fetchByUsernameFieldLimit("item", itemType, username, page);
    }

    @Override
    public Collection<BbsBlog> getByDocType(String username, String docType, int page) {
        return bbsBlogRepository.fetchByUsernameFieldLimit("doc", docType, username, page);
    }

    @Override
    public Collection<BbsBlog> getByStatus(String username, String status, int page) {
        return bbsBlogRepository.fetchByUsernameFieldLimit("status", status, username, page);
    }
}
