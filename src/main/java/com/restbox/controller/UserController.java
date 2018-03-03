package com.restbox.controller;


import com.fasterxml.jackson.databind.node.ObjectNode;
import com.restbox.error.Error;
import com.restbox.error.NotEnoughBalanceException;
import com.restbox.error.OpNotAllowException;
import com.restbox.model.BbsUser;
import com.restbox.service.api.ConstructUserService;
import com.restbox.service.api.CreateNewUserService;
import com.restbox.service.api.FetchUserService;
import com.restbox.service.api.UserUpdateService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/user/")
public class UserController {

    @Autowired
    ConstructUserService constructUserService;

    @Autowired
    CreateNewUserService createNewUserService;

    @Autowired
    FetchUserService fetchUserService;

    @Autowired
    UserUpdateService userUpdateService;

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody BbsUser registerUser(@RequestBody ObjectNode userData)
    {
        System.out.println(userData.toString());
        BbsUser bbsUser = constructUserService.constructUser(userData);
        return createNewUserService.createUser(bbsUser);
    }

    @RequestMapping(value = "/getuser/{username}", method = RequestMethod.GET)
    public BbsUser getUser(@PathVariable String username)
    {
        System.out.println(username);
        return fetchUserService.getUser(username);
    }

    @RequestMapping(value = "/update/{username}", method = RequestMethod.PUT)
    public BbsUser updateProfile(@RequestParam Map<String, String> map, @PathVariable String username)
    {
        return userUpdateService.updateProfile(map, username);
    }

    @RequestMapping(value = "/getcoins/{username}", method = RequestMethod.GET)
    public long getCoins(@PathVariable String username)
    {
        return fetchUserService.getCoins(username);
    }

    @RequestMapping(value = "/update/coins/{username}", method = RequestMethod.PUT)
    public BbsUser updateCoins(@RequestParam(value = "coin") long coin, @RequestParam(value = "op") String op, @PathVariable String username)
    {
        BbsUser bbsUser = fetchUserService.getUser(username);
        if(!op.equals("-")&&!op.equals("+")) throw new OpNotAllowException();
        if(op.equals("-") && bbsUser.getCoins()-coin<0) throw new NotEnoughBalanceException();
        long coins = op.equals("+")? coin : -coin;
        coins = coins+bbsUser.getCoins();
        userUpdateService.updateCoins(username, coins);
        bbsUser.setCoins(coins);
        return bbsUser;
    }


    @ExceptionHandler(OpNotAllowException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error opnotAllow()
    {
        return new Error(4, "operator is wrong");
    }
}
