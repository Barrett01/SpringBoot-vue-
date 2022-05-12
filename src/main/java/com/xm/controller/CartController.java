package com.xm.controller;

import com.xm.api.BaseResponse;
import com.xm.api.StatusCode;
import com.xm.entity.Cart;
import com.xm.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public BaseResponse selectCartByUserId() {
        String userid = "user1";//下一步以登录的用户名为准
        List<Cart> carts = this.cartService.selectCartByUserId(userid);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        retMsg.setData(carts);
        return retMsg;
    }

    @PostMapping
    public BaseResponse insertCart(@RequestBody Cart cart) {
        cart.setUserid("user1");//下一步以登录的用户名为准
        this.cartService.insertCart(cart);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        return retMsg;
    }

    @DeleteMapping("{goodsid}")
    public BaseResponse deleteCart(@PathVariable String goodsid) {
        Cart cart = new Cart();
        cart.setGoodsid(goodsid);
        cart.setUserid("user1");//下一步以登录的用户名为准
        this.cartService.deleteCart(cart);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        return retMsg;
    }

    @PutMapping
    public BaseResponse updateCart(@RequestBody Cart cart) {
        cart.setUserid("user1");//下一步以登录的用户名为准
        this.cartService.updateCart(cart);
        BaseResponse retMsg = new BaseResponse(StatusCode.Success);
        return retMsg;
    }

}
