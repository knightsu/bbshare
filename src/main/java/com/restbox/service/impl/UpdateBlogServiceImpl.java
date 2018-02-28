package com.restbox.service.impl;

import com.restbox.datatype.Status;
import com.restbox.jparepository.BbsBlogRepository;
import com.restbox.model.BbsBlog;
import com.restbox.service.api.UpdateBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public class UpdateBlogServiceImpl implements UpdateBlogService {
    @Autowired
    BbsBlogRepository bbsBlogRepository;

    @Override
    public void updateBlogStatus(Map<String, String> map, String username, long id) throws Exception{
        BbsBlog result = bbsBlogRepository.findBbsBlogByIdAndUsername(id, username);
        if(result==null) throw new Exception();
        int r = bbsBlogRepository.updateByFieldMap(map, username, id);
        if(r!=1) throw new Exception();

    }
}
