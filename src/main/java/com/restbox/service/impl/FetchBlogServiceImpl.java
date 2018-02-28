package com.restbox.service.impl;

import com.restbox.jparepository.BbsBlogRepository;
import com.restbox.model.BbsBlog;
import com.restbox.service.api.FetchBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;


@Service
public class FetchBlogServiceImpl implements FetchBlogService {
    @Autowired
    BbsBlogRepository bbsBlogRepository;

    @Override
    public Collection<BbsBlog> getWOUsername(Map<String, String> map, int page) {
        if(map.size()==0)
        {
            return bbsBlogRepository.fetchByFieldLimit(page);
        } else {
            return bbsBlogRepository.fetchByFieldLimit(map, page);
        }
    }

    @Override
    public Collection<BbsBlog> getWithUsername(Map<String, String> map, String username, int page) {
        if(map.size()==0)
        {
            return bbsBlogRepository.fetchByUsernameFieldLimit(username, page);
        } else {
            return bbsBlogRepository.fetchByUsernameFieldLimit(map, username, page);
        }
    }
}
