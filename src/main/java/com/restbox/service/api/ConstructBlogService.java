package com.restbox.service.api;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.restbox.model.BbsBlog;

public interface ConstructBlogService {
    BbsBlog constructBlog(ObjectNode blogData);
}
