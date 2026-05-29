package com.serviceimpl;

import com.aspect.ObjectCreater;
import com.services.OrderService;
import com.DAO.OrderDAO;
import com.bean.Order;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private final OrderDAO orderDAO = ObjectCreater.createObject("orderDAO", OrderDAO.class);

    @Override
    public boolean placeOrder(Order order) {
        return orderDAO.placeOrder(order);
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        return orderDAO.getOrdersByUserId(userId);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    @Override
    public boolean updateOrderStatus(int orderId, String status) {
        return orderDAO.updateOrderStatus(orderId, status);
    }

    @Override
    public boolean updateOrder(Order order) {
        return orderDAO.updateOrder(order);
    }

    @Override
    public Order getOrderById(int orderId) {
        return orderDAO.getOrderById(orderId);
    }
}