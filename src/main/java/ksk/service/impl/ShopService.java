package ksk.service.impl;

import ksk.dao.OrderDAO;
import ksk.dao.ProductDAO;
import ksk.dao.PurchaseDAO;
import ksk.entity.Order;
import ksk.entity.Product;
import ksk.dao.CustomerDAO;
import ksk.entity.Customer;
import ksk.entity.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class ShopService implements ksk.service.ShopService{
    @Autowired
    ProductDAO productDAO;
    @Autowired
    CustomerDAO customerDAO;
    @Autowired
    PurchaseDAO purchaseDAO;
    @Autowired
    OrderDAO orderDAO;

    public List<Product> getProducts() {
        return productDAO.getAll();
    }

    public Product getProductByID(Integer productID) {
        return productDAO.getByID(productID);
    }

    public void addProduct(Product product) {
        productDAO.save(product);
    }

    public void removeProductByID(Integer productID) {
        productDAO.deleteByID(productID);
    }

    public List<Customer> getCustomers() {
        return customerDAO.getAll();
    }

    public Customer getCustomerByID(Integer customerID) {
        return customerDAO.getByID(customerID);
    }

    public void addCustomer(Customer customer) {
        customerDAO.save(customer);
    }

    public void removeCustomerByID(Integer customerID) {
        customerDAO.deleteByID(customerID);
    }

    public List<Purchase> getPurchasesByCustomerID(Integer customerID) {
        return purchaseDAO.getByCustomerID(customerID);
    }

    public Integer checkUnresolvedPurchase(List<Purchase> purchases) {
        if (purchases.isEmpty())
            return null;
        for (Purchase purchase : purchases){
            if (purchase.getDate() == null)
                return purchase.getId();
        }
        return null;
    }

    public void addPurchaseByCustomerID(Integer customerID) {
        purchaseDAO.addByCustomerID(customerID);
    }

    public Purchase getPurchaseByID(Integer purchaseID) {
        return purchaseDAO.getByID(purchaseID);
    }

    public List<Order> getOrdersByPurchaseID(Integer purchaseID) {
        return orderDAO.getByPurchaseID(purchaseID);
    }

}
