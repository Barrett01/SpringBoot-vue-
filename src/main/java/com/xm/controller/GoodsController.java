package com.xm.controller;

import com.xm.api.BaseResponse;
import com.xm.api.StatusCode;
import com.xm.entity.Goods;
import com.xm.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping
    public BaseResponse selectGoodsAll() {
        List<Goods> goodsList = this.goodsService.selectGoodsAll();
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        retMsg.setData(goodsList);
        return retMsg;
    }

    @GetMapping("{id}")
    public BaseResponse selectGoodsById(@PathVariable String id) {
        Goods goods = this.goodsService.selectGoodsById(id);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        retMsg.setData(goods);
        return retMsg;
    }

    @PostMapping
    public BaseResponse insertGoods(@RequestBody Goods goods) {
        this.goodsService.insertGoods(goods);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        return retMsg;
    }

    @PutMapping
    public BaseResponse updateGoods(@RequestBody Goods goods) {
        this.goodsService.updateGoods(goods);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        return retMsg;
    }

    @DeleteMapping("{id}")
    public BaseResponse deleteGoods(@PathVariable String id) {
        this.goodsService.deleteGoods(id);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        return retMsg;
    }


}
