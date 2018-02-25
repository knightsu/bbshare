package com.restbox.service.impl;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.restbox.model.BbsUser;
import com.restbox.service.api.ConstructUserService;
import com.restbox.util.JTOUtil;

public class ConstructUserServiceImpl implements ConstructUserService {
    @Override
    public BbsUser constructUser(ObjectNode userData) {
        return JTOUtil.converttoUser(userData);
    }
}
