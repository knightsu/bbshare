package com.restbox.service.api;

import com.restbox.model.BbsBlog;
import com.restbox.model.Comment;

import java.util.Collection;
import java.util.Date;

public interface FetchUserBlogService {

    Collection<BbsBlog> getAllBlogs(String username, int page);
    Collection<BbsBlog> getByCategory(String username, String category, int page);
    Collection<BbsBlog> getByServiceType(String username, String serviceType, int page);
    Collection<BbsBlog> getByItemType(String username, String itemType, int page);
    Collection<BbsBlog> getByDocType(String username, String docType, int page);
    Collection<BbsBlog> getByStatus(String username, String status, int page);


}
