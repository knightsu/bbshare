package com.restbox.service.impl;

import com.restbox.jparepository.BbsBlogRepository;
import com.restbox.model.BbsBlog;
import com.restbox.service.api.FetchUserBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collection;
import java.util.Map;


@Service
public class FetchUserBlogServiceImpl implements FetchUserBlogService {
    @Autowired
    BbsBlogRepository bbsBlogRepository;

    @Override
    public Collection<BbsBlog> getAllBlogs(String username, int page) {
        return bbsBlogRepository.fetchByUsernameFieldLimit(username, page);
    }

    @Override
    public Collection<BbsBlog> getByFieldname(Map<String, String> map, String username) {
        //check if map has page keyword
        int page = 1;
        if(map.containsKey("page"))
        {
            page = Integer.parseInt(map.get("page"));
            map.remove("page");
        }

        return bbsBlogRepository.fetchByUsernameFieldLimit(map, username, page);
    }
}
