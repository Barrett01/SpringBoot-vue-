package com.xm.service;

import com.xm.entity.Cart;
import com.xm.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartMapper cartMapper;

    public List<Cart> selectCartByUserId(String userid)
    {
        List<Cart> carts = this.cartMapper.selectCartByUserId(userid);
        return carts;
    }

    public void insertCart(Cart cart){
        Cart cart2 = this.cartMapper.selectCartByCart(cart);
        if (cart2 == null)
        {
            this.cartMapper.insertCart(cart);
        }else{
            cart.setNum(cart.getNum()+cart2.getNum());
            this.cartMapper.updateCart(cart);
        }
    }

    public void deleteCart(Cart cart)
    {
        this.cartMapper.deleteCart(cart);
    }

    public void updateCart(Cart cart)
    {
        this.cartMapper.updateCart(cart);
    }
    
    public Cart selectCartByCart(Cart cart)
    {
        return this.cartMapper.selectCartByCart(cart);
    }
}
