package com.xm.mapper;

import com.xm.entity.Goods;

import java.util.List;

public interface GoodsMapper {
    public List<Goods> selectGoodsAll();

    public Goods selectGoodsById(String id);

    public void insertGoods(Goods goods);

    public void updateGoods(Goods goods);

    public void deleteGoods(String id);


}