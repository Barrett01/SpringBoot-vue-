package com.xm.mapper;

import com.xm.entity.Article;

import java.util.List;

public interface ArticleMapper {
    //根据id查询文章详情
    public Article selectArticleById(Integer id);

    //根据id查询文章（包括商品）详情
    public Article selectArticleGoodsById(Integer id);

    //查询全部文章列表
    public List<Article> selectArticlesOrderByDate();

    //查询全部文章列表
    public List<Article> selectArticlesOrderByHits();

    //查询全部文章列表和所有评论
    public List<Article> selectTitlesWithComment();

    //发布文章
    public void insertArticle(Article article);

    //根据id修改文章
    public void updateArticle(Article article);

    //根据id删除文章
    public void deleteArticleById(Integer id);

    //根据id增加点击量
    public void updateArticleHitsById(Integer id);

    //根据id增加评论量
    public void updateArticleCommentsById(Integer id);

   //根据文章的id查询文章商品以及评论
//    public List<Article> getGoods(String id);

}