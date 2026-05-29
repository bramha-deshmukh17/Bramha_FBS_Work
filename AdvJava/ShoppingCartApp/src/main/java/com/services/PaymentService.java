package com.services;

import com.bean.Payment;
import java.util.List;

public interface PaymentService {
    boolean addPayment(Payment payment);

    Payment getPaymentByOrderId(int orderId);

    List<Payment> getAllPayments();
}