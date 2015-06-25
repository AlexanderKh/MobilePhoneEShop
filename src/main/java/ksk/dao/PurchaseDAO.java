package ksk.dao;

import ksk.entity.Purchase;

import java.util.List;

public interface PurchaseDAO {
    List<Purchase> getByCustomerID(Integer customerID);

    void addByCustomerID(Integer customerID);

    Purchase getByID(Integer purchaseID);
}
