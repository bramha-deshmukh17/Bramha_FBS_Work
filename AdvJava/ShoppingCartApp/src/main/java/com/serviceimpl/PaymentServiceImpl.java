package com.serviceimpl;

import com.aspect.ObjectCreater;
import com.services.PaymentService;
import com.DAO.PaymentDAO;
import com.bean.Payment;
import java.util.List;

public class PaymentServiceImpl implements PaymentService {
    private final PaymentDAO paymentDAO = ObjectCreater.createObject("paymentDAO", PaymentDAO.class);

    @Override
    public boolean addPayment(Payment payment) {
        return paymentDAO.addPayment(payment);
    }

    @Override
    public Payment getPaymentByOrderId(int orderId) {
        return paymentDAO.getPaymentByOrderId(orderId);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentDAO.getAllPayments();
    }
}