package com.xm.controller;

import java.util.List;

import com.xm.api.BaseResponse;
import com.xm.api.StatusCode;
import com.xm.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import com.xm.service.ArticleService;

@CrossOrigin
@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    //根据id查询文章详情
    @GetMapping("/article/{id}")
    public BaseResponse selectArticleById(@PathVariable("id") Integer id) {
        Article article = articleService.selectArticleById(id);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        retMsg.setData(article);
        return retMsg;
    }

    //根据id查询文章,药品详情
    @GetMapping("/articleGoods/{id}")
    public BaseResponse selectArticleGoodsById(@PathVariable("id") Integer id) {
        Article article = articleService.selectArticleGoodsById(id);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        retMsg.setData(article);
        return retMsg;
    }
    //按发表日期查询文章列表
    @GetMapping("/articles")
    public BaseResponse selectArticlesOrderByDate() {
        List<Article> articles = articleService.selectArticlesOrderByDate();
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        retMsg.setData(articles);
        return retMsg;
    }

    //按热度查询文章列表
    @GetMapping("/top")
    public BaseResponse selectArticlesOrderByHits() {
        List<Article> articles = articleService.selectArticlesOrderByHits();
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        retMsg.setData(articles);
        return retMsg;
    }

    //查询全部文章列表和所有评论
    @GetMapping("/comments")
    public BaseResponse selectTitlesWithComment() {
        List<Article> articles = articleService.selectTitlesWithComment();
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        retMsg.setData(articles);
        return retMsg;
    }

    //发布文章
    @PostMapping("/article")
    public BaseResponse insertArticle(@RequestBody Article article) {
        articleService.insertArticle(article);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        return retMsg;
    }

    //修改文章
    @PutMapping("/article")
    public BaseResponse updateArticle(@RequestBody Article article) {
        articleService.updateArticle(article);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        return retMsg;
    }

    //删除文章
    @DeleteMapping("/article/{id}")
    public BaseResponse deleteArticleById(@PathVariable("id") Integer id) {
        articleService.deleteArticleById(id);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        return retMsg;
    }

}
