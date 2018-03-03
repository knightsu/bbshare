package com.restbox.service.impl;

import com.restbox.error.Error;
import com.restbox.error.NotEnoughBalanceException;
import com.restbox.model.BbsUser;
import com.restbox.mongorepo.BbsUserRepository;
import com.restbox.service.api.UserUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

public class UserUpdateServiceImpl implements UserUpdateService {

    @Autowired
    BbsUserRepository bbsUserRepository;

    @Override
    public void updateProfile(Map<String, String> map, String username) {
        bbsUserRepository.updateUserProfile(map, username);
    }

    @Override
    public void updateCoins(String username, int coins) {
        BbsUser user = bbsUserRepository.findBbsUserByUsername(username);
        long coin = user.getCoins();
        coin = coin+coins;
        if(coin<0) throw new NotEnoughBalanceException();
        bbsUserRepository.updateUserCoins(username, coin);
    }

    @ExceptionHandler(NotEnoughBalanceException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error notEnoughBalance()
    {
        return new Error(4, "sorry, not engough balance");
    }
}
