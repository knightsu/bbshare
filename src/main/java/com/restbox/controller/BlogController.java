package com.restbox.controller;


import com.fasterxml.jackson.databind.node.ObjectNode;
import com.restbox.model.BbsBlog;
import com.restbox.service.api.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/blog")
public class BlogController {

    @Autowired
    ConstructBlogService constructBlogService;

    @Autowired
    CreateBlogService createBlogService;

    @Autowired
    DeleteBlogService deleteBlogService;

    @Autowired
    FetchOtherBlogService fetchOtherBlogService;

    @Autowired
    FetchTotalAmountBlogService fetchTotalAmountBlogService;

    @Autowired
    FetchUserBlogService fetchUserBlogService;

    @Autowired
    UpdateStatusService updateStatusService;

    @RequestMapping(value = "/{username}/create", method = RequestMethod.POST)
    public ResponseEntity<Collection<BbsBlog>> createUserBlog(@RequestBody ObjectNode blogData, @PathVariable String  username, @RequestHeader HttpHeaders httpHeaders)
    {
        BbsBlog bbsBlog = constructBlogService.constructBlog(blogData);
        Collection<BbsBlog> result = createBlogService.postBlog(bbsBlog, username);
        String total = httpHeaders.getFirst("Total");
        httpHeaders.set("Total", Long.toString(Long.parseLong(total) + 1));
        ResponseEntity<Collection<BbsBlog>> responseEntity = new ResponseEntity<Collection<BbsBlog>>(result, httpHeaders, HttpStatus.CREATED);
        return responseEntity;
    }

    @RequestMapping(value = "/all/{username}", method = RequestMethod.GET)
    public ResponseEntity<Collection<BbsBlog>> getUserBlogsAll(@PathVariable String username, @RequestParam(value = "page", required = true) int page, @RequestHeader HttpHeaders httpHeaders)
    {
        Collection<BbsBlog> res = fetchUserBlogService.getAllBlogs(username, page);
        if(page==1)
        {
            long tot = fetchTotalAmountBlogService.fetchTotalAmountBlogByUsername(username);
            httpHeaders.set("Total", Long.toString(tot));
        }

        ResponseEntity<Collection<BbsBlog>> responseEntity = new ResponseEntity<Collection<BbsBlog>>(res, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }



}
