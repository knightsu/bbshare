package com.restbox.service.impl;

import com.restbox.error.Error;
import com.restbox.error.NotEnoughBalanceException;
import com.restbox.error.UsernameNotCorrectException;
import com.restbox.model.BbsUser;
import com.restbox.mongorepo.BbsUserRepository;
import com.restbox.service.api.FetchUserService;
import com.restbox.service.api.UserUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Map;
@Service
public class UserUpdateServiceImpl implements UserUpdateService {

    @Autowired
    BbsUserRepository bbsUserRepository;

    @Autowired
    FetchUserService fetchUserService;

    @Override
    public BbsUser updateProfile(Map<String, String> map, String username) {
        bbsUserRepository.updateUserProfile(map, username);
        return fetchUserService.getUser(username);
    }

    @Override
    public void updateCoins(String username, long coins) {
        List<BbsUser> users = bbsUserRepository.findBbsUserByUsername(username);
        if(users.size()!=1) throw new UsernameNotCorrectException();
        long coin = users.get(0).getCoins();
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
