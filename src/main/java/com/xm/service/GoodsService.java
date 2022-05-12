package com.xm.service;

import com.xm.entity.Goods;
import com.xm.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    public List<Goods> selectGoodsAll() {
        List<Goods> goodsList = this.goodsMapper.selectGoodsAll();
        return goodsList;
    }

    public Goods selectGoodsById(String id) {
        return this.goodsMapper.selectGoodsById(id);
    }

    public void insertGoods(Goods goods) {
        this.goodsMapper.insertGoods(goods);
    }

    public void updateGoods(Goods goods) {
        this.goodsMapper.updateGoods(goods);
    }

    public void deleteGoods(String id) {
        this.goodsMapper.deleteGoods(id);
    }
}
