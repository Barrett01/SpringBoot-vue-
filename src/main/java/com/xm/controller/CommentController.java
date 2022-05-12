package com.xm.controller;

import com.xm.api.BaseResponse;
import com.xm.api.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import com.xm.entity.Comment;
import com.xm.service.CommentService;

@CrossOrigin
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    //发布评论
    @PostMapping("/comment")
    public BaseResponse insertComment(@RequestBody Comment comment) {
        commentService.insertComment(comment);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        return retMsg;

    }

    //删除评论
    @DeleteMapping("/comment/{id}")
    public BaseResponse deleteCommentById(@PathVariable("id") Integer id) {
        commentService.deleteCommentById(id);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        return retMsg;
    }

    //通过文章id删除该文章下所有评论
    @DeleteMapping("/comments/{id}")
    public BaseResponse deleteCommentByArticleId(@PathVariable("id") Integer id) {
        commentService.deleteCommentByArticleId(id);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        return retMsg;
    }
}
