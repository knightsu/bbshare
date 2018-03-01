package com.restbox.service.impl;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.restbox.model.BbsBlog;
import com.restbox.model.BbsUser;
import com.restbox.service.api.ConstructUserService;
import com.restbox.util.JTOUtil;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ConstructUserServiceImpl implements ConstructUserService {
    @Override
    public BbsUser constructUser(ObjectNode userData) {
        BbsUser bbsUser =  JTOUtil.converttoUser(userData);
        bbsUser.setCoins(450L);
        Date date = new Date();
        bbsUser.setRegisterDate(new java.sql.Date(date.getTime()));
        return bbsUser;
    }
}
