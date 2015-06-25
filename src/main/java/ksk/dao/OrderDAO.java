package ksk.dao;

import ksk.entity.Order;

import java.util.List;

public interface OrderDAO {
    List<Order> getByPurchaseID(Integer purchaseID);
}
