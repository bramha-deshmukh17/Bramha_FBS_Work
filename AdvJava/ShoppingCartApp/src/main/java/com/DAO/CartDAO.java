package com.DAO;

import com.bean.CartItem;
import java.util.List;

public interface CartDAO {
    boolean addCartItem(CartItem cartItem);

    boolean updateCartItem(CartItem cartItem);

    boolean removeCartItem(int id);

    List<CartItem> getCartItemsByUserId(int userId);

    void clearCartByUserId(int userId);
}