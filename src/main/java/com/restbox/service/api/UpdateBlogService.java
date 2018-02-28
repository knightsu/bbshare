package com.restbox.service.api;

import com.restbox.datatype.Status;
import com.restbox.model.BbsBlog;

import java.util.Collection;
import java.util.Map;

public interface UpdateBlogService {
    void updateBlogStatus(Map<String, String> map, String username, long id) throws Exception;
}
