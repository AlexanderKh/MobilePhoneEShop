package ksk.dao;

import ksk.entity.Purchase;

import java.util.List;

public interface PurchaseDAO {
    void save(Purchase purchase);

    List<Purchase> getByCustomerID(Integer customerID);

    Purchase getByID(Integer purchaseID);

    void deleteByID(Integer id);
}
