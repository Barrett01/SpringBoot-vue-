package com.xm.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Cart {
    //用户名
    private String userid;
    //商品编码
    private String goodsid;
    //数量
    private Integer num;
    //商品详情
    private Goods goods;

    //用户名
    private User username;
}