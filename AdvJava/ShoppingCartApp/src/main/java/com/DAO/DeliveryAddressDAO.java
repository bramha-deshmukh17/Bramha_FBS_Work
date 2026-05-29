package com.DAO;

import com.bean.DeliveryAddress;
import java.util.List;

public interface DeliveryAddressDAO {
    boolean addDeliveryAddress(DeliveryAddress address);
    DeliveryAddress getDeliveryAddressById(int id);
    List<DeliveryAddress> getDeliveryAddressesByUserId(int userId);
    DeliveryAddress getDefaultDeliveryAddress(int userId);
    boolean updateDeliveryAddress(DeliveryAddress address);
    boolean deleteDeliveryAddress(int id);
}
