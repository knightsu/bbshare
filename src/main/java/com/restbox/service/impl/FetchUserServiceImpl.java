package com.restbox.service.impl;

import com.restbox.Constant.Constant;
import com.restbox.error.Error;
import com.restbox.error.UsernameNotCorrectException;
import com.restbox.model.BbsUser;
import com.restbox.mongorepo.BbsUserRepository;
import com.restbox.service.api.FetchUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;
import java.util.List;

@Service
public class FetchUserServiceImpl implements FetchUserService {
    @Autowired
    BbsUserRepository bbsUserRepository;

    @Override
    public BbsUser getUser(String username) {
        List<BbsUser> bbsUsers = bbsUserRepository.findBbsUserByUsername(username);
        if(bbsUsers.size()!=1) throw new UsernameNotCorrectException();
        return addPoint(bbsUsers.get(0));
    }

    @Override
    public long getCoins(String username) {
        List<BbsUser> bbsUsers = bbsUserRepository.findBbsUserByUsername(username);
        if(bbsUsers.size()!=1) throw new UsernameNotCorrectException();
        return bbsUsers.get(0).getCoins();
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

    @ExceptionHandler(UsernameNotCorrectException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error usernameWrong()
    {
        return new Error(4, "username wrong");
    }
}
