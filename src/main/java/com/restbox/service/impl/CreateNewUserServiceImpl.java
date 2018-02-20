package com.restbox.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restbox.model.BbsUser;
import com.restbox.service.api.CreateNewUserService;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.IOException;

public class CreateNewUserServiceImpl implements CreateNewUserService {

    @Autowired
    private MongoRepository mongoRepository;
    @Autowired
    private ObjectMapper objectMapper;

    private BbsUser bbsUser;
    @Override
    public BbsUser createUser(BbsUser userData) {
        mongoRepository.save(userData);
        return bbsUser;
    }
}
