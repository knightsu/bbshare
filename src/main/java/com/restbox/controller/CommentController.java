package com.restbox.controller;


import com.fasterxml.jackson.databind.node.ObjectNode;
import com.restbox.model.Comment;
import com.restbox.service.api.CreateCommentService;
import com.restbox.service.api.DeleteCommentService;
import com.restbox.service.api.FetchBlogCommentService;
import com.restbox.service.api.FetchTotalAmountCommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

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

    @RequestMapping(value = "/create/{username}/{blogId}", method = RequestMethod.POST)
    public Collection<Comment> createComment(@RequestBody ObjectNode objectNode, @PathVariable String username, @PathVariable long blogId)
    {
        String content = objectNode.get("content").isValueNode()? objectNode.get("content").asText() : "";
        createCommentService.postComment(content, blogId, username);
        return fetchBlogCommentService.getBlogDetails(blogId, 1);
    }
}
