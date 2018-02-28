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
import java.util.Map;

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
    FetchTotalAmountBlogService fetchTotalAmountBlogService;

    @Autowired
    FetchBlogService fetchBlogService;

    @Autowired
    UpdateBlogService updateBlogService;

    @RequestMapping(value = "/create/{username}", method = RequestMethod.POST)
    public ResponseEntity<Collection<BbsBlog>> createUserBlog(@RequestBody ObjectNode blogData,
                                                              @PathVariable String  username, @RequestHeader HttpHeaders httpHeaders)
    {
        BbsBlog bbsBlog = constructBlogService.constructBlog(blogData);
        Collection<BbsBlog> result = createBlogService.postBlog(bbsBlog, username);
        String total = httpHeaders.getFirst("Total");
        httpHeaders.set("Total", Long.toString(Long.parseLong(total) + 1));
        ResponseEntity<Collection<BbsBlog>> responseEntity = new ResponseEntity<Collection<BbsBlog>>(result, httpHeaders, HttpStatus.CREATED);
        return responseEntity;
    }

    @RequestMapping(value = "/list/{username}", method = RequestMethod.GET)
    public ResponseEntity<Collection<BbsBlog>> getUserBlogsAll(@PathVariable String username, @RequestParam Map<String, String> map,
                                                               @RequestHeader HttpHeaders httpHeaders)
    {
        int page = Integer.parseInt(map.get("page"));
        map.remove("page");
        Collection<BbsBlog> res = fetchBlogService.getWithUsername(map, username, page);
        if(page==1)
        {
            long tot = fetchTotalAmountBlogService.fetchTotalAmountBlogByUsername(username);
            httpHeaders.set("Total", Long.toString(tot));
        }

        ResponseEntity<Collection<BbsBlog>> responseEntity = new ResponseEntity<Collection<BbsBlog>>(res, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<Collection<BbsBlog>> getUserBlogsAll(@RequestParam Map<String, String> map,
                                                               @RequestHeader HttpHeaders httpHeaders)
    {
        int page = Integer.parseInt(map.get("page"));
        map.remove("page");
        Collection<BbsBlog> res = fetchBlogService.getWOUsername(map, page);
        if(page==1)
        {
            long tot = fetchTotalAmountBlogService.fetchTotalAmountBlog();
            httpHeaders.set("Total", Long.toString(tot));
        }
        ResponseEntity<Collection<BbsBlog>> responseEntity = new ResponseEntity<Collection<BbsBlog>>(res, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/update/{username}/{blogId}", method = RequestMethod.PUT)
    public void updateBlog(@RequestParam Map<String, String> map, @PathVariable String username, @PathVariable long blogId) throws Exception
    {
        updateBlogService.updateBlogStatus(map, username, blogId);
    }

    @RequestMapping(value = "/delete/{blogId}", method = RequestMethod.DELETE)
    public void deleteBlog(@PathVariable long blogId)
    {
        deleteBlogService.deleteBlogbyBlogId(blogId);
    }

}
