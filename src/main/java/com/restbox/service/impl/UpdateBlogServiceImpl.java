package com.restbox.service.impl;

import com.restbox.datatype.Status;
import com.restbox.error.BlogNotFoundException;
import com.restbox.error.Error;
import com.restbox.error.IllegalUpdateFieldException;
import com.restbox.error.UpdateFailException;
import com.restbox.jparepository.BbsBlogRepository;
import com.restbox.model.BbsBlog;
import com.restbox.service.api.UpdateBlogService;
import com.restbox.util.CheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collection;
import java.util.Map;

@Service
public class UpdateBlogServiceImpl implements UpdateBlogService {
    @Autowired
    BbsBlogRepository bbsBlogRepository;

    @Override
    public void updateBlogStatus(Map<String, String> map, String username, long id) throws Exception{
        if(!CheckUtil.checkUpdate(map)) throw new IllegalUpdateFieldException();
        BbsBlog result = bbsBlogRepository.findBbsBlogByIdAndUsername(id, username);
        if(result==null) throw new BlogNotFoundException();
        int r = bbsBlogRepository.updateByFieldMap(map, username, id);
        if(r!=1) throw new UpdateFailException();

    }


    @ExceptionHandler(BlogNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error blogNotFound(BlogNotFoundException e)
    {
        return new Error(4, "there is no blog for your search pattern");
    }

    @ExceptionHandler(BlogNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error updateFieldIllegal(IllegalUpdateFieldException e)
    {
        return new Error(4, "some field not allowed to update");
    }

    @ExceptionHandler(BlogNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error updateFail(UpdateFailException e)
    {
        return new Error(4, "update not successful other record get affected");
    }

}
