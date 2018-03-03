package com.restbox.controller;


import com.fasterxml.jackson.databind.node.ObjectNode;
import com.restbox.model.BbsUser;
import com.restbox.service.api.ConstructUserService;
import com.restbox.service.api.CreateNewUserService;
import com.restbox.service.api.FetchUserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user/")
public class UserController {

    @Autowired
    ConstructUserService constructUserService;

    @Autowired
    CreateNewUserService createNewUserService;

    @Autowired
    FetchUserService fetchUserService;

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody BbsUser registerUser(@RequestBody ObjectNode userData)
    {
        System.out.println(userData.toString());
        BbsUser bbsUser = constructUserService.constructUser(userData);
        return createNewUserService.createUser(bbsUser);
    }

    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    public BbsUser getUser(@RequestParam String username)
    {
        System.out.println(username);
        return fetchUserService.getUser(username);
    }
}
