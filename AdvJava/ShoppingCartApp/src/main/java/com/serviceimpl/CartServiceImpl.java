package com.serviceimpl;

import com.aspect.ObjectCreater;
import com.services.CartService;
import com.DAO.CartDAO;
import com.bean.CartItem;
import java.util.List;

public class CartServiceImpl implements CartService {
    private final CartDAO cartDAO = ObjectCreater.createObject("cartDAO", CartDAO.class);

    @Override
    public boolean addCartItem(CartItem cartItem) {
        return cartDAO.addCartItem(cartItem);
    }

    @Override
    public boolean updateCartItem(CartItem cartItem) {
        return cartDAO.updateCartItem(cartItem);
    }

    @Override
    public boolean removeCartItem(int id) {
        return cartDAO.removeCartItem(id);
    }

    @Override
    public List<CartItem> getCartItemsByUserId(int userId) {
        return cartDAO.getCartItemsByUserId(userId);
    }

    @Override
    public void clearCartByUserId(int userId) {
        cartDAO.clearCartByUserId(userId);
    }
}