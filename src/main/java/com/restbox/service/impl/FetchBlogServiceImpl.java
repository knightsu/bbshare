package com.restbox.service.impl;

import com.restbox.error.Error;
import com.restbox.error.IllegalFetchDateException;
import com.restbox.jparepository.BbsBlogRepository;
import com.restbox.model.BbsBlog;
import com.restbox.service.api.FetchBlogService;
import com.restbox.util.CheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

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
            if(!CheckUtil.checkGet(map)) throw new IllegalFetchDateException();
            return bbsBlogRepository.fetchByFieldLimit(map, page);
        }
    }

    @Override
    public Collection<BbsBlog> getWithUsername(Map<String, String> map, String username, int page) {
        if(map.size()==0)
        {
            return bbsBlogRepository.fetchByUsernameFieldLimit(username, page);
        } else {
            if(!CheckUtil.checkGet(map)) throw new IllegalFetchDateException();
            return bbsBlogRepository.fetchByUsernameFieldLimit(map, username, page);
        }
    }


    @ExceptionHandler(IllegalFetchDateException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error inputDataWrong(IllegalFetchDateException e)
    {
        return new Error(4, "some field and value is not allowed");
    }
}
