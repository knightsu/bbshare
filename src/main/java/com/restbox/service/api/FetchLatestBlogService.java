package com.restbox.service.api;

import com.restbox.model.BbsBlog;
import com.restbox.model.Comment;

import java.util.Collection;

public interface FetchLatestBlogService {

    Collection<BbsBlog> getPageBlogs(String username, int page);
    Collection<BbsBlog> getAllBlogs(int page);
    Collection<BbsBlog> getByCategory(String category, int page);
    Collection<BbsBlog> getByTitleCategory(String category, String title, int page);
    Collection<BbsBlog> getByServiceType(String serviceType, int page);
    Collection<BbsBlog> getByItemType(String itemType, int page);
    Collection<Comment> getBlogDetails(long blogId, int page);

}
