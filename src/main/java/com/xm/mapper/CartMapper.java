package com.xm.mapper;

import com.xm.entity.Cart;
import com.xm.entity.CartKey;

import java.util.List;

public interface CartMapper {
    public List<Cart> selectCartByUserId(String userid);

    public void insertCart(Cart cart);

    public void deleteCart(Cart cart);

    public Cart selectCartByCart(Cart cart);

    public void updateCart(Cart cart);


}