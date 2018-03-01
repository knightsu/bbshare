package com.restbox.service.impl;

import com.restbox.Constant.Constant;
import com.restbox.model.BbsUser;
import com.restbox.mongorepo.BbsUserRepository;
import com.restbox.service.api.FetchUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FetchUserServiceImpl implements FetchUserService {
    @Autowired
    BbsUserRepository bbsUserRepository;

    @Override
    public BbsUser getUser(String username) {
        BbsUser bbsUser =  bbsUserRepository.findBbsUserByUsername(username);
        return addPoint(bbsUser);
    }


    private BbsUser addPoint(BbsUser bbsUser) {
        Date date = new Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        if(!bbsUser.getRegisterDate().toString().equals(sqldate.toString())) {
            bbsUser.setCoins(bbsUser.getCoins() + Constant.DAILY_CHECKIN);
            bbsUser.setRegisterDate(sqldate);
            bbsUserRepository.save(bbsUser);
        }
        return bbsUser;
    }
}
