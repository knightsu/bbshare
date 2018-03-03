package com.restbox.controller;


import com.restbox.service.api.CreateCommentService;
import com.restbox.service.api.DeleteCommentService;
import com.restbox.service.api.FetchBlogCommentService;
import com.restbox.service.api.FetchTotalAmountCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {
    @Autowired
    CreateCommentService createCommentService;

    @Autowired
    DeleteCommentService deleteCommentService;

    @Autowired
    FetchBlogCommentService fetchBlogCommentService;

    @Autowired
    FetchTotalAmountCommentService fetchTotalAmountCommentService;


}
