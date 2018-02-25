package com.restbox.service.impl;

import com.restbox.datatype.Status;
import com.restbox.jparepository.BbsBlogRepository;
import com.restbox.model.BbsBlog;
import com.restbox.service.api.UpdateStatusService;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateStatusServiceImpl implements UpdateStatusService {
    @Autowired
    BbsBlogRepository bbsBlogRepository;

    @Override
    public void updateBlogStatus(Status status, long blogId) {
        BbsBlog bbsBlog = bbsBlogRepository.findBbsBlogById(blogId);
        if(status==Status.IDLE)
        {
            bbsBlog.setStatus(status.getStatus());
        }
        else if(status==Status.OCCUPY)
        {
            bbsBlog.setStatus(status.getStatus());
        }
        else
        {
            bbsBlog.setStatus(status.getStatus());
        }
        bbsBlogRepository.save(bbsBlog);
    }
}
