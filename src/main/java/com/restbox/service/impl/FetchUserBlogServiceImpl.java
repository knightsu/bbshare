package com.restbox.service.impl;

import com.restbox.model.BbsBlog;
import com.restbox.service.api.FetchUserBlogService;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class FetchUserBlogServiceImpl implements FetchUserBlogService {
    @Override
    public Collection<BbsBlog> getAllBlogs(String username, int page) {
        return null;
    }

    @Override
    public Collection<BbsBlog> getByCategory(String username, String category, int page) {
        return null;
    }

    @Override
    public Collection<BbsBlog> getByServiceType(String username, String serviceType, int page) {
        return null;
    }

    @Override
    public Collection<BbsBlog> getByItemType(String username, String itemType, int page) {
        return null;
    }

    @Override
    public Collection<BbsBlog> getByDocType(String username, String docType, int page) {
        return null;
    }

    @Override
    public Collection<BbsBlog> getByStatus(String username, String status) {
        return null;
    }
}
