package ksk.service;

import ksk.entity.Order;
import ksk.entity.Product;
import ksk.entity.Customer;
import ksk.entity.Purchase;

import java.util.List;

public interface ShopService {
    List<Product> getProducts();

    List<Customer> getCustomers();

    Product getProductByID(Integer productID);

    void addProduct(Product product);

    void removeProductByID(Integer productID);


    Customer getCustomerByID(Integer customerID);

    void addCustomer(Customer customer);

    void removeCustomerByID(Integer customerID);

    List<Purchase> getPurchasesByCustomerID(Integer customerID);

    Integer checkAndRemoveUnresolvedPurchase(List<Purchase> purchases);

    Integer addPurchaseByCustomerID(Integer customerID);

    Purchase getPurchaseByID(Integer purchaseID);

    List<Order> getOrdersByPurchaseID(Integer purchaseID);

    List<Product> getPossibleProductsByPurchaseID(Integer purchaseID);

    void addNewProductToPurchase(Integer purchaseID, Integer productID);

    void commitPurchaseByID(Integer purchaseID);

    void clearPurchaseByID(Integer purchaseID);
}
