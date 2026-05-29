package com.services;

import com.bean.Order;
import java.util.List;

public interface OrderService {
    boolean placeOrder(Order order);

    List<Order> getOrdersByUserId(int userId);

    List<Order> getAllOrders();

    boolean updateOrderStatus(int orderId, String status);

    boolean updateOrder(Order order);

    Order getOrderById(int orderId);
}
