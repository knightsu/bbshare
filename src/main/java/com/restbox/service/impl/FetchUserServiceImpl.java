package com.restbox.service.impl;

import com.restbox.Constant.Constant;
import com.restbox.error.Error;
import com.restbox.error.UsernameNotCorrectException;
import com.restbox.model.BbsUser;
import com.restbox.mongorepo.BbsUserRepository;
import com.restbox.service.api.FetchUserService;
import com.restbox.util.CalUtil;
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
        BbsUser bbsUser = bbsUserRepository.findBbsUserByUsername(username);
        if(bbsUser==null) throw new UsernameNotCorrectException();
        return addPoint(bbsUser);
    }

    @Override
    public long getCoins(String username) {
        BbsUser bbsUser = bbsUserRepository.findBbsUserByUsername(username);
        if(bbsUser==null) throw new UsernameNotCorrectException();
        return bbsUser.getCoins();
    }

    private BbsUser addPoint(BbsUser bbsUser) {
        if(!CalUtil.compareTwoDate(bbsUser.getLastLogin()))
        {
            Date date = new Date();
            bbsUser.setLastLogin(date);
            bbsUser.setCoins(bbsUser.getCoins()+Constant.DAILY_CHECKIN);
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
