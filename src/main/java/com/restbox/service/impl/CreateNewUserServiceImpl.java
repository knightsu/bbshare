package com.restbox.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restbox.model.BbsUser;
import com.restbox.mongorepo.BbsUserRepository;
import com.restbox.service.api.CreateNewUserService;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CreateNewUserServiceImpl implements CreateNewUserService {

    @Autowired
    private BbsUserRepository bbsUserRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public BbsUser createUser(BbsUser bbsUser) {
        bbsUserRepository.save(bbsUser);
        return bbsUser;
    }
}
