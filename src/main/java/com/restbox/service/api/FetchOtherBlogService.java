package com.restbox.service.api;

import com.restbox.model.BbsBlog;

import java.util.Collection;

public interface FetchOtherBlogService {

    Collection<BbsBlog> getAllBlogs(int page);
    Collection<BbsBlog> getByCategory(String category, int page);
    Collection<BbsBlog> getByServiceType(String serviceType, int page);
    Collection<BbsBlog> getByItemType(String itemType, int page);
    Collection<BbsBlog> getByDocType(String docType, int page);
    Collection<BbsBlog> getByStatus(String status);

}
