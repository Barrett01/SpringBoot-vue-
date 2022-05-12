package com.xm.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Goods {

    //商品编码
    private String id;
    //*商品名称
    private String name;
    //缩略图
    private String thumbnail;
    //商品描述
    private String content;
    //价格
    private Float price;
    //商品描述
    private Integer flag;
  //文章的子表
//    private Article article;
}