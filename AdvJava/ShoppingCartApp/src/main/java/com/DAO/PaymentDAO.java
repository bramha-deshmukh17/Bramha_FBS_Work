package com.DAO;

import com.bean.Payment;
import java.util.List;

public interface PaymentDAO {
    boolean addPayment(Payment payment);

    Payment getPaymentByOrderId(int orderId);

    List<Payment> getAllPayments();
}