package com.restbox.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testCon()
    {
        return "test";
    }


}
