package com.restbox.service.impl;

import com.restbox.datatype.Status;
import com.restbox.jparepository.BbsBlogRepository;
import com.restbox.model.BbsBlog;
import com.restbox.service.api.UpdateStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateStatusServiceImpl implements UpdateStatusService {
    @Autowired
    BbsBlogRepository bbsBlogRepository;

    @Override
    public void updateBlogStatus(Status status, long blogId) {
        bbsBlogRepository.updateStatus(status.getStatus(), blogId);
    }
}
