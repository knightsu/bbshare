package com.restbox.service.impl;

import com.restbox.Constant.Constant;
import com.restbox.model.BbsUser;
import com.restbox.mongorepo.BbsUserRepository;
import com.restbox.service.api.FetchUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

public class FetchUserServiceImpl implements FetchUserService {
    @Autowired
    BbsUserRepository bbsUserRepository;

    @Override
    public BbsUser getUser(String username) {
        return bbsUserRepository.findBbsUserByUsername(username);
    }

    @Override
    public BbsUser addPoint(BbsUser bbsUser) {
        bbsUser.setCoins(bbsUser.getCoins()+ Constant.DAILY_CHECKIN);
        bbsUserRepository.save(bbsUser);
        return bbsUser;
    }
}
