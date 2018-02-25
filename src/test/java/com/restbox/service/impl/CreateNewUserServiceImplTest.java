package com.restbox.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.restbox.model.BbsUser;
import com.restbox.service.api.ConstructUserService;
import com.restbox.service.api.CreateNewUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

import static org.junit.Assert.*;

public class CreateNewUserServiceImplTest {


    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void createUser() throws Exception {
        CreateNewUserService createNewUserService = new CreateNewUserServiceImpl();
        ConstructUserService constructUserService = new ConstructUserServiceImpl();
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("username", "first");
        objectNode.put("city", "chicago");
        objectNode.put("state", "IL");
        objectNode.put("address", "3422 S Emerald ave");
        objectNode.put("phone", "3125139933");
        objectNode.put("zipcode", "60616");
        objectNode.put("coins", 450L);
        objectNode.put("register", "20170323");
    //    objectNode.put("registerDate", new Timestamp(System.currentTimeMillis()).toString());



        BbsUser bbsUser = createNewUserService.createUser(constructUserService.constructUser(objectNode));
        System.out.println(bbsUser.toString());
        assertNotNull(bbsUser);
    }

}