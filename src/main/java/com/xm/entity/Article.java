package com.xm.entity;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Article {
    //流水号
    private Integer id;
    //商品id
    private String goodsid;
    //标题
    private String title;
    //内容
    private String content;
    //日期
    private String created;
    //缩略图
    private String thumbnail;
    //点击量
    private Integer hits;
    //评论量
    private Integer comments;
    //评论
    private List<Comment> commentList;
    /*
        t_article表中有一个goodsid字段，所以在Article类中定义一个goods属性，
        用于维护goods和article之间的一对一关系，通过这个goods属性就可以知道这个文章对应的什么商品
        */
    private  Goods goods;

}