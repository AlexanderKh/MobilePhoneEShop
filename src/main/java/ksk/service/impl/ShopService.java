package ksk.service.impl;

import ksk.dao.CustomerDAO;
import ksk.dao.OrderDAO;
import ksk.dao.ProductDAO;
import ksk.dao.PurchaseDAO;
import ksk.entity.Customer;
import ksk.entity.Order;
import ksk.entity.Product;
import ksk.entity.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@Transactional
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
        List<Purchase> purchases = purchaseDAO.getByCustomerID(customerID);
        for (Purchase purchase : purchases){
            orderDAO.deleteByPurchaseID(purchase.getId());
            purchaseDAO.deleteByID(purchase.getId());
        }
        customerDAO.deleteByID(customerID);
    }

    public List<Purchase> getPurchasesByCustomerID(Integer customerID) {
        return purchaseDAO.getByCustomerID(customerID);
    }

    public Integer checkAndRemoveUnresolvedPurchase(List<Purchase> purchases) {
        if (purchases.isEmpty())
            return null;
        for (Purchase purchase : purchases){
            if (purchase.getDate() == null) {
                purchases.remove(purchase);
                return purchase.getId();
            }
        }
        return null;
    }

    public Integer addPurchaseByCustomerID(Integer customerID) {
        Customer customer = customerDAO.getByID(customerID);
        Purchase purchase = new Purchase();
        purchase.setSum(BigDecimal.ZERO);
        purchase.setCustomer(customer);
        purchaseDAO.save(purchase);
        return purchase.getId();
    }

    public Purchase getPurchaseByID(Integer purchaseID) {
        return purchaseDAO.getByID(purchaseID);
    }

    public List<Order> getOrdersByPurchaseID(Integer purchaseID) {
        return orderDAO.getByPurchaseID(purchaseID);
    }

    public List<Product> getPossibleProductsByPurchaseID(Integer purchaseID) {
        return productDAO.getAll();
    }

    public void addNewProductToPurchase(Integer purchaseID, Integer productID) {
        Purchase purchase = purchaseDAO.getByID(purchaseID);
        Product product = productDAO.getByID(productID);
        Order order = new Order();
        order.setPurchase(purchase);
        order.setProduct(product);
        order.setPrice(product.getPrice());
        orderDAO.save(order);
        BigDecimal currentPurchaseSum = purchase.getSum();
        purchase.setSum(currentPurchaseSum.add(order.getPrice()));
    }

    public void commitPurchaseByID(Integer purchaseID) {
        Purchase purchase = purchaseDAO.getByID(purchaseID);
        purchase.setDate(new Date());
    }

    public void clearPurchaseByID(Integer purchaseID) {
        Purchase purchase = purchaseDAO.getByID(purchaseID);
        purchase.setSum(BigDecimal.ZERO);
        orderDAO.deleteByPurchaseID(purchaseID);
    }

}
